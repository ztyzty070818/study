package test;

import com.google.common.primitives.Ints;

import java.util.Random;

public class RandomString {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            for(int j=0; j<8; j++) {
                System.out.println(RANDOM.nextInt() >>> (j * 4));
            }
        }
//            System.out.println(RANDOM.nextInt() >>> (i * 4));
//            System.out.println(getRandomId());

    }

    private static String getRandomId()
    {
        final StringBuilder suffix = new StringBuilder(8);
        for (int i = 0; i < Ints.BYTES * 2; ++i) {
            suffix.append((char) ('a' + ((RANDOM.nextInt() >>> (i * 4)) & 0x0F)));
        }
        return suffix.toString();
    }

}
