package ru.alfa.telegramlistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.alfa.telegramlistener.model.PostDTO;
import ru.alfa.telegramlistener.repository.PostRepository;

import java.sql.Timestamp;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Page<PostDTO> getPostsBefore(Timestamp time, Pageable pageable) {
        return postRepository.findAllByDateBefore(time,pageable).map(PostDTO::new);
    }
}
