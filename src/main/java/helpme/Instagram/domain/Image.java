package helpme.Instagram.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originFileName;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @OneToOne
    private Peed peed;

    @Builder
    public Image(Long id, String originFileName, String fileName, String filePath, Peed peed) {
        this.id = id;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.peed = peed;
    }
}