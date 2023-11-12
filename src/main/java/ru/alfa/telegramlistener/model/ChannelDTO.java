package ru.alfa.telegramlistener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alfa.telegramlistener.entity.Channel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDTO {
    private Long id;
    private String title;

    public ChannelDTO(Channel channel) {
        this.id = channel.getId();
        this.title = channel.getTitle();
    }
}
