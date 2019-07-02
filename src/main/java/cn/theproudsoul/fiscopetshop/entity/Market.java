package cn.theproudsoul.fiscopetshop.entity;

public class Market{
    private int transactionCount;
    private int petCount;

    public Market(int transactionCount, int petCount) {
        this.transactionCount = transactionCount;
        this.petCount = petCount;
    }
}