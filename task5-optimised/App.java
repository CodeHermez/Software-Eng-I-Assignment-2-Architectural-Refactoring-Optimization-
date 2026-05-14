import java.util.*;
public class App {
    /**
     * This application orchestrates self-documenting classes and self-explanatory functions, 
     * eliminating the need for inline comments through descriptive naming.So where there 
     * is a need and there maybe confusion in the interpretation of the function or class its further 
     * elaborated via comments.
     */

    public static void main(String[] args) {
        // creation and instanctiation of objects involved in system 
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
        /**
        *in the sequence diagram this object(systemScheduler) is called System indicating the system schedular
        *the system schedular that would be initiated gives contraints that would cause it to be triggered.
        *and in this instance its used for triggering the evaulation processes since these processes are separated 
        *now for more modularity.
        */
        //NB: using "System" as an object name or class name was not achievable because its a already a final class defined in java.lang.
        SystemS systemScheduler = new SystemS(evaluationManager); 
        Researcher researcher = new Researcher();
        Artefact myData = new Artefact();
        
        System.out.println("\nPHASE A: Submission");
        //function initiating the submission process
        researcher.interactWithSystem(systemUI, myData);
        List<Reviewer> assignedReviewers = reviewerDB.getMockReviewers(); 
        for(Reviewer reviewer: assignedReviewers){
            reviewer.simulateScoreSubmission();
        }
        System.out.println("\n\nPHASE B: SystemScheduler triggers final evaluation");
        systemScheduler.onAllScoresSubmitted("id1297", researcher, myData);

        System.out.println("\nTotal Method Calls (Optimised): " + MetricTracker.totalMethodCalls);
        System.out.println();
        //UNCOMMNET BENCHMARK CODE BELOW TO RUN IT!
        // benchMark(researcher, systemScheduler, systemUI, myData);
    }
     public static void benchMark(Researcher researcher, SystemS systemScheduler, UI systemUI, Artefact myData){
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
