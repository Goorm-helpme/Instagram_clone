package helpme.Instagram.Controller;

import helpme.Instagram.Controller.Dto.ImageDTO;
import helpme.Instagram.Controller.Dto.PeedDTO;
import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Repository.QueryDsl.PeedRepositoryCustom;
import helpme.Instagram.Repository.peed.JpaPeedRepository;
import helpme.Instagram.Repository.peed.PeedRepository;
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
    private final JpaPeedRepository peedRepository;

    // 전체 피드 조회(/peeds)
    @GetMapping("")
    public ResponseEntity<List<Peed>> allPeeds(){
        return ResponseEntity.ok(peedRepository.findAll_Query());
    }

    // 피드 생성(/peeds/peed)
    @PostMapping("/peed")
    public ResponseEntity upload(@RequestPart PeedDTO peedDTO, @RequestParam MultipartFile img) throws IOException {
        if(!img.isEmpty()){
            ImageDTO imageDTO = imageService.convertToImageDTO(img);

            //TODO: methode 분리 할 필요가 없음
            peedService.uploadPeed(peedDTO, imageDTO);
        } else {
            peedService.uploadPeed(peedDTO, null); //TODO: brace else 에 추가
        }
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
            ImageDTO imageDTO = imageService.convertToImageDTO(img); //TODO: method name
            peedService.modifyPeed(id, peedDTO, imageDTO);
        }else {
            peedService.modifyPeed(id, peedDTO);
        }
        //TODO: 새로 조회하는 이유는??
        PeedDTO result = peedService.findOnePeed(id);
        return ResponseEntity.ok(result);
    }

    // 해당 id의 피드 삭제(/peeds/peed/{id})
    @DeleteMapping("/peed/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        //TODO: hard delete 가 아니라 soft delete 도 고려 해볼 것.
        peedService.deletePeed(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/peed/query/{id}")
    public ResponseEntity<List<Peed>> findOnPeed_Query(@PathVariable Long id){
        return ResponseEntity.ok(peedRepository.findById_Query(id));
    }
}
