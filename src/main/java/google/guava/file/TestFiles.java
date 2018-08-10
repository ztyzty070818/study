package google.guava.file;

import com.google.common.io.Files;
import org.apache.commons.io.Charsets;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) throws IOException {
        File origin = new File("/tmp/google.guava/original");

        File copy = new File("/tmp/google.guava/copy");

//        Files.move(new File("/tmp/google.guava/origin"), new File("/tmp/google.guava/original"));

//        Files.copy(origin, copy);

        String finalStr = "final";

//        Files.write(finalStr, origin);

        String hamletQuoteStart = "To be, or not to be";
        Files.append(hamletQuoteStart, origin, Charsets.UTF_8);


        List<String> fileLines = Files.readLines(origin, Charsets.UTF_8);



        System.out.println(fileLines);
    }
}
