package runnable;

/**
 * Created by Кирилл on 30.10.2017.
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from runnable");
    }

    public static void main(String args[]) throws InterruptedException {
        (new Thread(new HelloRunnable())).start();
        Thread.sleep(2000);
        System.out.println("Our thread was started");
        (new Thread(new ThirdThread())).start();
    }

    static class ThirdThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Third thread was started");
        }
    }
}
