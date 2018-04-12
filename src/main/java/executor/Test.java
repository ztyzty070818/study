package executor;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("a"))) {



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader bufferedReader = new BufferedReader(new FileReader("a"));

        bufferedReader.readLine();
    }
}
