package google.guice.clazz;

public class BigClothes implements People.Clothes {
    @Override
    public void getSize() {
        System.out.println("big clothes");
    }
}
