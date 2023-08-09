package helpme.Instagram.Service.Heart;

import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Repository.HeartRepository;
import helpme.Instagram.Service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartServiceImpl implements HeartService{
    private final HeartRepository heartRepository;
    private final PeedService peedService;
    @Override
    public void save(Heart heart) {
        heartRepository.save(heart);
    }

    @Override
    public Heart findById(Long id) {
        return heartRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        heartRepository.deleteById(id);
    }

    @Override
    public void clickLike(Long boardId) {
        Peed peed = peedService.findById(boardId);
        peed.getHeart().checkLike();
    }

    @Override
    public void clickDisLike(Long boardId) {
        Peed peed = peedService.findById(boardId);
        peed.getHeart().checkDisLike();
    }

    @Override
    public List<Heart> findAll() {
        return heartRepository.findAll();
    }
}
