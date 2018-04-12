package lambda.defaul;

public interface Defaulable {
    default String notRequired() {
        return "Defalut implementation";
    }
}
