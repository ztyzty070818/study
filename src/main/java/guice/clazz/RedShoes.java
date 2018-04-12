package guice.clazz;

public class RedShoes implements People.Shoes {
    @Override
    public void getColor() {
        System.out.println("red shoes");
    }
}
