package utils;

public class Stopwatch {
    private static long time;
    public static void start() {
        time = System.currentTimeMillis();
    }

    public static void stop() {
        System.out.println((System.currentTimeMillis() - time) + "ms");
    }

    public static void end() {
        Stopwatch.stop();
    }
}
