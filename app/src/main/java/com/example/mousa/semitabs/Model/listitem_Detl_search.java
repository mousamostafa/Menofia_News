package com.example.mousa.semitabs.Model;

/**
 * Created by Mousa on 1/28/2018.
 */

public class listitem_Detl_search{
    public String title;
    public String info;
    public String date;
    public String img;
    public String source;
    public String texsrch;


    public listitem_Detl_search(String title, String info, String date, String img,String source) {
        this.title = title;
        this.info = info;
        this.date = date;
        this.img = img;
        this.source=source;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTexsrch() {
        return texsrch;
    }

    public void setTexsrch(String texsrch) {
        this.texsrch = texsrch;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getinfo() {
        return info;
    }

    public String getDate() {
        return date;
    }

    public String getImg() {
        return img;
    }
}

