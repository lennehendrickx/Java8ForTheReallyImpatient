package chapter1;

import java.io.File;

public class Ex2 {
    public static File[] testListSubdirsUsingLambda(File folder) {
        return folder.listFiles(dir -> dir.isDirectory());
    }

    public static File[] testListSubdirsUsingMethod(File folder) {
        return folder.listFiles(File::isDirectory);
    }


}
