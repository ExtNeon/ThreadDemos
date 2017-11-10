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
        int internalCounter = 0;
        private final static int DELAY_TIME = 10; //Время для задержки потока

        public void run() {
            while (internalCounter < 100) {
                if (internalCounter++ == 30) {
                    Thread.currentThread().setPriority(Thread.currentThread().getPriority() == MAX_PRIORITY ? MIN_PRIORITY : MAX_PRIORITY);
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
