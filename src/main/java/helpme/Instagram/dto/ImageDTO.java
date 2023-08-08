package helpme.Instagram.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @Builder
    public ImageDTO(Long id, String originFileName, String fileName, String filePath) {
        this.id = id;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public Image toEntity(){
        return Image.builder()
                .id(this.getId())
                .originFileName(this.getOriginFileName())
                .fileName(this.getFileName())
                .filePath(this.getFilePath())
                .build();
    }
}
