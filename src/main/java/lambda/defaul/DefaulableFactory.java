package lambda.defaul;

import java.util.function.Supplier;

public class DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaulableImpl::new);
        System.out.println(defaulable.notRequired());
    }
}
