package test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public class TestRegex {


    public static void main(String[] args) {
        test();
    }

    public static Integer test() {
        try {
            return 1;
        } finally {
            System.out.println("finally");
        }
    }
}
