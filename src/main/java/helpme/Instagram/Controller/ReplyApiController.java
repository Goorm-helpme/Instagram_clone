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
    @Autowired
    private ReplyService replyService;

    @PostMapping
    public void createReply(@RequestBody ReplyDto replyDto) {
        replyService.createReply(replyDto);
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