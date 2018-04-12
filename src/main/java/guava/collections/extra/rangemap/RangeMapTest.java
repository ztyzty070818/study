package guava.collections.extra.rangemap;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class RangeMapTest {
    public static void main(String[] args) {
        RangeMap<Integer,String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1,10),"a");
        rangeMap.put(Range.closed(3,7),"b");
        rangeMap.put(Range.closed(5,20),"a");
        rangeMap.remove(Range.closed(4,6));

        System.out.println(rangeMap);
        System.out.println(rangeMap.asMapOfRanges());
        System.out.println(rangeMap.subRangeMap(Range.closed(2,100)));
    }
}
