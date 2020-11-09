package com.example.lab2_6;

public class Dish {
    private String dish_name;
    private Thumbnail thumbnail;
    private boolean IsPromotion;

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setPromotion(boolean promotion) {
        IsPromotion = promotion;
    }

    public boolean isPromotion() {
        return IsPromotion;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
