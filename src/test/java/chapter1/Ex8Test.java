package chapter1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex8Test {

    /**
     What happens when a lambda expression captures values in an enhanced
     for loop such as this one?
     String[] names = { "Peter", "Paul", "Mary" };
     List<Runnable> runners = new ArrayList<>();
     for (String name : names)
     runners.add(() -> System.out.println(name));
     Is it legal? Does each lambda expression capture a different value, or do they
     all get the last value?
     */
    @Test
    public void testLambdaContext_enhancedForLoop() throws IOException {
        String[] names = {"Peter", "Paul", "Mary"};
        List<String> resultNames = new ArrayList<>();

        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> resultNames.add(name));
        }

        for (Runnable runner : runners) {
            runner.run();
        }

        Assertions.assertThat(resultNames).containsExactly(names);
    }

    /**
     What happens if you use a traditional loop for (int i = 0; i < names.length; i++)?
     */
    @Test
    public void testLambdaContext_traditionalForLoop() throws IOException {
        String[] names = {"Peter", "Paul", "Mary"};
        List<String> resultNames = new ArrayList<>();

        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            // variables used in lambdas should be effectively final
            final int finalI = i;
            runners.add(() -> resultNames.add(names[finalI]));
        }

        for (Runnable runner : runners) {
            runner.run();
        }

        Assertions.assertThat(resultNames).containsExactly(names);
    }
}
