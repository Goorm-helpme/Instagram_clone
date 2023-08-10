package helpme.Instagram.Controller.peed;

import helpme.Instagram.dto.ImageDTO;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.Service.image.ImageService;
import helpme.Instagram.Service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/peeds")
public class PeedController {

    private final PeedService peedService;
    private final ImageService imageService;

    // 전체 피드 조회(/peeds)
    @GetMapping("")
    public ResponseEntity<List<PeedDTO>> allPeeds(){
        List<PeedDTO> allPeed = peedService.findAllPeed();
        return ResponseEntity.ok(allPeed);
    }

    // 피드 생성(/peeds/peed)
    @PostMapping("/peed")
    public ResponseEntity upload(@RequestPart PeedDTO peedDTO, @RequestParam MultipartFile img) throws IOException {
        if(!img.isEmpty()){
            ImageDTO imageDTO = imageService.convertToImageDTO(img);
            peedService.uploadPeed(peedDTO, imageDTO);
        }else peedService.uploadPeed(peedDTO);
        return ResponseEntity.ok().build();
    }

    // 해당 id의 피드 조회(/peeds/peed/{id})
    @GetMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> findOnePeed(@PathVariable Long id){
        PeedDTO findPeed = peedService.findOnePeed(id);
        return ResponseEntity.ok(findPeed);
    }

    // 해당 id의 피드 수정(/peeds/peed/{id})
    @PutMapping("/peed/{id}")
    public ResponseEntity<PeedDTO> modify(@PathVariable Long id, @RequestPart PeedDTO peedDTO, @RequestParam MultipartFile img) throws IOException {
        if(!img.isEmpty()){
            ImageDTO imageDTO = imageService.modifyImage(img);
            peedService.modifyPeed(id, peedDTO, imageDTO);
        }else {
            peedService.modifyPeed(id, peedDTO);
        }
        PeedDTO result = peedService.findOnePeed(id);
        return ResponseEntity.ok(result);
    }

    // 해당 id의 피드 삭제(/peeds/peed/{id})
    @DeleteMapping("/peed/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        peedService.deletePeed(id);
        return ResponseEntity.ok().build();
    }
}
