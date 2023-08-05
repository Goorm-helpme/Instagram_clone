package helpme.Instagram.controller.peed;

import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/peeds")
public class PeedController {

    private final PeedService peedService;

    @GetMapping("")
    public ResponseEntity<List<PeedDTO>> allPeeds(){
        List<PeedDTO> allPeed = peedService.findAllPeed();
        return ResponseEntity.ok(allPeed);
    }

    @PostMapping("/peed")
    public ResponseEntity upload(@RequestBody PeedDTO peedDTO){
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
}
