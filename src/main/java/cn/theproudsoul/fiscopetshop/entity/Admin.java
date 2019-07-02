package cn.theproudsoul.fiscopetshop.entity;

public class Admin{
    private String userName = "admin";
    private Market market;
    private Orders orderList;

    public Admin(Market market, Orders orderList) {
        this.market = market;
        this.orderList = orderList;
    }
}