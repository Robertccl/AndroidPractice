package com.ccl.androidtest.listViewTest.adapter.model;

/**
 * Created by CCL on 2016/12/7.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(int imageId, String name) {

        this.imageId = imageId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
