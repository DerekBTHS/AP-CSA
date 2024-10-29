import java.util.List;

public class AppointmentBook {
    
    private List<List<String>> times;

    public AppointmentBook(List<List<String>> availablity) {
        times = availablity;
    }

    public void printSchedule() {
        for (int i = 0; i < times.size(); i++) {
            System.out.println("Period " + (i + 1) + " : " + times.get(i));
        }
    }

    /**
     * Returns true if minute in period is available for an appointment and returns
     * false otherwise
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
     */
    private boolean isMinuteFree(int period, int minute) {
        /* implementation not shown */
        for (String free : times.get(period - 1)) {
            if (minute >= Integer.parseInt(free.split("[-]")[0])
                    && minute <= Integer.parseInt(free.split("[-]")[1])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Marks the block of minutes that starts at startMinute in period and
     * is duration minutes long as reserved for an appointment
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
     * 1 <= duration <= 60
     */
    private void reserveBlock(int period, int startMinute, int duration) {
        /* implementation not shown */
        for (int i = 0; i < times.get(period - 1).size(); i++) {
            if (startMinute >= Integer.parseInt(times.get(period - 1).get(i).split("[-]")[0])) {
                times.get(period - 1).set(i,
                        (startMinute + duration) + "-" + times.get(period - 1).get(i).split("[-]")[1]);
                break;
            }
        }
    }

    /**
     * Searches for the first block of duration free minutes during period, as
     * described in
     * part (a). Returns the first minute in the block if such a block is found or
     * returns -1 if no
     * such block is found.
     * Preconditions: 1 <= period <= 8; 1 <= duration <= 60
     */
    public int findFreeBlock(int period, int duration) {
        /* to be implemented in part (a) */
        int streak = 0;
        for (int i = 0; i < 60; i++) {
            if (isMinuteFree(period, i)) {
                streak++;
            } else {
                streak = 0;
            }
            if (streak >= duration) {
                return i - streak + 1;
            }
        }
        return -1;
    }

    /**
     * Searches periods from startPeriod to endPeriod, inclusive, for a block
     * of duration free minutes, as described in part (b). If such a block is found,
     * calls reserveBlock to reserve the block of minutes and returns true;
     * otherwise
     * returns false.
     * Preconditions: 1 <= startPeriod <= endPeriod <= 8; 1 <= duration <= 60
     */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        /* to be implemented in part (b) */
        boolean availableTime = false;
        for (int i = startPeriod; i < endPeriod + 1; i++) {
            if (findFreeBlock(i, duration) >= 0) {
                availableTime = true;
                // System.out.println(i);
                // System.out.println(findFreeBlock(i, duration));
                // System.out.println(duration);
                reserveBlock(i, findFreeBlock(i, duration), duration);
                break;
            }
        }
        if (availableTime) {
            return true;
        }
        return false;
    }

    public void test() {
        reserveBlock(3, 0, 3);
        printSchedule();
    }

    // There may be instance variables, constructors, and methods that are not shown.
}