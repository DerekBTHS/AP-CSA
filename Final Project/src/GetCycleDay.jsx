import React, { useEffect, useState } from "react";
import ical from "ical.js";

const GetCycleDay = () => {
    const [events, setEvents] = useState([]);
    const [loading, setLoading] = useState(true); // State to handle loading

    useEffect(() => {
        fetchICalData();
    }, []);

    const fetchICalData = async () => {
        try {
            const response = await fetch("/src/assets/ical.ics"); // Ensure the path is correct
            const icalData = await response.text();
            parseICalData(icalData);
        } catch (error) {
            console.error("Error fetching the iCal data:", error);
        } finally {
            setLoading(false); // Stop loading once data is fetched
        }
    };

    const parseICalData = (icalData) => {
        try {
            const jcalData = ical.parse(icalData);
            const comp = new ical.Component(jcalData);
            const vevents = comp.getAllSubcomponents("vevent");
            const today = new Date(); // Get today's date as a JS Date object

            const todayEvents = vevents.reduce((acc, event) => {
                try {
                    const dtstart = event.getFirstPropertyValue("dtstart").toJSDate();

                    // Check if dtstart is valid
                    if (isNaN(dtstart.getTime())) {
                        console.warn("Skipping event with invalid date:", event);
                        return acc; // Skip invalid dates
                    }

                    // Handle recurring events using RRULE
                    const rrule = event.getFirstPropertyValue("rrule");
                    if (rrule) {
                        const recur = new ical.RecurExpansion({
                            component: event,
                            dtstart: event.getFirstPropertyValue("dtstart"),
                        });

                        while (recur.next()) {
                            const occurrenceDate = recur.last.toJSDate();
                            const occurrenceDateString = occurrenceDate
                                .toISOString()
                                .split("T")[0];
                            if (
                                occurrenceDateString === today.toISOString().split("T")[0]
                            ) {
                                acc.push(event);
                            }
                        }
                    } else {
                        // Non-recurring event: just check if it happens today
                        if (
                            dtstart.toISOString().split("T")[0] ===
                            today.toISOString().split("T")[0]
                        ) {
                            acc.push(event);
                        }
                    }
                } catch (error) {
                    console.error("Error parsing event:", event, error);
                }
                return acc;
            }, []);

            setEvents(todayEvents);
        } catch (error) {
            console.error("Error parsing iCal data:", error);
        }
    };

    if (loading) {
        return (
            <div className="cycle-container">
                <div className="cycle">Loading...</div> // Show loading indicator while data is being
                fetched
            </div>
        );
    }

    return (
        <div className="cycle-container">
            <div className="cycle">
                {events.length > 0 ? (
                    events.map((event, index) => (
                        <span key={index}>{event.getFirstPropertyValue("summary")}</span>
                    ))
                ) : (
                    <div>No events today</div> // Handle case where there are no events
                )}
            </div>
        </div>
    );
};

export default GetCycleDay;
