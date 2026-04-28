public class NotificationService {
    public void notifyAcceptance(Researcher r) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        sendNotification(r, "Accepted");
    }

    public void notifyRejection(Researcher r) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        sendNotification(r, "Rejected");
    }

    public void notifyRevision(Researcher r) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        sendNotification(r, "Revision Required");
    }

    private void sendNotification(Researcher r, String message) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
    }
}
