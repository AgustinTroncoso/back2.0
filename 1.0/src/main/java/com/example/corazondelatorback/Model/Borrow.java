package com.example.corazondelatorback.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "Borrow")
@Data

public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String customerToBorrow;
    @Column
    private String rutCustomerToBorrow;
    @Column
    private String borrowedBook;
    @Column
    private String borrowDate;
    @Column
    private String returnDate;
    @Column
    private String authorizedBy;
    @Column
    private String passReturnDate;
    @Column
    private String state ;
}
