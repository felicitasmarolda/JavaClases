public class WithPersonalUse extends Reason{
    @Override
    public void filterByReason(Reason reason, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha) {
    }

    @Override
    protected void filterWithMeeting(WithMeeting withMeeting, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha) {
        cochera.reservAfterFiltering(personaBuscandoReservar, fecha);
    }

    @Override
    protected void filterWithClass(WithClass withClass, Cochera cochera, Reservation personaBuscandoReservar, Fecha fecha) {
        cochera.reservAfterFiltering(personaBuscandoReservar, fecha);
    }
}
