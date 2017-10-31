package currentThread;

/**
 * Created by Кирилл on 30.10.2017.
 */
public class Main {
    public static void main(String args[]) {
        Thread currentThread = Thread.currentThread();
        System.out.println("Текущий поток: " + currentThread +
                            "\nИмя потока: " + currentThread.getName() +
                            "\nПриоритет потока: " + currentThread.getPriority() +
                            "\nГруппа потока: " + currentThread.getThreadGroup() +
                            "\nИдентефикатор потока: " + currentThread.getId() +
                            "\nСостояние потока: " + currentThread.getState());
    }
}
