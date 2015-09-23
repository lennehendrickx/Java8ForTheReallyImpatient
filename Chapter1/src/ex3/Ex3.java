package ex3;

import java.io.File;
import java.io.FilenameFilter;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Ex3 {
    public static void main(String[] args) {
        String dirlist = stream(new File("c:\\Temp").listFiles(filterExtension(".txt")))
                .map(Object::toString)
                .collect(joining(", "));
        System.out.println(dirlist);
    }

    private static FilenameFilter filterExtension(String extension) {
        return (dir, name) -> name.endsWith(extension);
    }
}
