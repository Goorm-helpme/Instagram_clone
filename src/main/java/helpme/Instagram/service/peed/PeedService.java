package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.ImageDTO;
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

    // 뷰로 넘겨줄 때 DTO로 변환
    private PeedDTO toDTO(Peed peed){
        return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .image(peed.getImage())
                .content(peed.getContent())
                .commentList(peed.getComments())
                .build();
    }

    // 피드 DB에 저장
    public Long uploadPeed(PeedDTO peedDTO) {
        Peed save = peedRepository.save(peedDTO.toEntity());
        return save.getId();
    }

    // 피드에 이미지 데이터 함께 DB에 저장
    public void uploadPeed(PeedDTO peedDTO, ImageDTO imageDTO){
        Peed peed = Peed.builder()
                .userName(peedDTO.getUserName())
                .image(imageDTO.toEntity())
                .content(peedDTO.getContent())
                .build();
        peedRepository.save(peed);
    }

    // 피드 데이터 수정
    public PeedDTO modifyPeed(Long id, PeedDTO peedDTO) {
        PeedDTO fixedPeed = PeedDTO.builder()
                .id(id)
                .userName(peedDTO.getUserName())
                .content(peedDTO.getContent())
                .image(peedDTO.getImage())
                .commentList(peedDTO.getCommentList())
                .build();

        peedRepository.save(fixedPeed.toEntity());
        return fixedPeed;
    }

    // 피드 데이터 이미지와 함께 수정
    public void modifyPeed(Long id, PeedDTO peedDTO, ImageDTO imageDTO){
        PeedDTO fixedPeed = PeedDTO.builder()
                .id(id)
                .userName(peedDTO.getUserName())
                .content(peedDTO.getContent())
                .image(imageDTO.toEntity())
                .commentList(peedDTO.getCommentList())
                .build();

        peedRepository.save(fixedPeed.toEntity());
    }

    // 해당 id의 피드 데이터 삭제
    public void deletePeed(Long id){
        peedRepository.deleteById(id);
    }

    // 해당 id의 피드 조회
    public PeedDTO findOnePeed(Long id){
        Peed peed = peedRepository.findOnePeed(id);

        if(peed.getImage() != null){
            return PeedDTO.builder()
                    .id(peed.getId())
                    .userName(peed.getUserName())
                    .image(peed.getImage())
                    .content(peed.getContent())
                    .commentList(peed.getComments())
                    .build();
        }else return PeedDTO.builder()
                .id(peed.getId())
                .userName(peed.getUserName())
                .content(peed.getContent())
                .commentList(peed.getComments())
                .build();
    }

    // 전체 피드 조회
    public List<PeedDTO> findAllPeed(){
        List<Peed> allPeed = peedRepository.findAllPeed();
        return allPeed.stream().map(this::toDTO).toList();
    }
}
