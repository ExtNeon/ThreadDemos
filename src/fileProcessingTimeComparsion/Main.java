package fileProcessingTimeComparsion;

/**
 * Created by Кирилл on 23.11.2017.
 */
public class Main {
    private static final String firstInputFile = "src\\fileProcessingTimeComparsion\\files\\input1.txt";
    private static final String firstOutputFile = "src\\fileProcessingTimeComparsion\\files\\output1.txt";
    private static final String secondInputFile = "src\\fileProcessingTimeComparsion\\files\\input2.txt";
    private static final String secondOutputFile = "src\\fileProcessingTimeComparsion\\files\\output2.txt";

    public static void main(String args[]) {
        serialTest();
        parallelTest();
        System.out.println("Тесты выполнены успешно");
    }

    /**
     * Метод выполняет первый тест: последовательное копирование файлов.
     * Алгоритм: скопировать первый файл и замерить время, в течение которого он копировался, затем повторить
     * те же действия со вторым файлом. Вывести время, затраченное обоими потоками.
     */
    private static void serialTest() {
        FileCopyProcessor firstFileCopyProcessor = new FileCopyProcessor(firstInputFile, firstOutputFile);
        FileCopyProcessor secondFileCopyProcessor = new FileCopyProcessor(secondInputFile, secondOutputFile);

        System.out.println("Тест первый: последовательное копирование файлов.");
        System.out.print("Запуск первого потока... ");

        long firstThreadTimeWaste = measureTimeOfSingleThreadRunning(firstFileCopyProcessor);
        System.out.println("Первый поток завершил работу, затратив " + firstThreadTimeWaste + " миллисекунд.");
        System.out.print("Запуск второго потока... ");

        long secondThreadTimeWaste = measureTimeOfSingleThreadRunning(secondFileCopyProcessor);
        System.out.println("Второй поток завершил работу, затратив " + secondThreadTimeWaste + " миллисекунд.");

        System.out.println("\nПервый тест завершён. В общей сложности затрачено " + (firstThreadTimeWaste + secondThreadTimeWaste) + " миллисекунд");
    }

    /**
     * Метод выполняет второй тест: параллельное копирование файлов.
     * Алгоритм: запустить копирование первого и второго файлов в разных потоках; вывести время, затраченное
     * обоими потоками.
     */
    private static void parallelTest() {
        FileCopyProcessor firstFileCopyProcessor = new FileCopyProcessor(firstInputFile, firstOutputFile);
        FileCopyProcessor secondFileCopyProcessor = new FileCopyProcessor(secondInputFile, secondOutputFile);

        System.out.println("\n\nТест второй: параллельное копирование файлов.");
        System.out.print("Запуск потоков... ");

        long allThreadsTimeWaste = measureTimeOfTwoParallelThreadsRunning(firstFileCopyProcessor, secondFileCopyProcessor);

        System.out.println("Второй тест завершён. В общей сложности затрачено " + allThreadsTimeWaste + " миллисекунд");
    }

    /**
     * Возвращает количество миллисекунд, затраченных на выполнение действий в одном потоке
     *
     * Запускает поток, ждёт, пока он полностью выполнится, и возвращает время в миллисекундах,
     * в течение которого выполнялся поток
     * @param thread Исходный поток
     * @return Время в миллисекундах, затраченное на выполнение этого потока.
     */
    private static long measureTimeOfSingleThreadRunning(Thread thread) {
        long lastMSecCount = System.currentTimeMillis();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {}
        return System.currentTimeMillis() - lastMSecCount;
    }

    /**
     * Возвращает количество миллисекунд, в течение которого будут выполнены два параллельных потока.
     *
     * Запускает оба потока, ждёт пока они полностью выполнятся и возвращает время в миллисекундах,
     * в течение которого они выполнялись.
     * @param firstThread Первый поток
     * @param secondThread Второй поток
     * @return Время в миллисекундах, затраченное на выполнение этих потоков.
     */
    private static long measureTimeOfTwoParallelThreadsRunning(Thread firstThread, Thread secondThread) {
        long lastMSecCount = System.currentTimeMillis();
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {};
        return System.currentTimeMillis() - lastMSecCount;
    }
}
