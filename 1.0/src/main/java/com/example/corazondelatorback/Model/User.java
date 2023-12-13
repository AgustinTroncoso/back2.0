package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String user;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String position;
    @Column
    private String creationDate;
    @Column
    private String genre;

}
