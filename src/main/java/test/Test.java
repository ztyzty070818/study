package test;


import java.util.ArrayList;
import java.util.List;

public class Test<T extends Fruit> {
    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<Apple>();
        Apple apple = new Apple();
    }

    public void test() {
    }
}

class Fruit{

}

class Apple extends Fruit {

}


