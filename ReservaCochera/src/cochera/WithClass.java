package cochera;

public class WithClass extends Motivo{

    @Override
    public boolean filterMotivosByImportance(Motivo motivo) {
        return motivo.filterByImportanceWithClass();
    }

    @Override
    protected boolean filterByImportanceWithMeeting() {
        return false;
    }

    @Override
    protected boolean filterByImportanceWithClass() {
        return false;
    }
}
