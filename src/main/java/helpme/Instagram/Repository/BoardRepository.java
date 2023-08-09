package helpme.Instagram.Repository;

import helpme.Instagram.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 테스트용으로 구현하였지만, 구조가 크게 다르지 않아서 참고하시면 됩니다
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
