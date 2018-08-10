package google.guice.inject.constructor.caller;

import com.google.inject.Inject;
import google.guice.inject.constructor.HelloCaller;

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
