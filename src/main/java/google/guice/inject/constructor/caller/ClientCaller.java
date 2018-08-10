package google.guice.inject.constructor.caller;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ClientCaller {
    public static void main(String[] args) {
        Injector in = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {

            }
        });
        HelloCallerCaller helloCallerCaller = in.getInstance(HelloCallerCaller.class);
        helloCallerCaller.sayHello();
    }
}
