package cn.theproudsoul.fiscopetshop.service;

public interface PetService {

    boolean petAdd(String userKey, String name, int species, String picPath, String birthday, String description);

    boolean petDown(String userKey, String id);

    boolean petOn(String userKey, String id, int price);

}
