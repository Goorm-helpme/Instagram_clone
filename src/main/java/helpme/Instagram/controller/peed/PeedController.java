package helpme.Instagram.controller.peed;

import helpme.Instagram.dto.ImageDTO;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.service.image.ImageService;
import helpme.Instagram.service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/peeds")
public class PeedController {

    private final PeedService peedService;
    private final ImageService imageService;

    @GetMapping("")
    public ResponseEntity<List<PeedDTO>> allPeeds(){
        List<PeedDTO> allPeed = peedService.findAllPeed();
        return ResponseEntity.ok(allPeed);
    }

    @PostMapping("/peed")
    public ResponseEntity upload(@RequestParam String userName, @RequestParam String content, @RequestParam MultipartFile img) throws IOException {
        PeedDTO peedDTO;
        peedDTO = getPeedDTO(userName, content, img);
        peedService.uploadPeed(peedDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> findOnePeed(@PathVariable Long id){
        PeedDTO findPeed = peedService.findOnePeed(id);
        return ResponseEntity.ok(findPeed);
    }

    @PutMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> modify(@PathVariable Long id, @RequestBody PeedDTO peedDTO){
        PeedDTO result = peedService.modifyPeed(id, peedDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/peed/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        peedService.deletePeed(id);
        return ResponseEntity.ok().build();
    }

    private PeedDTO getPeedDTO(String userName, String content, MultipartFile img) throws IOException {
        PeedDTO peedDTO;
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

        if(!img.isEmpty()){
            File file = new File(absolutePath + path);
            if(!file.exists()) file.mkdirs();

            file = new File(absolutePath + path + "\\" + newFileName + fileExtension);
            img.transferTo(file);

            ImageDTO imageDTO = ImageDTO.builder()
                    .originFileName(img.getOriginalFilename())
                    .fileName(newFileName + fileExtension)
                    .filePath(path)
                    .build();

            imageService.save(imageDTO);

            peedDTO = PeedDTO.builder()
                    .userName(userName)
                    .image(imageDTO.toEntity())
                    .content(content)
                    .build();
        }else{
            peedDTO = PeedDTO.builder()
                    .userName(userName)
                    .content(content)
                    .build();
        }
        return peedDTO;
    }
}
