package ex2;

import java.io.File;
import java.io.FileFilter;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Ex2 {
    public static void main(String[] args) {
        FileFilter filterDirectories = dir -> dir.isDirectory();

        String dirlist = stream(new File("c:\\Temp").listFiles(File::isDirectory))
                .map(Object::toString)
                .collect(joining(", "));
        System.out.println(dirlist);
    }
}
