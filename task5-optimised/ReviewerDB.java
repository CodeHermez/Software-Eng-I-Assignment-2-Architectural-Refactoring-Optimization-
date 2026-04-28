import java.util.*;

public class ReviewerDB {
    private EvaluationDB evaluationDB;

    public ReviewerDB(EvaluationDB evaluationDB) {
        this.evaluationDB = evaluationDB;
    }

    public List<Reviewer> findAvailableReviewers(Artefact data) {
 MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");         
        List<Reviewer> assigned = new ArrayList<>();
        assigned.add(new Reviewer(evaluationDB));
        assigned.add(new Reviewer(evaluationDB));
        return assigned;
    }

    public List<Reviewer> getMockReviewers() {
        List<Reviewer> mockReviewers = new ArrayList<>();
        mockReviewers.add(new Reviewer(evaluationDB));
        mockReviewers.add(new Reviewer(evaluationDB));
        return mockReviewers;
    }
}
