package guice.inject.setter;

import com.google.inject.Inject;

public class HelloCaller {
    private Hello hello;

    public Hello getHello() {
        return hello;
    }

    @Inject
    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void sayHello() {
        hello.sayHello();
    }
}
