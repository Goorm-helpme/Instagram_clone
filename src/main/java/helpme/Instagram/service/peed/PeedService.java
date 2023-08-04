package helpme.Instagram.Service.peed;

import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Repository.peed.PeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PeedService {

    private final PeedRepository peedRepository;

    public void uploadPeed(Peed peed){
        peedRepository.save(peed);
    }

    public void modifyPeed(Long id, Peed peed){
        Optional<Peed> findPeed = peedRepository.findById(id);
        findPeed.get().setUserName(peed.getUserName());
        findPeed.get().setContent(peed.getContent());
    }

    public Peed findById(Long id) {
        return peedRepository.findById(id).orElseThrow(() ->
                new RuntimeException("데이터가 업습니다")
        );
    }
}
