package ru.alfa.telegramlistener.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alfa.telegramlistener.entity.Post;

import java.sql.Timestamp;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAllByDateBefore(Timestamp date, Pageable pageable);
}
