package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    @Override
    public boolean petAdd(String userKey, String name, int species, String picPath, String birthday, String description) {
        return false;
    }

    @Override
    public boolean petDown(String userKey, String id) {
        return false;
    }

    @Override
    public boolean petOn(String userKey, String id, int price) {
        // 计算上架时间now
        return false;
    }
}
