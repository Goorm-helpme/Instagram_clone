package helpme.Instagram.service.image;

import helpme.Instagram.domain.Image;
import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.ImageDTO;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.repository.image.JpaImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {

    private final JpaImageRepository jpaImageRepository;

    private ImageDTO toDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .originFileName(image.getOriginFileName())
                .fileName(image.getFileName())
                .filePath(image.getFilePath())
                .peed(image.getPeed())
                .build();
    }

    public Long saveImage(ImageDTO imageDTO) {
        return jpaImageRepository.save(imageDTO.toEntity()).getId();
    }

    // 수정 시 피드와의 연관관계가 모두 사라지는 오류 수정 필요
    public ImageDTO modifyImage(PeedDTO peedDTO, MultipartFile img) throws IOException {
        Image image = peedDTO.getImage();

        ImageDTO build;
        if(image != null) {
            Long imageId = image.getId();
            ImageDTO imageDTO = findOneImage(imageId);
            deleteImage(imageId);
            ImageDTO fixedImage = convertToImageDTO(img);
            build = ImageDTO.builder()
                    .id(imageDTO.getId())
                    .peed(imageDTO.getPeed())
                    .originFileName(fixedImage.getOriginFileName())
                    .fileName(fixedImage.getFileName())
                    .filePath(fixedImage.getFilePath())
                    .build();
        }else build = convertToImageDTO(img);

        jpaImageRepository.save(build.toEntity());
        return build;
    }

    public void deleteImage(Long id){
        jpaImageRepository.deleteById(id);
    }

    public ImageDTO findOneImage(Long id){
        Image image = jpaImageRepository.findById(id).orElseThrow();
        return ImageDTO.builder()
                .id(image.getId())
                .originFileName(image.getOriginFileName())
                .fileName(image.getFileName())
                .filePath(image.getFilePath())
                .build();
    }

    public ImageDTO convertToImageDTO(MultipartFile img) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int millis = now.get(ChronoField.MILLI_OF_SECOND);

        String absolutePath = new File("c:\\InstagramCloneServer").getAbsoluteFile() + "\\";
        String newFileName = "image" + hour + minute + second + millis;
        String fileExtension = '.' + img.getOriginalFilename().replaceAll("^.*\\\\.(.*)$", "$1");
        String path = "images\\" + year + "\\" + month + "\\" + day;

        File file = new File(absolutePath + path);
        if (!file.exists()) file.mkdirs();

        file = new File(absolutePath + path + "\\" + newFileName + fileExtension);
        img.transferTo(file);

        return ImageDTO.builder()
                .originFileName(img.getOriginalFilename())
                .fileName(newFileName + fileExtension)
                .filePath(path)
                .build();
    }
}
