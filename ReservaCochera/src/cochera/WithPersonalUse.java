package cochera;

public class WithPersonalUse extends Motivo{
    @Override
    public boolean filterMotivosByImportance(Motivo motivo) {
        return false;
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
