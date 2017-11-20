package guice.inject.clazz;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import guice.inject.field.HelloCaller;

public class Client {
    public static void main(String[] args) {
        Injector in = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Hello.class).to(HelloImpl.class);
            }
        });

        Hello hello = in.getInstance(Hello.class);
        hello.sayHello();
    }
}
