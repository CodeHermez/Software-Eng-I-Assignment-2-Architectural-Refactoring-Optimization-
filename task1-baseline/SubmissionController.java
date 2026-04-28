import java.util.List;
public class SubmissionController {
    private Validator validator;
    private Database database;
    private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;

    public SubmissionController(Validator validator, Database database, 
        ReviewerManager reviewerManager, EvaluationManager evaluationManager) {
        this.validator = validator;
        this.database = database;
        this.reviewerManager = reviewerManager;
        this.evaluationManager=evaluationManager;
    }

    public String submit(Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        boolean valid = validator.validateFormat(data);
        if (!valid) {
            return "Error";
        }

        database.saveSubmission(data);
        List<Reviewer> reviewers = reviewerManager.getAvailableReviewers();
        for (Reviewer reviewer : reviewers) {
            reviewer.assignReview(data);
        }
        
        evaluationManager.startEvaluation(); 
        for(Reviewer reviewer: reviewers){
            reviewer.simulateScoreSubmission();
        }
        evaluationManager.processFinalEvaluation();
        return "Submission was successfully";
    }
}
