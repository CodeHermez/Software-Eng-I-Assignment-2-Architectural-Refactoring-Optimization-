import java.util.List;
public class EvaluationManager {
    private EvaluationDB evalRepo;
    private DMS decisionEngine;
    private NotificationService notificationService;

    public EvaluationManager(EvaluationDB evalRepo, DMS decisionEngine, 
        NotificationService notificationService) {
        this.evalRepo = evalRepo;
        this.decisionEngine = decisionEngine;
        this.notificationService = notificationService;
    }

    public void processFinalEvaluation(String submissionId, 
        Researcher researcher, Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");
        List<Integer> scores = evalRepo.fetchAllScores(submissionId);
        
        int averageScore = 80;//dummy calculation results  
        boolean hasConsensus = true;
        Outcome finalOutcome = decisionEngine.evaluate(data.isValidFormat, 
            hasConsensus, averageScore);
        notificationService.dispatch(finalOutcome, researcher);
    }
}
