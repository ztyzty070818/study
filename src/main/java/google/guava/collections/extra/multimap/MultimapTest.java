package google.guava.collections.extra.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

public class MultimapTest {

    public static void main(String[] args) {
        Multimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("a","ab");
        multimap.put("a","bc");
        System.out.println(multimap);

        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("c");
        list.add("a");
        multimap.putAll("b",list);
        System.out.println(multimap);

        multimap.remove("a","ab");
        System.out.println(multimap);

        multimap.replaceValues("a", ImmutableSet.of("c"));
        System.out.println(multimap);

        System.out.println(multimap.keys());
        System.out.println(multimap.values());
        System.out.println(multimap.keySet());
    }

}
