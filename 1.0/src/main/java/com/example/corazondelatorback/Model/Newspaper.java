package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "Newspaper")
@Data

public class Newspaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String type;
    @Column
    private String title;
    @Column
    private String brand;
    @Column
    private String publicationDate;
    @Column
    private String edition;
    @Column
    private String editor;
    @Column
    private String image;

    //@Column
    //private String borrowStock;
}
