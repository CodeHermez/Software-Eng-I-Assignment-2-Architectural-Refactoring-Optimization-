import java.util.*;
public class EvaluationDB {
    private List<Integer> scores = new ArrayList<>();

    public void saveScore(int score) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");        
        scores.add(score);
    }

    //retrieve queries in repo
    public List<Integer> fetchAllScores(String submissionId) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");        
        return scores; 
    }
}