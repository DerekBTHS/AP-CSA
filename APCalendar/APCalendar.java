public class APCalendar {
    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year) {
        /* implementation not shown */
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }
    /** Returns the number of leap years between year1 and year2, inclusive.
    * Precondition: 0 <= year1 <= year2
    */
    public static int numberOfLeapYears(int year1, int year2) {
        int count = 0;
        for (int i = year1; i < year2 + 1; i++) {
            if (isLeapYear(i)) {
                count++;
            }
        }
        return count;
        /* to be implemented in part (a) */
    }
    /** Returns the value representing the day of the week for the first day of year,
    * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
    */
    private static int firstDayOfYear(int year) {
        /* implementation not shown */
        int baseYear = 1900;
        int totalYears = year - 1 - baseYear;
        int leapYears = totalYears / 4;
        int nonLeapYears = totalYears - leapYears;
        int totalDays = leapYears * 366 + nonLeapYears * 365 + 1;
        return totalDays % 7;

    }
    /** Returns n, where month, day, and year specify the nth day of the year.
    * Returns 1 for January 1 (month = 1, day = 1) of any year.
    * Precondition: The date represented by month, day, year is a valid date.
    */
    private static int dayOfYear(int month, int day, int year) {
        /* implementation not shown */
        int n = 0;
        int[] daysOfMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month <= 1) {
            return day;
        }
        for (int i = 0; i < month - 1; i++) {
            n += daysOfMonths[i];
        }
        if (isLeapYear(year) && month >= 2) {
            n++;
        }
        return n + day;
    }
    /** Returns the value representing the day of the week for the given date
    * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
    * and 6 denotes Saturday.
    * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) {
        int start = firstDayOfYear(year);
        /* to be implemented in part (b) */
        return (start + dayOfYear(month, day, year)) % 7;
    }
    // There may be instance variables, constructors, and other methods not shown.
}
