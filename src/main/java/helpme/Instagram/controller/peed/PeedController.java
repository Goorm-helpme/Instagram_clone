package helpme.Instagram.controller.peed;

import helpme.Instagram.domain.Image;
import helpme.Instagram.dto.ImageDTO;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.service.image.ImageService;
import helpme.Instagram.service.peed.PeedService;
import jakarta.annotation.Nullable;
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
    public ResponseEntity upload(@RequestPart PeedDTO peedDTO, @RequestParam MultipartFile img) throws IOException {
        if(!img.isEmpty()){
            ImageDTO imageDTO = imageService.convertToImageDTO(img);
            peedService.uploadPeed(peedDTO, imageDTO);
        }else peedService.uploadPeed(peedDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> findOnePeed(@PathVariable Long id){
        PeedDTO findPeed = peedService.findOnePeed(id);
        return ResponseEntity.ok(findPeed);
    }

    @PutMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> modify(@PathVariable Long id, @RequestPart PeedDTO peedDTO, @RequestParam MultipartFile img) throws IOException {
        PeedDTO result;
        if(!img.isEmpty()){
            ImageDTO imageDTO = imageService.modifyImage(peedDTO, img);
            result = peedService.modifyPeed(id, peedDTO, imageDTO);
        }else {
            result = peedService.modifyPeed(id, peedDTO);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/peed/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        peedService.deletePeed(id);
        return ResponseEntity.ok().build();
    }
}
