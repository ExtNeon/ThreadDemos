package incrementDataLost;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Кирилл on 03.11.2017.
 */
public class IncrementDataLost {
    private static final int MAX_INC_VAL = 1000000;
    private AtomicInteger incVal = new AtomicInteger(0);
    private volatile int regularInt = 0;
    private int allThreadsIterationSum = 0;

    public boolean stop() {
        ;
       // incVal.incrementAndGet()
        return ++regularInt >= MAX_INC_VAL;
    }

    public void startAll() throws InterruptedException {
        IncThrd threadOne = new IncThrd(this);
        IncThrd threadTwo = new IncThrd(this);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println(incVal.get() + " - Atomic. " + regularInt + " - regular int. Count of iterations: " + allThreadsIterationSum);
        if (allThreadsIterationSum > regularInt) {
            System.out.println((allThreadsIterationSum - regularInt) + " лишних итераций.");
        }

    }

    public void threadCancelled(int i) {
        allThreadsIterationSum += i;
    }
}
