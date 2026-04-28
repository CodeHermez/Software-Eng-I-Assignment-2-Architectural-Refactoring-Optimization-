public class DMS {
    public Outcome evaluate(boolean isValidFormat, 
        boolean hasConsensus, int averageScore) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+"()");
        // Rule 7: Invalid Format (Overrides everything)
        if (!isValidFormat) return Outcome.ERROR;

        boolean over75 = averageScore >= 75;
        boolean over50 = averageScore >= 50;

        // Rules 1, 2, 3: Consensus Reached
        if (hasConsensus) {
            if (over75) return Outcome.ACCEPT;              
            if (over50) return Outcome.REVISION_REQUIRED;   
            return Outcome.REJECT;                          
        } 
        // Rules 4, 5, 6: No Consensus
        else {
            if (over75) return Outcome.REJECT;              
            if (over50) return Outcome.REVISION_REQUIRED;   
            return Outcome.REJECT;                          
        }
    }
}
enum Outcome { ACCEPT, REJECT, REVISION_REQUIRED, ERROR }