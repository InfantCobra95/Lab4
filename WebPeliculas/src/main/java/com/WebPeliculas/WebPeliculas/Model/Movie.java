package com.WebPeliculas.WebPeliculas.Model;

public class Movie {
      
    private int id;
    private String name;
    private int year;
    private String img;
    private String desc;

    public Movie(){}

    public Movie(int _id, String _name, int _year, String _img, String _desc){
        this.id = _id;
        this.name = _name;
        this.year = _year; 
        this.img = _img;     
        this.desc = _desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
