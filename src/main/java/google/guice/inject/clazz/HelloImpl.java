package google.guice.inject.clazz;


public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("HelloImpl say Hello");
    }
}
