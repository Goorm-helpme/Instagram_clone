package helpme.Instagram.dto;

import helpme.Instagram.domain.Comment;
import helpme.Instagram.domain.Image;
import helpme.Instagram.domain.Peed;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 데이터베이스의 데이터를 주고 받을 DTO
 */

@Data
@NoArgsConstructor
public class PeedDTO {

    private Long id;
    private String userName; // 피드 작성자
    private Image image; // 피드에 적용된 이미지 정보
    private String content; // 피드 내용
    private List<Comment> commentList; // 댓글

    @Builder
    public PeedDTO(Long id, String userName, Image image, String content, List<Comment> commentList) {
        this.id = id;
        this.userName = userName;
        this.image = image;
        this.content = content;
        this.commentList = commentList;
    }

    /**
     * 데이터베이스에 저장할 때 엔티티로 변환
     */
    public Peed toEntity(){
        return Peed.builder()
                .id(id)
                .userName(userName)
                .image(image)
                .content(content)
                .comments(commentList)
                .build();
    }
}
