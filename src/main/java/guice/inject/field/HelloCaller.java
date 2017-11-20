package guice.inject.field;


import com.google.inject.Inject;

public class HelloCaller {

    @Inject
    private Hello hello;
    public void sayHello() {
        hello.sayHello();
    }
}
