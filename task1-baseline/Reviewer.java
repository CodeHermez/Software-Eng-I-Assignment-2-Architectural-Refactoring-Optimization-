public class Reviewer {
    private EvaluationManager evalManager;
    public Reviewer(EvaluationManager evalManager){
        this.evalManager=evalManager;
    }
    public void assignReview(Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
    }
    public void simulateScoreSubmission(){
        evalManager.submitScore(92); 
    }
}
