package com.example.demo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Named
@SessionScoped
public class ClockBean implements Serializable {
    private LocalTime time = LocalTime.now();
    private boolean running = false;
    private String currentTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    public void init(){
        running = true;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate((()->{
            time = LocalTime.now();
        }),0,1, TimeUnit.SECONDS);
    }

    public String getCurrentTime() {
        if (!running){
            init();
        }
        return this.formatter.format(time);
    }
}
