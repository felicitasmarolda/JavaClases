public abstract class Reason {
    public abstract void filterByReason(Reason reason, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha);

    protected abstract void filterWithMeeting(WithMeeting withMeeting, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha);

    protected abstract void filterWithClass(WithClass withClass, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha);
}
