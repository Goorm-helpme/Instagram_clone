package helpme.Instagram.Repository;

import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Domain.Peed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
}
