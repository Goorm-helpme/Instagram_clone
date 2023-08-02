package helpme.Instagram.Repository;

import helpme.Instagram.Domain.Board;
import helpme.Instagram.Domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    List<Heart> findByBoard(Board board);
}
