package google.guava.collections.extra.rangeset;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetTest {
    public static void main(String[] args) {
        RangeSet<Double> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(1.1,10.3));
        System.out.println(rangeSet);

        rangeSet.add(Range.closed(0.1,5.1));
        System.out.println(rangeSet);

        rangeSet.add(Range.closed(100.1,200.0));
        System.out.println(rangeSet);

        rangeSet.remove(Range.closedOpen(5.0,200.0));
        System.out.println("rangSet:" + rangeSet);

        System.out.println("complement:" + rangeSet.complement());
        System.out.println(rangeSet.subRangeSet(Range.closed(0.3,5.2)));
        System.out.println(rangeSet.encloses(Range.closed(0.3,4.9)));
        System.out.println(rangeSet.span());
        System.out.println(rangeSet.contains(4.9));
        System.out.println(rangeSet.rangeContaining(200.0));
    }
}
