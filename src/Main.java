import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main extends Thread{
    static  int[] array = new int[10_000_000];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt();
        }
        ArrayAverage ArAverage1 = new ArrayAverage(0, 2_500_000, array);
        ArrayAverage ArAverage2 = new ArrayAverage(2_500_000, 5_000_000, array);
        ArrayAverage ArAverage3 = new ArrayAverage(5_000_000, 7_500_000, array);
        ArrayAverage ArAverage4 = new ArrayAverage(7_500_000, 10_000_000, array);
        Logger logger = Logger.getLogger(Main.class.getName());

        Thread t1 = new Thread(ArAverage1);
        t1.start();
        ArAverage1.run();

        Thread t2 = new Thread(ArAverage2);
        t2.start();
        ArAverage2.run();

        Thread t3 = new Thread(ArAverage3);
        t3.start();
        ArAverage3.run();

        Thread t4 = new Thread(ArAverage4);
        t4.start();
        ArAverage4.run();

        try {
            t1.join();
            logger.log(Level.INFO, "Среднее арифметическое 1й части: " + ArAverage1.getAverage());
            t2.join();
            logger.log(Level.INFO, "Среднее арифметическое 2й части: " + ArAverage2.getAverage());
            t3.join();
            logger.log(Level.INFO, "Среднее арифметическое 3й части: " + ArAverage3.getAverage());
            t4.join();
            logger.log(Level.INFO, "Среднее арифметическое 4й части: " + ArAverage4.getAverage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.log(Level.INFO, "Среднее арифметическое всех частей массива: "
                + (ArAverage1.getAverage() + ArAverage2.getAverage() + ArAverage3.getAverage() +
                ArAverage4.getAverage())/4);
    }
}
