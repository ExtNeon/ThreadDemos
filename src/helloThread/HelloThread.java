package helloThread;

/**
 * Created by Кирилл on 02.11.2017.
 */
public class HelloThread extends Thread{
    public void run() {
        System.out.println("Hello from new THREAD!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
        System.out.println("Hello from main thread.");
    }
}
