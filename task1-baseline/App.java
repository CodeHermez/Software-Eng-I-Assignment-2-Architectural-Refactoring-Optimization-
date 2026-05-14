public class App {
    /**
     * This application orchestrates self-documenting classes and self-explanatory functions, 
     * eliminating the need for inline comments through descriptive naming.So where there 
     * is a need and there maybe confusion in the interpretation of the function or class its further 
     * elaborated via comments.
     */
    public static void main(String[] args) {
        // creation and instanctiation of objects involved in system 
        Database db = new Database();
        Validator validator = new Validator();
        ReviewerManager rm = new ReviewerManager(db);
        NotificationService notificationService = new NotificationService();
        Researcher researcher = new Researcher();
        EvaluationManager evalManager = new EvaluationManager(db, notificationService, researcher);
        db.setEvaluationManager(evalManager);
        SubmissionController controller = new SubmissionController(validator, db, rm,evalManager);
        UI systemUI = new UI(controller);
        Artefact myData = new Artefact();
        //function initiating the interaction process
        researcher.interactWithSystem(systemUI, myData);
        System.out.println("\nTotal Method Calls: " + MetricTracker.totalMethodCalls);
        System.out.println();
        //UNCOMMNET BENCHMARK CODE BELOW TO RUN IT!
        // benchMark(researcher, systemUI, myData);
    }
    public static void benchMark(Researcher researcher, UI systemUI, Artefact myData){
        long st = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            researcher.interactWithSystem(systemUI, myData);
        }
        long et = System.nanoTime();
        System.out.println("Task 1 Execution Time (1000 runs): " + (et - st) / 1_000_000.0 + " ms");
    }
}

class Artefact {
    //submission payload
}
class MetricTracker {
    public static int totalMethodCalls = 0;
    
    public static void incrementCall(String call) {
        ++totalMethodCalls;
        System.out.print(call+"-> ");
    }
}