package helpme.Instagram.dto;

import helpme.Instagram.domain.Image;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDTO {

    private Long id;
    private String originFileName;
    private String fullPath;

    @Builder
    public ImageDTO(Long id, String originFileName, String fullPath) {
        this.id = id;
        this.originFileName = originFileName;
        this.fullPath = fullPath;
    }

    public Image toEntity(){
        return Image.builder()
                .id(this.getId())
                .originFileName(this.getOriginFileName())
                .fullPath(this.getFullPath())
                .build();
    }
}
