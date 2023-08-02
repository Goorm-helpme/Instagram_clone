package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int liked;
    private boolean isLiked;

    private int dislike;
    private boolean isDisLiked;

    @ManyToOne
    Board board;

    public Heart() {
        this.liked = 0;
        this.isLiked = false;
        this.dislike = 0;
        this.isDisLiked = false;
    }

    public void checkLike() {
        if(!isLiked) {
            liked+= 1;
            isLiked = true;
        } else {
            liked-= 1;
            isLiked = false;
        }
    }

    public void checkDisLike() {
        if(!isDisLiked) {
            dislike+= 1;
            isDisLiked = true;
        } else {
            dislike-= 1;
            isDisLiked = false;
        }
    }
}
