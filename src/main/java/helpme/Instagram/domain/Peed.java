package helpme.Instagram.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Peed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @OneToOne
    private Image image;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "peed")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Peed(Long id, String userName, Image image, String content, List<Comment> comments) {
        this.id = id;
        this.userName = userName;
        this.image = image;
        this.content = content;
        this.comments = comments;
    }
}
