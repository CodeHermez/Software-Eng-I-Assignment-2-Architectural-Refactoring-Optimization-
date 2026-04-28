public class NotificationService {
    public void dispatch(Outcome outcome, Researcher researcher) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");        
        System.out.println("Notification sent: " + outcome.toString());
    }
}