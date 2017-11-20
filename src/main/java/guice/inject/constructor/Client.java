package guice.inject.constructor;

import com.google.inject.*;

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
