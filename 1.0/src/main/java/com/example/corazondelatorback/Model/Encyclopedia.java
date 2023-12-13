package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "Encyclopedia")
@Data

public class Encyclopedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String type;
    @Column
    private String title;
    @Column
    private String encyclopediaType;
    @Column
    private String language;
    @Column
    private String author;
    @Column
    private String publicationDate;
    @Column
    private String edition;
    @Column
    private String image;

   //@Column
    //private String borrowStock;
}
