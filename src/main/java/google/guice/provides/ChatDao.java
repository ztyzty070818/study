package google.guice.provides;

public interface ChatDao {

    void send(String message);

    String receive();
}
