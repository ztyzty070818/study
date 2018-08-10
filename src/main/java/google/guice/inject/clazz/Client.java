package google.guice.inject.clazz;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Client {
    public static void main(String[] args) {
        Injector in = Guice.createInjector(
            (binder) -> binder.bind(Hello.class).to(HelloImpl.class)
        );

        Hello hello = in.getInstance(Hello.class);
        hello.sayHello();
    }
}
