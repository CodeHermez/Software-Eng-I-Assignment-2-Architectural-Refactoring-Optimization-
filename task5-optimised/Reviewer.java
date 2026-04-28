public class Reviewer {
    private EvaluationDB evaluationDB;
    
    public Reviewer(EvaluationDB evaluationDB){
        this.evaluationDB = evaluationDB;
    }
    
    public void assignReview(Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");    
    }
    
    public void simulateScoreSubmission(){
        evaluationDB.saveScore(81); 
    }
}