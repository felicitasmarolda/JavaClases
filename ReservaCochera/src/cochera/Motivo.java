package cochera;

public abstract class Motivo {
    public abstract boolean filterMotivosByImportance(Motivo motivo);

    protected abstract boolean filterByImportanceWithMeeting();

    protected abstract boolean filterByImportanceWithClass();
}
