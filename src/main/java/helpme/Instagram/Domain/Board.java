package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 테스트 용입니다
 * 게시글 엔티티입니다
 * 현재는 단순하게 내용과 좋아요 기능만 가지고 있습니다.
 */
@Data
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String content;
}
