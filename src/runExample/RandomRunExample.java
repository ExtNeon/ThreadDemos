package runExample;

/**
 * Created by Кирилл on 03.11.2017.
 */
public class RandomRunExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * Создание и запуск 10 потоков
     */
    public static void example() {
        for (int i = 0; i < 10; i++) {
            (new RandomRunExample()).start();
        }
    }
}
