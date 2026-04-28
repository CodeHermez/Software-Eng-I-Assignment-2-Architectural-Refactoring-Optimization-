import java.util.List;
import java.util.ArrayList;

public class Database {
    private EvaluationManager evalManager;
    public void setEvaluationManager(EvaluationManager evalManager) {
        this.evalManager = evalManager;
    }
    public void saveSubmission(Artefact data) { MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
    new Object(){}.getClass().getEnclosingMethod().getName()); }
    
    public List<Reviewer> fetchReviewers() { 
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
    
        List<Reviewer> mockReviewers = new ArrayList<>();
        mockReviewers.add(new Reviewer(evalManager));
        mockReviewers.add(new Reviewer(evalManager));
        mockReviewers.add(new Reviewer(evalManager));
        mockReviewers.add(new Reviewer(evalManager));
        return mockReviewers;
    }
    public void saveScore(int score) { MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
    new Object(){}.getClass().getEnclosingMethod().getName()); }
}
