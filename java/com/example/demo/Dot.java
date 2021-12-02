package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="dots")
public class Dot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="x")
    private Double x;
    @Column(name="y")
    private Double y;
    @Column(name="r")
    private Double r;
    @Column(name="hit")
    private boolean hit;

    public Dot() {
        this.x = 0D;
        this.y = 0D;
        this.r = 0D;
        this.hit = false;
    }

    public Dot(Double x, Double y, Double r, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }


}
