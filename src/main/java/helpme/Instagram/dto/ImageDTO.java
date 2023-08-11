package helpme.Instagram.dto;

import helpme.Instagram.domain.Image;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 데이터베이스의 데이터를 주고 받을 DTO
 */

@Data
@NoArgsConstructor
public class ImageDTO {

    private Long id;
    private String originFileName; // 원본 파일명
    private String fileName; // 서버에서 관리하는 파일명
    private String filePath; // 이미지 저장 경로

    @Builder
    public ImageDTO(Long id, String originFileName, String fileName, String filePath) {
        this.id = id;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    /**
     * 데이터베이스에 저장할 때 엔티티로 변환
     */
    public Image toEntity(){
        return Image.builder()
                .id(this.getId())
                .originFileName(this.getOriginFileName())
                .fileName(this.getFileName())
                .filePath(this.getFilePath())
                .build();
    }
}
