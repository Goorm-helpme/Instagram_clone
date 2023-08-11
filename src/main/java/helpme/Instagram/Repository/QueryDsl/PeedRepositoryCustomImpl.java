package helpme.Instagram.Repository.QueryDsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import helpme.Instagram.Domain.*;
import helpme.Instagram.Repository.peed.JpaPeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

public class PeedRepositoryCustomImpl extends QuerydslRepositorySupport implements PeedRepositoryCustom{


    public PeedRepositoryCustomImpl() {
        super(Peed.class);
    }

    @Override
    public List<Peed> findById_Query(Long id) {
        QPeed qPeed = QPeed.peed;
        QComment comment = QComment.comment;
        QImage image = QImage.image;
        QReply reply = QReply.reply;
        QHeart heart = QHeart.heart;
        return from(qPeed)
                .leftJoin(qPeed.comments, comment)
                .join(qPeed.heart, heart).fetchJoin()
                .leftJoin(qPeed.image, image).fetchJoin()
                .leftJoin(comment.replies, reply)
                .where(qPeed.id.eq(id))
                .distinct()
                .fetch();
    }
}
