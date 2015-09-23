package chapter1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex4Test {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     Given an array of File objects, sort it so that the directories come before the
     files, and within each group, elements are sorted by path name. Use a lambda
     expression, not a Comparator.
     */
    @Test
    public void testSortFiles_usingLambda() throws IOException {
        File subfolderA = folder.newFolder("subfolderA");
        File subfolderB = folder.newFolder("subfolderB");
        File newfileA = folder.newFile("newfileA");
        File newfileB = folder.newFile("newfileB");

        File[] filesToSort = {newfileB, newfileA, subfolderB, subfolderA};
        Arrays.sort(filesToSort, comparing(File::isDirectory).reversed().thenComparing(File::getName));

        assertThat(filesToSort).containsExactly(subfolderA, subfolderB, newfileA, newfileB);
    }
}
