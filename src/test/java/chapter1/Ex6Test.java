package chapter1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex6Test {

    /**
     * Didn’t you always hate it that you had to deal with checked exceptions in a
     * Runnable? Write a method uncheck that catches all checked exceptions and turns
     * them into unchecked exceptions. For example,
     * new Thread(uncheck(
     * () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
     * // Look, no catch (InterruptedException)!
     * Hint: Define an interface RunnableEx whose run method may throw any exceptions.
     * Then implement public static Runnable uncheck(RunnableEx runner). Use a
     * lambda expression inside the uncheck function.
     */
    @Test
    public void testUncheck_noNeedToCatchCheckedException() throws IOException {
        new Thread(Ex6.uncheck(() -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
    }
}
