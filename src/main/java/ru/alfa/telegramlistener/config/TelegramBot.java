package ru.alfa.telegramlistener.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.alfa.telegramlistener.service.TelegramService;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private String botName;
    private String botToken;
    @Autowired
    private TelegramService telegramService;

    public TelegramBot(@Value("${spring.bot-name}") String botName, @Value("${spring.bot-token}") String botToken) {
        super(botToken);
        this.botToken = botToken;
        this.botName = botName;

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasChannelPost()) {
            telegramService.saveChannelMessage(update);
        }
    }

    @Override
    public String getBotUsername() {
        // Return the bot's username
        return botName;
    }

    @Override
    public String getBotToken() {
        // Return the bot's token
        return this.botToken;
    }
}