public class SystemS {
    private EvaluationManager evaluationManager;

    public SystemS(EvaluationManager evaluationManager) {
        this.evaluationManager = evaluationManager;
    }

    public void onAllScoresSubmitted(String submissionId, 
        Researcher researcher, Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");
        //from here on wards the system will trigger the evaluation
        evaluationManager.processFinalEvaluation(submissionId, 
            researcher, data);
    }
}
