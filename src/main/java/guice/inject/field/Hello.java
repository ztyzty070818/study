package guice.inject.field;

import com.google.inject.ImplementedBy;
@ImplementedBy(HelloImpl2.class)
public interface Hello {
    void sayHello();
}
