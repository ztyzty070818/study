package guice.inject.constructor;

import guice.inject.constructor.Hello;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("HelloImpl say Hello");
    }
}
