package helpme.Instagram.Repository.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import helpme.Instagram.Domain.Image;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, Long> {
}
