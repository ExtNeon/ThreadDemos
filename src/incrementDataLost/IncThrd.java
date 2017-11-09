package incrementDataLost;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Кирилл on 03.11.2017.
 */
public class IncThrd extends Thread {
    IncrementDataLost incDataLost;
    int i = 0;
    public void run() {
        System.out.println("Поток " + this.getName() + " запущен");
        while(!incDataLost.stop()){i++;};
        System.out.println("Поток " + this.getName() + " остановлен. " + i + " итераций пройдено");
    }

    public IncThrd(IncrementDataLost incDataLost) {
        this.incDataLost = incDataLost;
    }
}
