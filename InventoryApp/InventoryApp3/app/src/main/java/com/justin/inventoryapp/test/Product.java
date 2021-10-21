package com.justin.inventoryapp.test;


public class Product {
    private int id;
    private String itemname;
    private String eventdetail;
    private String dailyweight;

    public Product(int id, String itemname, String eventdetail, String dailyweight) {
        this.id = id;
        this.itemname = itemname;
        this.eventdetail = eventdetail;
        this.dailyweight = dailyweight;
    }

    public int getId() {
        return id;
    }

    public String getItemname() {
        return itemname;
    }

    public String getEventdetail() {
        return eventdetail;
    }

    public String getDailyweight() {
        return dailyweight;
    }
}
