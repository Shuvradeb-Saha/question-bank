package spl.question.bank.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spl.question.bank.database.client.CQQuestionMapper;
import spl.question.bank.database.model.CQQuestion;
import spl.question.bank.database.model.CQQuestionExample;
import spl.question.bank.model.admin.Roles;
import spl.question.bank.model.question.QuestionStatus;

import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static spl.question.bank.model.question.QuestionStatus.pending;

@Service
@Slf4j
public class CqService {
  private final CQQuestionMapper cqQuestionMapper;
  private final UserService userService;

  public CqService(CQQuestionMapper cqQuestionMapper, UserService userService) {
    this.cqQuestionMapper = cqQuestionMapper;
    this.userService = userService;
  }

  public ResponseEntity saveCq(CQQuestion cqQuestion) {
    Integer creatorId = cqQuestion.getCreatedBy();
    Integer subjectId = cqQuestion.getSubjectId();
    if (!userService.checkTeacherSubject(creatorId, subjectId)) {
      throw new IllegalArgumentException("You are not assigned in the subject.");
    }
    if (cqQuestion.getWeight() < 0) {
      throw new IllegalArgumentException("Question weight must be positive.");
    }

    validateCq(cqQuestion);
    cqQuestion.setStatus(pending.name());
    cqQuestion.setCreatedAt(new Date(System.currentTimeMillis()));
    cqQuestionMapper.insert(cqQuestion);
    return ResponseEntity.ok("CQ question added successfully.");
  }

  private void validateCq(CQQuestion cq) {
    if (isBlank(cq.getStem())
        || isBlank(cq.getKnowledgeBased())
        || isBlank(cq.getApplicationBased())
        || isBlank(cq.getUnderstandingBased())
        || isBlank(cq.getHigherAbility())) {
      throw new IllegalArgumentException("Write all cq part correctly.");
    }
  }

  public ResponseEntity getCQById(Integer cqId) {
    val cqQuestion = cqQuestionMapper.selectByPrimaryKey(cqId);
    if (isNull(cqQuestion)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No CQ found with id => " + cqId);
    }
    val authenticatedUserId = userService.getAuthenticatedUser().getId();
    // Question creator & moderators can view the question
    if (!authenticatedUserId.equals(cqQuestion.getCreatedBy())) {
      if (!userService.getRolesByUser(authenticatedUserId).contains(Roles.MODERATOR.name())) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body("You don't have access to see this question.");
      }
    }
    return ResponseEntity.ok().body(cqQuestion);
  }

  public List<CQQuestion> getCQListByStatus(QuestionStatus status, Integer teacherId) {
    val ex = new CQQuestionExample();
    ex.createCriteria().andStatusEqualTo(status.name()).andCreatedByEqualTo(teacherId);
    return cqQuestionMapper.selectByExample(ex);
  }

  public ResponseEntity retrieveCQForModerator(QuestionStatus status) {
    return ResponseEntity.ok("done");
  }
}
