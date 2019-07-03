package cn.theproudsoul.fiscopetshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "pet_extra")
public class PetExtra {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "remark")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
