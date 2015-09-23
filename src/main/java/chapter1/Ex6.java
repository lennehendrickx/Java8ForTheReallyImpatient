package chapter1;

public class Ex6 {
    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    interface RunnableEx {
        void run() throws InterruptedException;
    }
}
