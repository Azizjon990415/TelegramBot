package ru.alfa.telegramlistener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alfa.telegramlistener.entity.Channel;
import ru.alfa.telegramlistener.entity.Post;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Integer id;
    private String text;
    private Timestamp date;
    private ChannelDTO channelDTO;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.text = post.getText();
        this.date = post.getDate();
        this.channelDTO = new ChannelDTO(post.getChannel());
    }
}
