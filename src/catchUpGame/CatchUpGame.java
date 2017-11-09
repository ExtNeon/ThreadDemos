package catchUpGame;

/**
 * Created by Кирилл on 09.11.2017.
 */
public class CatchUpGame extends Thread {
    int internalCounter = 0;

    public void run() {
        while (!isInterrupted() && internalCounter < 200) {
            if (internalCounter++ == 30) {
                Thread.currentThread().setPriority(MIN_PRIORITY);
            }
            System.out.println(Thread.currentThread().getName() + " - " + internalCounter);
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + " закончил работу");
    }

    public static void main(String args[]) throws InterruptedException {
        Thread firstThread = new CatchUpGame();
        Thread secondThread = new SecondThread();
        firstThread.setPriority(MAX_PRIORITY);
        secondThread.setPriority(MIN_PRIORITY);
        firstThread.setName("Поток с максимальным начальным приоритетом");
        secondThread.setName("Поток с минимальным начальным приоритетом");
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
    }

    static class SecondThread extends Thread {
        int internalCounter = 0;

        public void run() {
            while (!isInterrupted() && internalCounter < 200) {
                if (internalCounter++ == 30) {
                    Thread.currentThread().setPriority(MAX_PRIORITY);
                }
                System.out.println(Thread.currentThread().getName() + " - " + internalCounter);
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " закончил работу");
        }
    }
}
