package chapter1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex7Test {

    /**
     Write a static method andThen that takes as parameters two Runnable instances
     and returns a Runnable that runs the first, then the second. In the main method,
     pass two lambda expressions into a call to andThen, and run the returned
     instance.
     */
    @Test
    public void testUncheck_noNeedToCatchCheckedException() throws IOException {
        List<String> messages = new ArrayList<>();

        Ex7.andThen(() -> messages.add("1st runnable"), () -> messages.add("2nd runnable")).run();

        Assertions.assertThat(messages).containsExactly("1st runnable", "2nd runnable");
    }
}
