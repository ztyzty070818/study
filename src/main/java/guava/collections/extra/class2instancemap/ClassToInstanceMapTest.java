package guava.collections.extra.class2instancemap;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

import java.util.HashMap;
import java.util.Map;
public class ClassToInstanceMapTest {
    public static void main(String[] args) {
        ClassToInstanceMap clazzMap = MutableClassToInstanceMap.create();
        clazzMap.putInstance(Integer.class,10);
        clazzMap.putInstance(Integer.class,11);
        System.out.println(clazzMap.getInstance(Integer.class));


        Map<Class,Object> map = new HashMap<>();
        map.put(Integer.class,10);
        map.put(String.class,"10");
        System.out.println(map.get(Integer.class).getClass());
        System.out.println(map.get(String.class).getClass());
    }
}
