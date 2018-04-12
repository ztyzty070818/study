package guava.collections.extra.multimap;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class LinkedHashMultimapTest {
    public static void main(String[] args) {
        Multimap map = LinkedHashMultimap.create();
        map.put("aa","bb");
        System.out.println(map);
    }
}
