package helpme.Instagram.Controller;

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

    @PostMapping("/{parentId}")
    public Reply createReply(@PathVariable Long parentId, @RequestBody Map<String, String> requestBody) {
        String content = requestBody.get("content");
        return replyService.createReply(content, parentId);
    }

    @GetMapping("/{parentId}")
    public List<Reply> getReplies(@PathVariable Long parentId) {
        return replyService.getReplies(parentId);
    }
}