package cn.theproudsoul.fiscopetshop.repository;

import cn.theproudsoul.fiscopetshop.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
