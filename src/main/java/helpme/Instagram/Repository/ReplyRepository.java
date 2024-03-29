package helpme.Instagram.Repository;

import helpme.Instagram.Domain.Comment;
import helpme.Instagram.Domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByComment(Comment parentComment);
}