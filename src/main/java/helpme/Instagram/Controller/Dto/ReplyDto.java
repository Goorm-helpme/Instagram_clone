package helpme.Instagram.Controller.Dto;

import helpme.Instagram.Domain.Comment;
import lombok.Data;

@Data
public class ReplyDto {
    private int id;
    private String userName;
    private String content;
    private Comment comment;

    public ReplyDto(int id, String userName, String content, Comment comment) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.comment = comment;
    }
}
