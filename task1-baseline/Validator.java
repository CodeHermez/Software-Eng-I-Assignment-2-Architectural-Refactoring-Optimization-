class Validator {
    public boolean validateFormat(Artefact data) {
        boolean bool=true;
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName()+
        "("+bool+")");
        return bool;
    }
}
