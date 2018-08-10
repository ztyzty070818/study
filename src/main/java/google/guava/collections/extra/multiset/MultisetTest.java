package google.guava.collections.extra.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a",10);
        multiset.add("b",5);

        //[a x 10, b x 5]
        System.out.println(multiset);
        //10
        System.out.println("a:" + multiset.count("a"));

        //只移除一个
        multiset.remove("a");
        //9
        System.out.println("a:" + multiset.count("a"));

        multiset.remove("a",5);
        //4
        System.out.println("a:" + multiset.count("a"));

        multiset.setCount("c",3);
        System.out.println("c:" + multiset.count("c"));

        multiset.setCount("a", 1);System.out.println(multiset);

        multiset.add("a", 1);System.out.println(multiset);


    }



}
