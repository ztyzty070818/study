package guava.collections.collections2.lists;

import com.google.common.collect.Lists;

import java.util.List;

public class ListsTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a","b","c","d","e");
        System.out.println(list);
        System.out.println(Lists.reverse(list));
        List<List<String>> parts = Lists.partition(list,2);
        System.out.println(parts);
    }
}
