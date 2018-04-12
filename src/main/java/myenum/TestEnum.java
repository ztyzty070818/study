package myenum;

public class TestEnum {
    public static void main(String[] args) {
//        for(Food.Coffee.valueOf("CAKE"))
        System.out.println(Food.Dessert.valueOf("CAKE"));
    }

    static final String MYNAME = TestStatic.NAME;
}
