package helpme.Instagram.controller.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/peeds")
public class PeedController {

    private final PeedService peedService;

    @GetMapping("/")
    public List<PeedDTO> main(){
        return peedService.findAllPeed();
    }
}
