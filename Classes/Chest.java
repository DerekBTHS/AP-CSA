public class Chest {
    Thread thread;
    int count;

    public Chest(Thread t, int c) {
        thread = t;
        count = c;
    }
    
    public Thread getThread() {
        return thread;
    }

    public int getCount() {
        return count;
    }
}
