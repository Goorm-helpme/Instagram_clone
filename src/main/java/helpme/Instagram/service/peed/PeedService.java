package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.repository.peed.JpaPeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PeedService {

    private final JpaPeedRepository peedRepository;

    private PeedDTO toDTO(Peed peed){
        return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .image(peed.getImage())
                .content(peed.getContent())
                .commentList(peed.getComments())
                .build();
    }

    public Long uploadPeed(PeedDTO peedDTO) {
        Peed save = peedRepository.save(peedDTO.toEntity());
        return save.getId();
    }

    public PeedDTO modifyPeed(Long id, PeedDTO peed) {
        PeedDTO fixedPeed = PeedDTO.builder()
                .id(id)
                .userName(peed.getUserName())
                .content(peed.getContent())
                .image(peed.getImage())
                .commentList(peed.getCommentList())
                .build();

        peedRepository.save(fixedPeed.toEntity());
        return fixedPeed;
    }

    public void deletePeed(Long id){
        peedRepository.deleteById(id);
    }

    public PeedDTO findOnePeed(Long id){
        Peed peed = peedRepository.findById(id).orElseThrow();

        return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .image(peed.getImage())
                .content(peed.getContent())
                .commentList(peed.getComments())
                .build();
    }

    public List<PeedDTO> findAllPeed(){
        List<Peed> peedList = peedRepository.findAll();
        return peedList.stream().map(this::toDTO).toList();
    }
}
