package cochera;

public class WithMeeting extends Motivo{
    @Override
    public boolean filterMotivosByImportance(Motivo motivo) {
        return motivo.filterByImportanceWithMeeting();
    }

    @Override
    protected boolean filterByImportanceWithMeeting() {
        return false;
    }

    @Override
    protected boolean filterByImportanceWithClass() {
        return true;
    }
}
