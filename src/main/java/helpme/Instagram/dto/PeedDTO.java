package helpme.Instagram.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import helpme.Instagram.domain.Comment;
import helpme.Instagram.domain.Image;
import helpme.Instagram.domain.Peed;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PeedDTO {

    private Long id;
    private String userName;

    @JsonIgnore
    private Image image;

    private String content;
    private List<Comment> commentList;

    @Builder
    public PeedDTO(Long id, String userName, Image image, String content, List<Comment> commentList) {
        this.id = id;
        this.userName = userName;
        this.image = image;
        this.content = content;
        this.commentList = commentList;
    }

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
