package helpme.Instagram.Controller;

import helpme.Instagram.Service.Heart.HeartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/heart")
public class HeartApiController {
    private final HeartServiceImpl heartService;


}
