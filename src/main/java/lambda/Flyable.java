package lambda;

@FunctionalInterface
public interface Flyable {
    void fly();

    static void getMessage() {
        System.out.println("get message");
    }
}
