public class App {
    public static void main(String[] args) {
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
        
        researcher.interactWithSystem(systemUI, myData);
        System.out.println("\nTotal Method Calls: " + MetricTracker.totalMethodCalls);
        System.out.println();
        benchMarch(researcher, systemUI, myData);
    }
    public static void benchMarch(Researcher researcher, UI systemUI, Artefact myData){
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