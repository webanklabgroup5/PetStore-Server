package cn.theproudsoul.fiscopetshop.entity;


public class User{
    private String userName;
    //private String userKey;
    private int remainingCredit;
    private Pets petList;

    public User(String userName, int remainingCredit) {
        this.userName = userName;
        //this.userKey = userKey;
        this.remainingCredit = remainingCredit;
    }

    public int getRemainingCredit() {
        return remainingCredit;
    }

    public void setRemainingCredit(int remainingCredit) {
        this.remainingCredit = remainingCredit;
    }

//    public String getUserKey() {
//        return userKey;
//    }
//
//    public void setUserKey(String password) {
//        this.userKey = userKey;
//    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Pets getPetList() {
        return petList;
    }

    public void setPetList(Pets petList) {
        this.petList = petList;
    }
}