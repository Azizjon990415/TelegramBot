package ru.alfa.telegramlistener.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column
    private Timestamp date;
    @ManyToOne
    private Channel channel;
}
