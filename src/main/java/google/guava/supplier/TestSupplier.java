package google.guava.supplier;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.concurrent.TimeUnit;

public class TestSupplier {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
//        testMemoize();
        testExpireMemoize();
    }

    public static void testMemoize() {
        Supplier supplier = Suppliers.memoize(()-> {
            System.out.println("instance");
            i++;
            return i;
        });

        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

    public static void testExpireMemoize() throws InterruptedException {
        Supplier supplier = Suppliers.memoizeWithExpiration(()-> {
            System.out.println("instance");
            i++;
            return i;
        }, 5, TimeUnit.SECONDS);

        for(int i=0; i<10; i++) {
            System.out.println(supplier.get());
            Thread.sleep(3000);
        }
    }
}
