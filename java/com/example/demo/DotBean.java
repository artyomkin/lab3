package com.example.demo;
import com.google.gson.Gson;
import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Named
@SessionScoped
@Data
public class DotBean implements Serializable {

    private int id;

    @NotNull(message="x must not be null")
    private Double x;

    @NotNull(message="y must not be null")
    private Double y;

    @NotNull(message="r must not be null")
    private Double r;

    private boolean isHit;

    public DotBean(){
        x = 0D;
        y = 0D;
        r = 5D;
        isHit = true;
    }

    public DotBean(double x, double y, double r, boolean hit){
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = hit;
    }
    
    public DotBean(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }


}
