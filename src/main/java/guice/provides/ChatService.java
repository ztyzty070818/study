package guice.provides;

public interface ChatService {

    void send(String message);

    String receive();
}