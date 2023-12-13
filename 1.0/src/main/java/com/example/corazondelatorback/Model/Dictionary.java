package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "Dictionary")
@Data

public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String type;
    @Column
    private String author;
    @Column
    private String title;
    @Column
    private String publicationDate;
    @Column
    private String edition;
    @Column
    private String editor;
    @Column
    private String category;
    @Column
    private String language;
    @Column
    private String image;

   // @Column
    //private String borrowStock;

}
