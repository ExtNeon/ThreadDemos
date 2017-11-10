package catchUpGame;

/**
 * Класс, демонстрирующий поведение потоков при изменении приоритета.
 * @author Малякин Кирилл. гр. 15-20
 */
public class CatchUpGame extends Thread {
    private final static int DELAY_TIME = 10; //Время для задержки каждого потока

    int internalCounter = 0;

    public void run() {
        while (internalCounter < 100) {
            if (internalCounter++ == 30) {
                Thread.currentThread().setPriority(MIN_PRIORITY);
            }
            System.out.println(Thread.currentThread().getName() + " - " + internalCounter);
            try {
                Thread.currentThread().sleep(DELAY_TIME);
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

    }

    static class SecondThread extends Thread {
        int internalCounter = 0;

        public void run() {
            while (internalCounter < 100) {
                if (internalCounter++ == 30) {
                    Thread.currentThread().setPriority(MAX_PRIORITY);
                }
                System.out.println(Thread.currentThread().getName() + " - " + internalCounter);
                try {
                    Thread.currentThread().sleep(DELAY_TIME);
                } catch (InterruptedException e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " закончил работу");
        }
    }
}
