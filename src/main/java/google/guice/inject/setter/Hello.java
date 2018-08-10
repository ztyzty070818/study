package google.guice.inject.setter;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloImpl.class)
public interface Hello {
    void sayHello();
}
