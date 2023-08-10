package helpme.Instagram.Service.image;

import helpme.Instagram.Controller.Dto.ImageDTO;
import helpme.Instagram.Domain.Image;
import helpme.Instagram.Repository.image.JpaImageRepository;
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

    // 뷰로 넘겨줄 때 DTO로 변환
    private ImageDTO toDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .originFileName(image.getOriginFileName())
                .fileName(image.getFileName())
                .filePath(image.getFilePath())
                .build();
    }

    // 이미지 데이터를 DB에 저장
    public Long saveImage(ImageDTO imageDTO) {
        return jpaImageRepository.save(imageDTO.toEntity()).getId();
    }

    // 이미지 데이터 수정
    public ImageDTO modifyImage(MultipartFile img) throws IOException {
        return convertToImageDTO(img);
    }

    // 이미지 데이터 삭제
    public void deleteImage(Long id){
        jpaImageRepository.deleteById(id);
    }

    // 해당 id의 이미지 데이터 조회
    public ImageDTO findOneImage(Long id){
        Image image = jpaImageRepository.findById(id).orElseThrow();
        return ImageDTO.builder()
                .id(image.getId())
                .originFileName(image.getOriginFileName())
                .fileName(image.getFileName())
                .filePath(image.getFilePath())
                .build();
    }

    // MultipartFile타입의 데이터를 ImageDTO로 변환
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
