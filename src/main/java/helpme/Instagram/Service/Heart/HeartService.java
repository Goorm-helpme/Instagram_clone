package helpme.Instagram.Service.Heart;

import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Domain.Peed;

import java.util.List;

public interface HeartService {
    void save(Heart heart);
    Heart findById(Long id);
    void delete(Long id);

    void clickLike(Long boardId);
    void clickDisLike(Long boardId);
    List<Heart> findAll();
}
