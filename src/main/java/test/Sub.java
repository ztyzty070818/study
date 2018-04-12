package test;

import java.util.HashMap;
import java.util.Map;

public abstract class Sub<T> {
    public static void main(String[] args) {
        Map<Float,String> map = new HashMap<>();
        for(int i =0; i< 100000; i++) {
            map.put(1.0f,i + "");
        }
        System.out.println(map.size());
    }
}
