package helpme.Instagram.Controller;

import helpme.Instagram.Controller.Dto.HeartDto;
import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Service.Heart.HeartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartApiController {
    private final HeartServiceImpl heartService;

    @GetMapping("/{id}")
    public HeartDto getHeart(@PathVariable Long id) {
        Heart heart = heartService.findById(id);
        HeartDto heartDto = new HeartDto(heart);
        return heartDto;
    }

    @GetMapping("/hearts")
    public List<HeartDto> getHearts() {
        List<Heart> hearts = heartService.findAll();
        List<HeartDto> collect = hearts.stream()
                .map(heart -> new HeartDto(heart))
                .collect(Collectors.toList());
        return collect;
    }
    
    //테스트용
    @GetMapping("/heartList")
    public List<Heart> getHeartList() {
        return heartService.findAll();
    }


    @PostMapping("/{boardId}/like/click")
    public void clickLike(@PathVariable Long boardId) {
        heartService.clickLike(boardId);
    }

    @PostMapping("/{boardId}/dislike/click")
    public void clickDisLike(@PathVariable Long boardId) {
        heartService.clickDisLike(boardId);
    }
}
