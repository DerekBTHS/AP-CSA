import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> schedule = new ArrayList<>();
        List<String> period1 = new ArrayList<String>();
        List<String> period2 = new ArrayList<String>(Arrays.asList("10-14", "30-44", "50-59"));
        List<String> period3 = new ArrayList<String>();
        List<String> period4 = new ArrayList<String>();
        List<String> period5 = new ArrayList<String>();
        List<String> period6 = new ArrayList<String>();
        List<String> period7 = new ArrayList<String>();
        List<String> period8 = new ArrayList<String>();
        schedule.add(period1);
        schedule.add(period2);
        schedule.add(period3);
        schedule.add(period4);
        schedule.add(period5);
        schedule.add(period6);
        schedule.add(period7);
        schedule.add(period8);
        AppointmentBook schedule1 = new AppointmentBook(schedule);
        schedule1.printSchedule();
        System.out.println(schedule1.findFreeBlock(2, 15));
        System.out.println(schedule1.findFreeBlock(2, 9));
        System.out.println(schedule1.findFreeBlock(2, 20));

        schedule.clear();
        period1 = new ArrayList<String>();
        period2 = new ArrayList<String>(Arrays.asList("25-29"));
        period3 = new ArrayList<String>(Arrays.asList("0-14", "41-59"));
        period4 = new ArrayList<String>(Arrays.asList("5-29", "44-59"));
        period5 = new ArrayList<String>();
        period6 = new ArrayList<String>();
        period7 = new ArrayList<String>();
        period8 = new ArrayList<String>();
        schedule.add(period1);
        schedule.add(period2);
        schedule.add(period3);
        schedule.add(period4);
        schedule.add(period5);
        schedule.add(period6);
        schedule.add(period7);
        schedule.add(period8);
        AppointmentBook schedule2 = new AppointmentBook(schedule);
        schedule2.printSchedule();
        System.out.println(schedule2.makeAppointment(2, 4, 22));
        System.out.println(schedule2.makeAppointment(3, 4, 3));
        System.out.println(schedule2.makeAppointment(2, 4, 30));
        schedule2.printSchedule();
    }
}