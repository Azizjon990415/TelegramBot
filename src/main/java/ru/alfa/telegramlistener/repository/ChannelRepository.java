package ru.alfa.telegramlistener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alfa.telegramlistener.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
