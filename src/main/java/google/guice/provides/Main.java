package google.guice.provides;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Module module = new ChatModule();
        Injector injector = Guice.createInjector(module);
        ChatService chatService = injector.getInstance(ChatService.class);
        chatService.send("Hello world!");
        String receive = chatService.receive();
//        System.out.println(receive);
        logger.info(receive);
    }
}
