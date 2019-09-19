import java.util.Random;

public class PoissonProblemByProgram {
    // 艾波寧捎信
    // http://vdisk.weibo.com/s/dAX6zUO1GO9wS
    public static void main(String[] args) {
        int times = 100000;
        int milliseconds = 100;

        long start = System.currentTimeMillis();
        System.out.println(probability(milliseconds, times));
        long end = System.currentTimeMillis();
        System.out.printf("run time:%dms\n", end - start);
    }

    private static double probability(int milliseconds, int times) {
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (alive(milliseconds))
                count++;
        }
        return (double)count / times;
    }

    private static boolean alive(double milliseconds) {
        double seconds = milliseconds / 1000;
        double shootPerSecond = Math.log1p(49) / 100;
        double p = shootPerSecond * seconds;
        double speed = 4;
        final double L = 400;

        double distance = 0;
        double ds;
        Random rdm = new Random();
        while (distance < L) {
            if (rdm.nextDouble() < p) {
                if (speed == 0.5)
                    return false;
                speed /= 2;
            }
            ds = speed * seconds;
            distance += ds;
        }
        return true;
    }
}
