package helpme.Instagram.Controller;

import helpme.Instagram.Controller.Dto.ReplyDto;
import helpme.Instagram.Domain.Reply;
import helpme.Instagram.Service.Reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies")
public class ReplyApiController {

    //TODO: field injection -> constructor injection
    @Autowired
    private ReplyService replyService;


    //TODO: 응답은 항상 있어야 함. void method
    //TODO: ~~~Dto 로 두기 보다는 ~~Request, ~~Response 로 명확하게 하는 것이 좋음.
    @PostMapping
    public String createReply(@RequestBody ReplyDto replyDto) {
        replyService.createReply(replyDto);
        return "OK";
    }

    @GetMapping("/{parentId}")
    public List<Reply> getReplies(@PathVariable Long parentId) {
        return replyService.getReplies(parentId);
    }

    @PutMapping("/{replyId}")
    public Reply updateReply(@PathVariable Long replyId, @RequestBody Map<String, String> requestBody) {
        String content = requestBody.get("content");
        return replyService.updateReply(replyId, content);
    }

    @DeleteMapping("/{replyId}")
    public void deleteReply(@PathVariable Long replyId) {
        replyService.deleteReply(replyId);
    }
}