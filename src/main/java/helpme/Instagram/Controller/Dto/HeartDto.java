package helpme.Instagram.Controller.Dto;

import helpme.Instagram.Domain.Heart;
import lombok.Getter;

@Getter
public class HeartDto {
    private Long id;
    private int like;
    private int dislike;
    private Long boardId;

    public HeartDto(Heart heart) {
        this.id = heart.getId();
        this.like = heart.getLiked();
        this.dislike = heart.getDislike();
        this.boardId = heart.getPeed().getId();
    }
}
