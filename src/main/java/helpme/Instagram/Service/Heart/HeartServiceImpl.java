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
    public Heart findByBoard(Peed peed) {
        return heartRepository.findByPeed(peed);
    }

    @Override
    public void delete(Long id) {
        heartRepository.deleteById(id);
    }

    @Override
    public void clickLike(Long boardId) {
        if(heartRepository.findByPeed(peedService.findById(boardId))!=null) {
            Heart heart = heartRepository.findByPeed(peedService.findById(boardId));
            heart.checkLike();
        } else {
            Heart heart = new Heart();
            heart.setPeed(peedService.findById(boardId));
            heartRepository.save(heart);
            heart.checkLike();
        }
    }

    @Override
    public void clickDisLike(Long boardId) {
        if(heartRepository.findByPeed(peedService.findById(boardId))!=null) {
            Heart heart = heartRepository.findByPeed(peedService.findById(boardId));
            heart.checkDisLike();
        } else {
            Heart heart = new Heart();
            heart.setPeed(peedService.findById(boardId));
            heartRepository.save(heart);
            heart.checkDisLike();
        }
    }

    @Override
    public List<Heart> findAll() {
        return heartRepository.findAll();
    }
}
