package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Peed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName; // 피드 작성자

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image; // 피드에 들어간 이미지 정보

    @Column(nullable = false)
    private String content; // 피드 내용

    @OneToMany(mappedBy = "peed")
    private List<Comment> comments = new ArrayList<>(); // 피드 댓글 내용

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Heart heart;

    @Builder
    public Peed(Long id, String userName, Image image, String content, List<Comment> comments) {
        this.id = id;
        this.userName = userName;
        this.image = image;
        this.content = content;
        this.comments = comments;
        this.heart = new Heart();
    }
}
