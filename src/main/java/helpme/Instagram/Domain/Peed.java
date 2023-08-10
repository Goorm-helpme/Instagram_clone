package helpme.Instagram.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "peed")
public class Peed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName; // 피드 작성자

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image; // 피드에 들어간 이미지 정보

    @Column(nullable = false)
    private String content; // 피드 내용

    @OneToMany(mappedBy = "peed", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"peed"})
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
