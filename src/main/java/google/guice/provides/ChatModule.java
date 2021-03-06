package google.guice.provides;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

public class ChatModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ChatService.class).to(ChatServiceImpl.class);
    }

    @Inject
    @Provides
    protected ChatDao provideChatDao() {
        ChatDao chatDao = new ChatDaoImpl();
        return chatDao;
    }
}
