public class EvaluationManager {
    private Database database;
    private NotificationService notificationService;
    private Researcher researcher;

    public EvaluationManager(Database database,NotificationService notificationService, Researcher researcher){
        this.database=database;
        this.notificationService=notificationService;
        this.researcher=researcher;
    }
    public void submitScore(int score) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        database.saveScore(score);
    }

    public void processFinalEvaluation() {
        calculateAverage();
        checkConsensus();
        String outcome = applyRules();

        if (outcome.equals("accepted")) {
            notificationService.notifyAcceptance(researcher);
        } else if (outcome.equals("rejected")) {
            notificationService.notifyRejection(researcher);
        } else if (outcome.equals("revision")) {
            notificationService.notifyRevision(researcher);
        }
    }
    public void startEvaluation() {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()); 
        
    }

    private void calculateAverage() { MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
    new Object(){}.getClass().getEnclosingMethod().getName()); }
    private void checkConsensus() { MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
    new Object(){}.getClass().getEnclosingMethod().getName()); }
    private String applyRules() { 
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()); 
        return "accepted";
    }
}
