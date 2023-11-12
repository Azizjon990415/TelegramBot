package ru.alfa.telegramlistener.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.alfa.telegramlistener.model.PostDTO;

import java.sql.Timestamp;

public interface PostService {
    Page<PostDTO> getPostsBefore(Timestamp time, Pageable pageable);
}
