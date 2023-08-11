package helpme.Instagram.repository.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import helpme.Instagram.domain.Image;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, Long> {
}
