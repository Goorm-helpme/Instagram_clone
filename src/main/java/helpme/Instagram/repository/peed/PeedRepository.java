package helpme.Instagram.Repository.peed;

import helpme.Instagram.Domain.Peed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeedRepository extends JpaRepository<Peed, Long> {
}
