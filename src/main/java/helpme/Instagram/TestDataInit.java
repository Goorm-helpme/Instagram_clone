package helpme.Instagram;

import helpme.Instagram.Domain.Board;
import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Repository.peed.PeedRepository;
import helpme.Instagram.Service.Board.BoardService;
import helpme.Instagram.Service.Heart.HeartServiceImpl;
import helpme.Instagram.Service.peed.PeedService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final PeedService peedService;

    @PostConstruct
    public void init() {
        Peed peed = new Peed();
        peedService.uploadPeed(peed);
    }
}
