package Boecv2_model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Trung Nguyen
 */
public class Image implements HttpSessionBindingListener {
    private String name;
    private int height;
    private int width;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Image(String name, int height, int width) {
        this.name = name;
        this.height = height;
        this.width = width;
    }
    public String toString(int index){
        return toString(index);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        event.getSession().getServletContext().log("Image in the session" +getName());
                
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
         event.getSession().getServletContext().log("Image out the session" +getName());
    }
}
