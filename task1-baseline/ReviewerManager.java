import java.util.List;
public class ReviewerManager {
    private Database database;

    public ReviewerManager(Database database) {
        this.database = database;
    }

    public List<Reviewer> getAvailableReviewers() {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());

        // issue is everything is being fetched from DB to be filtered later
        List<Reviewer> allReviewers = database.fetchReviewers();
        List<Reviewer> noConflicts = filterConflicts(allReviewers);
        List<Reviewer> available = checkWorkload(noConflicts);

        return available;
    }

    private List<Reviewer> filterConflicts(List<Reviewer> reviewerList) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        return reviewerList; //cleaning
    }

    private List<Reviewer> checkWorkload(List<Reviewer> reviewerList) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        return reviewerList; //cleaning
    }
}
