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
    @PostMapping("/comments/comment/{id}")
    public ResponseDto<String> writeComment(@PathVariable("id") Long boardId, @RequestBody CommentDto commentDto) {
        commentService.writeComment(boardId, commentDto);
        return new ResponseDto<String>(HttpStatus.OK.value(), "댓글 작성을 완료했습니다.");
    }


    // 전체 댓글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comments/{id}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable("id") Long boardId) {
        Peed peed = peedService.findById(boardId);
        List<CommentDto> findComment = commentService.getComments(peed);
        return ResponseEntity.ok(findComment);
    }

     //특정 댓글 조회
    @GetMapping("/comments/comment/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable("id") Long id){
        return ResponseEntity.ok(commentService.getComment(id));
    }

    //특정 댓글 수정
    @PutMapping("/comments/comment/{id}")
    public ResponseDto<String> modifyComment(@PathVariable("id") Long Id, @RequestBody CommentDto commentDto) {
        commentService.modifyComment(Id, commentDto);
        return new ResponseDto<String>(HttpStatus.OK.value(), "댓글 수정을 완료했습니다.");
    }

    // 특정 댓글 삭제
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/comments/comment/{id}")
    public ResponseDto<String>  deleteComment(@PathVariable("id") Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseDto<String>(HttpStatus.OK.value(), "댓글 삭제 완료");
    }

}
