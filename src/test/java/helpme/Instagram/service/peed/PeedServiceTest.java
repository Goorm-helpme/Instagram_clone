package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
import helpme.Instagram.dto.PeedDTO;
import jakarta.persistence.Column;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PeedServiceTest {

    @Autowired
    private PeedService peedService;

    @Test
    @Commit
    void uploadPeed() {
        PeedDTO peedDTO = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        Long id = peedService.uploadPeed(peedDTO);

        PeedDTO peedDTO2 = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        peedService.uploadPeed(peedDTO2);

        PeedDTO result = peedService.findOnePeed(id);

        assertThat(peedDTO.getUserName()).isEqualTo(result.getUserName());
    }

    @Test
    void modifyPeed() {
        PeedDTO peedDTO = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();

        Long peedId = peedService.uploadPeed(peedDTO);

        PeedDTO fixedPeed = PeedDTO.builder()
                .userName("hi")
                .content("hello")
                .build();

        PeedDTO peedDTO1 = peedService.modifyPeed(peedId, fixedPeed);
        Peed entity = peedDTO1.toEntity();
        assertThat(entity.getContent()).isEqualTo("hello");
    }

    @Test
    void deletePeed() {
        PeedDTO peedDTO = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        peedService.uploadPeed(peedDTO);

        PeedDTO peedDTO2 = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        Long peedId = peedService.uploadPeed(peedDTO2);

        peedService.deletePeed(peedId);

        List<PeedDTO> allPeed = peedService.findAllPeed();
        assertThat(allPeed).hasSize(1);
    }

    @Test
    void findOnePeed() {
        PeedDTO peedDTO = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        Long peedId = peedService.uploadPeed(peedDTO);

        PeedDTO result = peedService.findOnePeed(peedId);

        assertThat(result.getId()).isEqualTo(peedId);
    }

    @Test
    void findAllPeed() {
        PeedDTO peedDTO = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        PeedDTO peedDTO2 = PeedDTO.builder()
                .userName("hello")
                .content("hi")
                .build();
        peedService.uploadPeed(peedDTO);
        peedService.uploadPeed(peedDTO2);

        List<PeedDTO> allPeed = peedService.findAllPeed();
        assertThat(allPeed).hasSize(2);
    }
}