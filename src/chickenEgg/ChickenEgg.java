package chickenEgg;

import static java.lang.Thread.sleep;

/**
 * Это почти что копипаст с хабра.
 */
public class ChickenEgg {

    public static void main(String args[]) throws InterruptedException {
        Egg egg = new Egg();
        egg.start();
        for (int i = 0; i < 10; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {}
            System.out.println("Я считаю, что первой появилась курица!");
        }

        if (egg.isAlive()) {
            egg.join();
            System.out.println("В споре победило яйцо!");
        } else {
            System.out.println("В споре победила курица!");
        }


    }

    private static class Egg extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("Я считаю, что первым появилось яйцо!");
            }
        }
    }
}
