package helpme.Instagram.service.peed;

import helpme.Instagram.domain.Peed;
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
    void uploadPeed() {
        Peed peed = new Peed();
        peed.setUserName("hello");
        peed.setContent("hi");
        Long peedId = peedService.uploadPeed(peed);

        Peed findPeed = peedService.findOnePeed(peedId);

        assertThat(peed.getUserName()).isEqualTo(findPeed.getUserName());
    }

    @Test
    void modifyPeed() {
        Peed peed = new Peed();
        peed.setUserName("hello");
        peed.setContent("hi");

        Long peedId = peedService.uploadPeed(peed);

        Peed fixPeed = peedService.findOnePeed(peedId);
        fixPeed.setUserName("hi");
        fixPeed.setContent("hello");
        peedService.modifyPeed(peedId);

        assertThat(peed.getId()).isEqualTo(fixPeed.getId());
        assertThat(peed.getContent()).isEqualTo("hello");
    }

    @Test
    void deletePeed() {
        Peed peed = new Peed();
        peed.setUserName("hello");
        peed.setContent("hi");
        Long peedId = peedService.uploadPeed(peed);

        peedService.deletePeed(peedId);

        List<Peed> allPeed = peedService.findAllPeed();
        assertThat(allPeed).isEmpty();
    }

    @Test
    void findOnePeed() {
        Peed peed = new Peed();
        peed.setUserName("hello");
        peed.setContent("hi");
        Long peedId = peedService.uploadPeed(peed);

        Peed findPeed = peedService.findOnePeed(peedId);

        assertThat(findPeed.getId()).isEqualTo(peedId);
    }

    @Test
    void findAllPeed() {
        Peed peed = new Peed();
        peed.setUserName("hello");
        peed.setContent("hi");
        Peed peed2 = new Peed();
        peed2.setUserName("hello2");
        peed2.setContent("hi2");
        peedService.uploadPeed(peed);
        peedService.uploadPeed(peed2);

        List<Peed> allPeed = peedService.findAllPeed();
        assertThat(allPeed).hasSize(2);
    }
}