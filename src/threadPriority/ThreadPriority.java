package threadPriority;

import sun.awt.windows.ThemeReader;

/**
 * Created by Кирилл on 06.11.2017.
 */
public class ThreadPriority extends Thread {
    int counter = 0;
    public void run() {
        while (counter++ < 1000000000 && !isInterrupted()) {

        }
        System.out.println(Thread.currentThread().getName() + " - " + counter);
    }

    public static void main(String args[]) throws InterruptedException {
        Thread firstThread = new ThreadPriority();
        Thread secondThread = new ThreadPriority();
        firstThread.setName("Первый поток");
        secondThread.setName("Второй поток");
        firstThread.setPriority(MAX_PRIORITY);
        firstThread.setPriority(MIN_PRIORITY);
        firstThread.start();
        secondThread.start();
        firstThread.join(3);
        secondThread.join(3);
        firstThread.interrupt();
        secondThread.interrupt();
    }
}
