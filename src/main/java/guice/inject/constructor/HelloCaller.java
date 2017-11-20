package guice.inject.constructor;

import com.google.inject.Inject;

public class HelloCaller {
    private Hello hello;
    @Inject
    public HelloCaller(Hello hello) {
        this.hello = hello;
    }

    public void sayHello() {
        hello.sayHello();
    }
}
