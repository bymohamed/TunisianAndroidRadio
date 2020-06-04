package com.beny.radiotunisien;

import java.io.Serializable;

public class Radio implements Serializable {
    public int id = 0;
    public String name="";
    public String img_link="";
    public String url="";


    public Radio(int id, String name, String img_link, String url) {
        this.id = id;
        this.name = name;
        this.img_link = img_link;
        this.url = url;
    }

    public Radio get(){
        return this;
    }

    @Override
    public String toString() {
        return "Radioun{" +
                "id=" + id +
                "name=" + name +
                ", img_link='" + img_link + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
