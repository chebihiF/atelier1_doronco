package com.example.atelier1.product;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id @Column(length = 30)
    private String ref ;
    @Size(min = 5, max = 15)
    private String label ;
    private double price ;
    @Max(value = 100) @Min(value = 10)
    private int quantity; // stock
    @ManyToOne
    private Category category ;
}
