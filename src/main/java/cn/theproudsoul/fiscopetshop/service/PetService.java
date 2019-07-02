package cn.theproudsoul.fiscopetshop.service;

public interface PetService {

    boolean petAdd(String userKey, String name, int species, String picPath, String birthday, String description) throws Exception;

    boolean petDown(String userKey, String id) throws Exception;

    boolean petOn(String userKey, String id, int price) throws Exception;

}
