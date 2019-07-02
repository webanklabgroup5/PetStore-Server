package cn.theproudsoul.fiscopetshop.entity;

import java.math.BigInteger;

public class Order {
    private String id;
    private int trade_status;
    private int price;
    private String pet_id;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTrade_status(int trade_status) {
        this.trade_status = trade_status;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
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
