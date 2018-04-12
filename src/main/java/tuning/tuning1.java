package tuning;

import org.joda.time.DateTime;

public class tuning1 {
    public static void main(String[] args) {

        DateTime dateTime1 = new DateTime();

        System.out.println(dateTime1);
        int[] arr = mkArr();

        DateTime dateTime2 = new DateTime();
        System.out.println(dateTime2);



    }

    static int[] mkArr() {
        int[] arr = new int[10000000];
        return arr;
    }
}
