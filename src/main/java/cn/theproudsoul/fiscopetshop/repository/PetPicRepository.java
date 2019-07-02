package cn.theproudsoul.fiscopetshop.repository;

import cn.theproudsoul.fiscopetshop.entity.PetPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetPicRepository extends JpaRepository<PetPic, Long> {
}
