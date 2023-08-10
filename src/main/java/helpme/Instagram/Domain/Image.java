package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터베이스에 저장되는 엔티티
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originFileName; // 원래 파일명

    @Column(nullable = false)
    private String fileName; // 서버에서 관리할 파일명

    @Column(nullable = false)
    private String filePath; // 파일 저장 경로

    @Builder
    public Image(Long id, String originFileName, String fileName, String filePath) {
        this.id = id;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
