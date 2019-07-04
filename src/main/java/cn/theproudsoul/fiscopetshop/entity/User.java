package cn.theproudsoul.fiscopetshop.entity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_key")
    private String userKey;

    public String getUserKey() {
        return userKey;
    }

    @Column(name="password")
    private String password;

    @Transient
    private int credit;

    @Column(name = "address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User [id=%d, userName=%s, userKey=%s, password=%s, remainingCredit=%d]", id, userName, userKey, password, credit);
    }

    public String getPassword() {
        return password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}