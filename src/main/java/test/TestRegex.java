package test;

import java.io.File;
import java.util.regex.Pattern;

public class TestRegex {

    private static final Pattern GENERATION_FILE_PATTERN = Pattern.compile("^region_gen_(\\d+)$");

    public static void main(String[] args) {

        File storageDir = new File("/tmp/test");
        File[] genFiles = storageDir.listFiles(
                (dir, name) -> GENERATION_FILE_PATTERN.matcher(name).matches()
        );

        for(int i=0; i<genFiles.length; i++) {
            System.out.println(genFiles[i]);
        }
    }
}
