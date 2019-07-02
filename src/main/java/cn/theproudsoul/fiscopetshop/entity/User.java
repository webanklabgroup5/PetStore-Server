package cn.theproudsoul.fiscopetshop.entity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="userKey")
    private String userKey;

    @Column(name="password")
    private String password;

    @Column(name="remainingCredit")
    private int remainingCredit;

    public User(String userName, String userKey, String password, int remainingCredit) {
        this.userName = userName;
        this.userKey = userKey;
        this.password=password;
        this.remainingCredit = remainingCredit;
    }


    @Override
    public String toString() {
        return String.format("User [id=%d, userName=%s, userKey=%s, password=%s, remainingCredit=%d]", id, userName, userKey, password, remainingCredit);
    }

    public String getPassword() {
        return password;
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

//    public Pets getPetList() {
//        return petList;
//    }
//
//    public void setPetList(Pets petList) {
//        this.petList = petList;
//    }
}