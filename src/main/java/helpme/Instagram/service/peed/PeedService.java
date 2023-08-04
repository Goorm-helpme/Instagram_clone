package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.PeedDTO;
import helpme.Instagram.repository.peed.JpaPeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PeedService {

    private final JpaPeedRepository peedRepository;

    private PeedDTO toDTO(Peed peed){
        return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .content(peed.getContent())
                .build();
    }

    public Long uploadPeed(PeedDTO peedDTO) {
        peedRepository.save(peedDTO.toEntity());
        return peedDTO.getId();
    }

    public PeedDTO modifyPeed(PeedDTO peed) {
        PeedDTO fixedPeed = PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .content(peed.getContent())
                .build();

        peedRepository.save(fixedPeed.toEntity());
        return fixedPeed;
    }

    public void deletePeed (Long id){
        peedRepository.deleteById(id);
    }

    public PeedDTO findOnePeed(Long id){
        Peed peed = peedRepository.findById(id).orElseThrow();

        return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .content(peed.getContent())
                .build();
    }

    public List<PeedDTO> findAllPeed(){
        List<Peed> peedList = peedRepository.findAll();
        return peedList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
