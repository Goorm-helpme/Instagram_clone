package helpme.Instagram.Service.Heart;

import helpme.Instagram.Domain.Board;
import helpme.Instagram.Domain.Heart;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface HeartService {
    void save(Heart heart);
    Heart findById(Long id);
    List<Heart> findByBoard(Board board);
    void delete(Long id);

    void clickLike(Long id);
    void clickDisLike(Long id);
}
