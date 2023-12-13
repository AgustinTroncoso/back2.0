package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "Comic")
@Data

public class Comic {
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
    private String image;
   // @Column este voy a intentar llamarlo desde otro lado
    //private String stock;
  // @Column
   // private String borrowStock;
}
