package helpme.Instagram.Service.Heart;

import helpme.Instagram.Domain.Board;
import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartServiceImpl implements HeartService{
    private final HeartRepository heartRepository;
    @Override
    public void save(Heart heart) {
        heartRepository.save(heart);
    }

    @Override
    public Heart findById(Long id) {
        return heartRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Heart> findByBoard(Board board) {
        return heartRepository.findByBoard(board);
    }

    @Override
    public void delete(Long id) {
        heartRepository.deleteById(id);
    }

    @Override
    public void clickLike(Long id) {
        Heart heart = heartRepository.findById(id).orElseThrow();
        heart.checkLike();
    }

    @Override
    public void clickDisLike(Long id) {
        Heart heart = heartRepository.findById(id).orElseThrow();
        heart.checkDisLike();
    }
}
