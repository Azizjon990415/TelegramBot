package ru.alfa.telegramlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.alfa.telegramlistener.entity.Channel;
import ru.alfa.telegramlistener.entity.Post;
import ru.alfa.telegramlistener.repository.ChannelRepository;
import ru.alfa.telegramlistener.repository.PostRepository;

import java.sql.Timestamp;


@Service
public class TelegramServiceImpl implements TelegramService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private PostRepository postRepository;

    //http://localhost/api/post?time=2023-11-13 01:09:36&page=0&size=10 for testing
    @Override
    public void saveChannelMessage(Update update) {
        Message channelPost = update.getChannelPost();
        Chat chat = channelPost.getChat();
        Channel channel = channelRepository.findById(chat.getId()).orElse(channelRepository.save(new Channel(chat.getId(), chat.getTitle())));
        postRepository.save(new Post(channelPost.getMessageId(), channelPost.getText(), new Timestamp(channelPost.getDate()), channel));
    }
}
