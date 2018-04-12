package guava.collections.extra.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.*;

public class MultisetForMap {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("b");
        list.add("a");
        list.add("c");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);


        Multiset multiset = HashMultiset.create();
        multiset.addAll(list);
        multiset.addAll(list);
        System.out.println(multiset);
        multiset.addAll(set);
        System.out.println(multiset);
        System.out.println("size:" + multiset.size());

        System.out.println(multiset.elementSet());

        Set<Multiset.Entry> entries = multiset.entrySet();
        Iterator<Multiset.Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Multiset.Entry entry = iterator.next();
            System.out.println(entry.getElement() + ":" + entry.getCount());
        }
    }
}
