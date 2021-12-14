package com.example.deliveryapp.layoutFiles;

public class ItemDetails {
    //int img;
    String foodName,Price,ShopName;
    ItemDetails(String foodName,String Price,String ShopName){
//        this.img=img;
        this.foodName=foodName;
        this.Price=Price;
        this.ShopName=ShopName;
    }
//    public int getImg() {
//        return img;
//    }

    public String getFoodName() {
        return foodName;
    }

    public String getPrice() {
        return Price;
    }

    public String ShopName() {
        return ShopName;
    }

}
