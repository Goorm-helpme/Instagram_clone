package helpme.Instagram.Controller.Dto;

import helpme.Instagram.Domain.Comment;
import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Domain.Image;
import helpme.Instagram.Domain.Peed;
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
    private Heart heart; // 좋아요

    @Builder
    public PeedDTO(Long id, String userName, Image image, String content, List<Comment> commentList, Heart heart) {
        this.id = id;
        this.userName = userName;
        this.image = image;
        this.content = content;
        this.commentList = commentList;
        this.heart = heart;
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
