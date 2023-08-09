package helpme.Instagram.repository.peed;

import helpme.Instagram.domain.Peed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPeedRepository extends JpaRepository<Peed, Long> {

    // 피드 한개 조회시 연관관계인 이미지 데이터 함께 조회
    @Query("select p from Peed p" + " left join fetch p.image" + " where p.id = :id")
    Peed findOnePeed(@Param("id") Long id);

    // 전체 피드 조회시 연관관계인 이미지 데이터 함께 조회
    @Query("select p from Peed p left join fetch p.image")
    List<Peed> findAllPeed();
}
