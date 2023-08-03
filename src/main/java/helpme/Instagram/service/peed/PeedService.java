package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.repository.peed.PeedRepository;
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


}
