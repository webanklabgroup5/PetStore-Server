package cn.theproudsoul.fiscopetshop.repository;

import cn.theproudsoul.fiscopetshop.entity.PetExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetExtraRepository extends JpaRepository<PetExtra, Long> {
    PetExtra findByPetName(String petName);

    void deleteByPetName(String petName);
}
