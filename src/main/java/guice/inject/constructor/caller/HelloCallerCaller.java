package guice.inject.constructor.caller;

import com.google.inject.Inject;
import guice.inject.constructor.HelloCaller;

public class HelloCallerCaller {
    HelloCaller helloCaller;
    @Inject
    public HelloCallerCaller(HelloCaller helloCaller) {
        this.helloCaller = helloCaller;
    }

    public void sayHello() {
        helloCaller.sayHello();
    }
}
