package google.guava.collections.extra.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String,Integer> userId = HashBiMap.create();
        userId.put("a",1);
        userId.put("a",2);
        userId.put("c",3);


        System.out.println(userId.inverse().get(3));
        System.out.println(userId.inverse().get(2));
        System.out.println(userId.inverse().get(1));
        System.out.println(userId.values());
        System.out.println(userId.inverse().values());
    }

}
