package helpme.Instagram.Service.Reply;

import helpme.Instagram.Controller.Dto.ReplyDto;
import helpme.Instagram.Domain.Comment;
import helpme.Instagram.Domain.Reply;
import helpme.Instagram.Repository.CommentRepository;
import helpme.Instagram.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private CommentRepository commentRepository;

    public Reply createReply(ReplyDto replyDto) {
        Comment parentComment = commentRepository.findById(replyDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        Reply reply = new Reply();
        reply.setContent(replyDto.getContent());
        reply.setComment(parentComment);
        return replyRepository.save(reply);
    }

    public List<Reply> getReplies(int parentId) {
        Comment parentComment = commentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        return replyRepository.findByParentComment(parentComment);
    }

    public Reply updateReply(Long replyId, String content) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new IllegalArgumentException("답글이 존재하지 않습니다."));
        reply.setContent(content);
        return replyRepository.save(reply);
    }

    public void deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new IllegalArgumentException("답글이 존재하지 않습니다."));
        replyRepository.delete(reply);
    }
}