package helpme.Instagram.Service.Reply;

import helpme.Instagram.Domain.Comment;
import helpme.Instagram.Domain.Reply;
import helpme.Instagram.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public Reply createReply(String content, Long parentId) {
        Comment parentComment = commentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        Reply reply = new Reply();
        reply.setContent(content);
        reply.setParentComment(parentComment);
        return replyRepository.save(reply);
    }

    public List<Reply> getReplies(Long parentId) {
        Comment parentComment = commentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        return replyRepository.findByParentComment(parentComment);
    }
}