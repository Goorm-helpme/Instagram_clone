package helpme.Instagram.dto;

import helpme.Instagram.domain.Peed;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeedDTO {

    private Long id;
    private String userName;
    private String content;

    @Builder
    public PeedDTO(Long id, String userName, String content) {
        this.id = id;
        this.userName = userName;
        this.content = content;
    }

    public Peed toEntity(){
        return Peed.builder()
                .id(id)
                .userName(userName)
                .content(content)
                .build();
    }
}
