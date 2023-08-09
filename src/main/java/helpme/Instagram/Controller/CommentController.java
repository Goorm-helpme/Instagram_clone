package helpme.Instagram.Controller;

import helpme.Instagram.Controller.Dto.ResponseDto;
import helpme.Instagram.Domain.Peed;
import helpme.Instagram.Service.peed.PeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import helpme.Instagram.Controller.Dto.CommentDto;
import helpme.Instagram.Service.Comment.CommentService;
import helpme.Instagram.Repository.peed.PeedRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final PeedService peedService;

    // 댓글 생성
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/comments/comment")
    public ResponseDto<String> writeComment(@PathVariable("boardId") Long boardId, @RequestBody CommentDto commentDto) {
        commentService.writeComment(boardId, commentDto);
        return new ResponseDto<String>(HttpStatus.OK.value(), "댓글 작성을 완료했습니다.");
    }


    // 전체 댓글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comments")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable("boardId") Long boardId) {
        Peed peed = peedService.findById(boardId);
        List<CommentDto> findComment = commentService.getComments(peed);
        return ResponseEntity.ok(findComment);
    }


    // 특정 댓글 삭제
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/comments/comment/{Id}")
    public ResponseDto<String>  deleteComment(@PathVariable("boardId") Integer boardId, @PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return new ResponseDto<String>(HttpStatus.OK.value(), "댓글 삭제 완료");
    }

}
