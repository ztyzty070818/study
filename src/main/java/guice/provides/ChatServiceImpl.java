package guice.provides;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatServiceImpl implements ChatService {
    private Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Inject
    private ChatDao chatDao;

    @Override
    public void send(String message) {
        logger.info("Sending a message!");
        chatDao.send(message);
        logger.info("Sended a message!");
    }

    @Override
    public String receive() {
        logger.info("Received a message!");
        return chatDao.receive();
    }
}
