package helpme.Instagram.Repository;

import helpme.Instagram.Domain.Peed;
import org.springframework.data.jpa.repository.JpaRepository;
import helpme.Instagram.Domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPeed(Peed peed);
}
