package chapter1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex2Test {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testListsubdirs_usingLambda() throws IOException {
        File subfolder = folder.newFolder("subfolder");
        folder.newFile("newfile");

        assertThat(Ex2.testListSubdirsUsingLambda(folder.getRoot())).containsExactly(subfolder);
    }

    @Test
    public void testListsubdirs_usingMethod() throws IOException {
        File subfolder = folder.newFolder("subfolder");
        folder.newFile("newfile");

        assertThat(Ex2.testListSubdirsUsingMethod(folder.getRoot())).containsExactly(subfolder);
    }
}
