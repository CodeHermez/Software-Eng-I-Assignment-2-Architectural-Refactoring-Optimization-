public class Validator {
    public boolean validateFormat(Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+
        "("+data.isValidFormat+")");          
        return data.isValidFormat;
    }
}
