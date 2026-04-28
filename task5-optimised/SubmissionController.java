import java.util.*;

public class SubmissionController {
    private Validator validator;
    private ReviewerDB reviewerDB;
    private SubmissionDB submissionDB;

    public SubmissionController(Validator validator, 
        ReviewerDB reviewerDB, SubmissionDB submissionDB) {
        this.validator = validator;
        this.reviewerDB = reviewerDB;
        this.submissionDB = submissionDB;
    }

    public String submit(Artefact data) {
 MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");         
        boolean valid = validator.validateFormat(data);
        if (!valid) {
            return "Error";
        }
        submissionDB.save(data);
        List<Reviewer> reviewers = reviewerDB.findAvailableReviewers(data);
        
        for (Reviewer reviewer : reviewers) {
            reviewer.assignReview(data);
        }
        return "Submission was successful";
    }
}
