package com.example.demo;

import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@SessionScoped
@Data
public class DotConstraintsBean implements Serializable {
    private final long MIN_X = -5l;
    private final long MAX_X = 3l;
    private final long MIN_Y = -3l;
    private final long MAX_Y = 3l;
    private final long MIN_R = 1l;
    private final long MAX_R = 5l;
    private final List<Double> valsX = new ArrayList<Double>(Arrays.asList(-5D,-4D,-3D,-2D,-1D,0D,1D,2D,3D));
    private final List<Double> valsR = new ArrayList<Double>(Arrays.asList(1D,2D,3D,4D,5D));
}
