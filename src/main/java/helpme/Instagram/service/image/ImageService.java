package helpme.Instagram.service.image;

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

    public Long save(ImageDTO imageDTO){
        return jpaImageRepository.save(imageDTO.toEntity()).getId();
    }
}
