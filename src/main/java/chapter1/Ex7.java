package chapter1;

public class Ex7 {
    public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }
}
