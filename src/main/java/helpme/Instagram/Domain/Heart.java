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
    private int dislike;

    public Heart() {
        this.liked = 0;
        this.dislike = 0;
    }


    //TODO check 라는 메서드명이 이상함.
    public void checkLike() {
        liked = liked+1;
    }

    public void checkDisLike() {
        dislike = dislike+1;
    }
}
