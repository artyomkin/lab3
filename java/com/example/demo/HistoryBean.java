package com.example.demo;


import com.google.gson.Gson;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@Data
public class HistoryBean implements Serializable {

    @Inject
    private DotBean dotBean;

    private List<Dot> dots = new ArrayList<>();

    public void create(Dot dot){
        this.dots.add(dot);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dot);
        transaction.commit();
        session.close();
    }
    public String readAllJSON(){
        return new Gson().toJson(readAll());
    }
    public List<Dot> readAll(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Dot> dots = session.createQuery("from Dot ").list();
        session.close();
        return dots;
    }
    public void deleteAll(){
        this.dots.clear();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        transaction.commit();
        session.close();
    }
    public void hitDot(){
        this.create(new Dot(dotBean.getX(), dotBean.getY(), dotBean.getR(), HitChecker.checkHit(dotBean)));
    }

}
