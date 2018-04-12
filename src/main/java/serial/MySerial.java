package serial;

import java.io.Serializable;

public class MySerial implements Serializable {

    private static final long serialVersionUID = 5253906912546062984L;
    private String name;

    public static void main(String[] args) {
        new MySerial();
    }
}
