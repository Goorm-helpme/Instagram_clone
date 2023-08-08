package helpme.Instagram.repository.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.PeedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPeedRepository extends JpaRepository<Peed, Long> {

    @Query("select p from Peed p left join fetch p.image")
    List<Peed> findAllPeed();
}
