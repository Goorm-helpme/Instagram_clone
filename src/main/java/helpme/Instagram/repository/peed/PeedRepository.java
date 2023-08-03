package helpme.Instagram.repository.peed;

import helpme.Instagram.domain.Peed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeedRepository extends JpaRepository<Peed, Long> {
}
