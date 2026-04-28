
public class Researcher {
    // the researcher talks to passed in UI
    public void interactWithSystem(UI ui, Artefact data) {
        MetricTracker.incrementCall(this.getClass().getSimpleName()+"."+ 
        new Object(){}.getClass().getEnclosingMethod().getName());
        ui.submitResearchOutput(data);
    }
}
