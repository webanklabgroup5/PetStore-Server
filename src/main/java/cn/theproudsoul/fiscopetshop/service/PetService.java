package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Pet;

import java.util.List;

public interface PetService {

    boolean petAdd(String name, int species, String picPath, String birthday, String description) throws Exception;

    boolean petDown(String id) throws Exception;

    boolean petOn(String petId, int price, String remark) throws Exception;

    List<Pet> getPetsOnSale();

    List<Pet> getPetList();

    List<Pet> getMyPets();

    int getPetCount(String address);
}
