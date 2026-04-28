public class UI {
    private SubmissionController submissionController;

    public UI(SubmissionController submissionController) {
        this.submissionController = submissionController;
    }

    public void submitResearchOutput(Artefact data) {
 MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");         
        String response = submissionController.submit(data);
        System.out.println("System output: " + response);
    }
}
