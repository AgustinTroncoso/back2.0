package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "ReadingBook")
@Data
public class ReadingBook {
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
    private String genre;
    @Column
    private String language;
    @Column
    private String image;

    //@Column
   // private String borrowStock;
}
