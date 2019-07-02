package cn.theproudsoul.fiscopetshop.entity;

import javax.persistence.*;

@Entity
@Table(name="pet_pic")
public class PetPic {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="pet_name")
    private String petName;

    @Column(name="url")
    private String url;
}
