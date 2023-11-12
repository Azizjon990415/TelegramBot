package ru.alfa.telegramlistener.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Channel {
    @Id
    private Long id;
    @Column
    private String title;
}
