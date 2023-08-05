package helpme.Instagram.repository.image;

import helpme.Instagram.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, Long> {
}
