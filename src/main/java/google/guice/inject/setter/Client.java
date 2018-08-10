package google.guice.inject.setter;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Client {
    public static void main(String[] args) {
        Injector in = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {

            }
        });
        HelloCaller helloCaller = in.getInstance(HelloCaller.class);
        helloCaller.sayHello();
    }
}
