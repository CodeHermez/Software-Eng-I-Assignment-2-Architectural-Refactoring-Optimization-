import java.util.*;
public class App {
    public static void main(String[] args) {
        SubmissionDB submissionDB = new SubmissionDB();
        EvaluationDB evaluationDB = new EvaluationDB();
        ReviewerDB reviewerDB = new ReviewerDB(evaluationDB); // pass evalDB so reviewers can score
        DMS dms = new DMS();
        NotificationService notificationService = new NotificationService();
        EvaluationManager evaluationManager = new 
        EvaluationManager(evaluationDB, dms, notificationService);
        SubmissionController controller = new 
        SubmissionController(new Validator(), reviewerDB, submissionDB);
        UI systemUI = new UI(controller);
        SystemS systemScheduler = new SystemS(evaluationManager);
        Researcher researcher = new Researcher();
        Artefact myData = new Artefact();
        
        System.out.println("\nPHASE A: Submission");
        researcher.interactWithSystem(systemUI, myData);
        List<Reviewer> assignedReviewers = reviewerDB.getMockReviewers(); 
        for(Reviewer reviewer: assignedReviewers){
            reviewer.simulateScoreSubmission();
        }
        System.out.println("\n\nPHASE B: SystemScheduler triggers final evaluation");
        systemScheduler.onAllScoresSubmitted("id1297", researcher, myData);

        System.out.println("\nTotal Method Calls (Optimised): " + MetricTracker.totalMethodCalls);
        System.out.println();
        benchMarch(researcher, systemScheduler, systemUI, myData);
    }
     public static void benchMarch(Researcher researcher, SystemS systemScheduler, UI systemUI, Artefact myData){
        long st = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            researcher.interactWithSystem(systemUI, myData);
            systemScheduler.onAllScoresSubmitted("SUB-" + i, researcher, myData);
        }
        long et = System.nanoTime();
        System.out.println("Task 5 Execution Time (1000 runs): " + (et - st) / 1_000_000.0 + " ms");
    }
}
class Artefact { public boolean isValidFormat = true; }
class MetricTracker {
    public static int totalMethodCalls = 0;
    
    public static void incrementCall(String call) {
        ++totalMethodCalls;
        System.out.print(call+"-> ");
    }
}
