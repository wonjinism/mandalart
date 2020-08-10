package kim.wonjin.mandalart.repository;

import kim.wonjin.mandalart.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {
}
