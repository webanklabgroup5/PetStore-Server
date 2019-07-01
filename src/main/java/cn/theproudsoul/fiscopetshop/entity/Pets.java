package cn.theproudsoul.fiscopetshop.entity;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    private List<Pet> petList;

    public List<Pet> getPetList() {
        if(petList == null) {
            petList = new ArrayList<>();
        }
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
