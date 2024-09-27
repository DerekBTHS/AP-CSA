import GetDate from "./GetDate.jsx";
import DigitalClock from "./DigitalClock.jsx";
import GetCycleDay from "./GetCycleDay.jsx";

function App() {
    return (
        <>
            <div className="neon-box">
                <GetDate></GetDate>
                <GetCycleDay></GetCycleDay>
            </div>
            <DigitalClock></DigitalClock>
        </>
    );
}

export default App;
