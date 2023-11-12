package ru.alfa.telegramlistener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alfa.telegramlistener.model.PostDTO;
import ru.alfa.telegramlistener.service.PostService;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<Page<PostDTO>> getPostsByDate(@RequestParam Timestamp time, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(postService.getPostsBefore(time, PageRequest.of(page, size)));
    }
}
