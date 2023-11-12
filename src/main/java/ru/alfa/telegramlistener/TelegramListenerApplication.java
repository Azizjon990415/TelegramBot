package ru.alfa.telegramlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.alfa.telegramlistener.config.TelegramBot;
import ru.alfa.telegramlistener.service.TelegramService;

@SpringBootApplication
public class TelegramListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TelegramListenerApplication.class, args);
    }


}
