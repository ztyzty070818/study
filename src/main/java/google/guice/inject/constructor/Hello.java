package google.guice.inject.constructor;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloImpl.class)
public interface Hello {
    void sayHello();
}
