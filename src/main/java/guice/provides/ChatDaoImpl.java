package guice.provides;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatDaoImpl implements ChatDao {
    private Logger logger = LoggerFactory.getLogger(ChatDaoImpl.class);

    @Override
    public void send(String message) {
        logger.info(message);
    }

    @Override
    public String receive() {
        return "receive message content!";
    }
}
