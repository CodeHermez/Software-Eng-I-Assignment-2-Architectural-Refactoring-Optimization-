public class SubmissionDB {
    public void save(Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");   
    }
}
