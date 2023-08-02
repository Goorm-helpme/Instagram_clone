package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @OneToMany(mappedBy = "board")
    private List<Heart> heartList = new ArrayList<>();

    public void addHeart(Heart heart) {
        heartList.add(heart);
        heart.setBoard(this);
    }
}
