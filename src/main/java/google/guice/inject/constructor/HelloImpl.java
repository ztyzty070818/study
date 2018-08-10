package google.guice.inject.constructor;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("HelloImpl say Hello");
    }
}
