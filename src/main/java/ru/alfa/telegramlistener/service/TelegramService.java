package ru.alfa.telegramlistener.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {
    public void saveChannelMessage(Update update);
}
