package nio;

import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ReadLineTest {
    public static void main(String[] args) throws IOException {
        readLine();
    }

    public static void readLine() throws IOException {
        File file = null, test = null;
        try {
            file = Files.createTempDir();

            test = new File(file, "test");

            try(BufferedWriter bufferedWriter = Files.newWriter(test, Charset.defaultCharset());
                BufferedReader bufferedReader = Files.newReader(test, Charset.defaultCharset())) {
                bufferedWriter.write("first");
                bufferedWriter.write("second");
                System.out.println(file.getName());

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } finally {
            System.out.println(test.delete());
            System.out.println(file.delete());
        }
    }
}
