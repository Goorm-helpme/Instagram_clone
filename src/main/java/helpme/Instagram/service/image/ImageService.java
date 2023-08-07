package helpme.Instagram.service.image;

import helpme.Instagram.domain.Image;
import helpme.Instagram.dto.ImageDTO;
import helpme.Instagram.repository.image.JpaImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {

    private final JpaImageRepository jpaImageRepository;

    private ImageDTO toDTO(Image image){
        return ImageDTO.builder()
                .id(image.getId())
                .originFileName(image.getOriginFileName())
                .fileName(image.getFileName())
                .filePath(image.getFilePath())
                .peed(image.getPeed())
                .build();
    }

    public Long save(ImageDTO imageDTO){
        return jpaImageRepository.save(imageDTO.toEntity()).getId();
    }
}
