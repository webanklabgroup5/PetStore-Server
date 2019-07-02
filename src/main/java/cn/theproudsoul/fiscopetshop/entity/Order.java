package cn.theproudsoul.fiscopetshop.entity;

import java.math.BigInteger;

public class Order {
    private String id;
    private int tradeStatus;
    private int price;
    private String petId;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTradeStatus(int tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public void setPetId(String pet_id) {
        this.petId = petId;
    }


//    "trade_id":1,
//            "trade_status":0,
//            "pet_id":1,
//            "pet_name":"miao",
//            "pet_species":2,
//            "birthday":"20190201",
//            "description":"This is a good cat",
//            "price":100,
//            "date":"20190301",
//            "img_url":"http://aaaaa"
}
