package catchUpGame;

/**
 * Класс, демонстрирующий поведение потоков при изменении приоритета.
 * @author Малякин Кирилл. гр. 15-20
 */
public class CatchUpGame {

    public static void main(String args[]) throws InterruptedException {
        Thread firstThread = new SideThread();
        Thread secondThread = new SideThread();
        firstThread.setPriority(Thread.MAX_PRIORITY);
        secondThread.setPriority(Thread.MIN_PRIORITY);
        firstThread.setName("Поток с максимальным начальным приоритетом");
        secondThread.setName("Поток с минимальным начальным приоритетом");
        firstThread.start();
        secondThread.start();

    }

    static class SideThread extends Thread {
        private final static int DELAY_TIME = 10; //Время для задержки потока

        private void printInfoAndSleep(int internalCounter) {
            System.out.println(Thread.currentThread().getName() + " - " + internalCounter);
            try {
                Thread.currentThread().sleep(DELAY_TIME);
            } catch (InterruptedException e) {}
        }

        public void run() {
            for (int internalCounter = 0; internalCounter < 30; internalCounter++) {
                printInfoAndSleep(internalCounter);
            }
            Thread.currentThread().setPriority(Thread.currentThread().getPriority() == MAX_PRIORITY ? MIN_PRIORITY : MAX_PRIORITY);
            for (int internalCounter = 30; internalCounter < 100; internalCounter++) {
                printInfoAndSleep(internalCounter);
            }
            System.out.println(Thread.currentThread().getName() + " закончил работу");
        }
    }
}
