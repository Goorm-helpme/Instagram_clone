package helpme.Instagram.Service.Board;

import helpme.Instagram.Domain.Board;
import helpme.Instagram.Domain.Heart;
import helpme.Instagram.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 테스트용으로 구현하였습니다.
 * 현재는 간단하게 Board를 저장하는 기능만 가지고 있지만, 용도에 따라서 추가하거나 수정해주세요
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }
}
