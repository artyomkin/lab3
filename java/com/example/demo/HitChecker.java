package com.example.demo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

public class HitChecker {

    public static boolean checkHit(DotBean dotBean){
        Double x = dotBean.getX();
        Double y = dotBean.getY();
        Double r = dotBean.getR();
        return x <= 0 && y >= 0 && x*x + y*y <= r * r / 4 ||
                x <= 0 && y <= 0 && x >= -r/2 && y >= -r ||
                x >= 0 && y <= 0 && x-r <= y;

    }

}
