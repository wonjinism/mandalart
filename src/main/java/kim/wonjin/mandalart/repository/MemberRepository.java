package kim.wonjin.mandalart.repository;

import kim.wonjin.mandalart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
