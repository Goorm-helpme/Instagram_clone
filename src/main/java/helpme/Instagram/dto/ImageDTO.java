package helpme.Instagram.dto;

import helpme.Instagram.domain.Image;
import helpme.Instagram.domain.Peed;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDTO {

    private Long id;
    private String originFileName;
    private String fileName;
    private String filePath;
    private Peed peed;

    @Builder
    public ImageDTO(Long id, String originFileName, String fileName, String filePath, Peed peed) {
        this.id = id;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.peed = peed;
    }

    public Image toEntity(){
        return Image.builder()
                .id(this.getId())
                .originFileName(this.getOriginFileName())
                .fileName(this.getFileName())
                .filePath(this.getFilePath())
                .peed(this.getPeed())
                .build();
    }
}
