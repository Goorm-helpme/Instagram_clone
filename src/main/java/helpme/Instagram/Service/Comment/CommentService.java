package helpme.Instagram.Service.Comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import helpme.Instagram.Controller.Dto.CommentDto;
import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Domain.Comment;
import helpme.Instagram.Repository.peed.PeedRepository;
import helpme.Instagram.Repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PeedRepository peedRepository;

    // 댓글 생성
    @Transactional
    public CommentDto writeComment(Long peedId, CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());

        // 피드 찾기
        Peed peed = peedRepository.findById(peedId).orElseThrow(() -> {
            return new IllegalArgumentException("게시판을 찾을 수 없습니다.");
        });

        comment.setPeed(peed);
        commentRepository.save(comment);

        return CommentDto.toDto(comment);
    }


    // 전체 댓글 조회
    public List<CommentDto> getComments(Peed peed) {
        List<Comment> comments = commentRepository.findAllByPeed(peed);
        List<CommentDto> commentDtos = new ArrayList<>();

        comments.forEach(s -> commentDtos.add(CommentDto.toDto(s)));
        return commentDtos;
    }

    // 특정 댓글 조회
    public  CommentDto getComment(int id){
        Comment comment = commentRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("댓글 Id를 찾을 수 없습니다.");
        });
        CommentDto commentDto = CommentDto.toDto(comment);
        return commentDto;
    }

    // 특정 댓글 삭제
    @Transactional
    public String deleteComment(int commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> {
            return new IllegalArgumentException("댓글 Id를 찾을 수 없습니다.");
        });
        commentRepository.deleteById(commentId);
        return "삭제 완료";
    }
}
