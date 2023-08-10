package helpme.Instagram.Repository.image;

import helpme.Instagram.Domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, Long> {
}
