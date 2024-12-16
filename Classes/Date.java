public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public void print() {
        System.out.println(month + "/" + day + "/" + year);
    }
    
    public void changeMonth(int m) {
        month = m;
    }
    
    public void changeDay(int d) {
        day = d;
    }
    public void changeYear(int y) {
        year = y;
    }
}
