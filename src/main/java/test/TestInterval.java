package test;

import org.joda.time.Interval;

public class TestInterval {


    public static void main(String[] args) {
        Interval interval = new Interval(1521888824992l, 1522752824983l);

        System.out.println(interval.getChronology());


//        System.out.println(System.currentTimeMillis());
//        System.out.println(new DateTime().minusDays(10).getMillis());
    }
}
