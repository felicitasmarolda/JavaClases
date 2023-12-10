public class FechaStateClosed extends FechaState{
    @Override
    public String checkIfFechaIsClosed(Cochera cochera, Fecha fecha) {
        return cochera.getReservadorIfClosed(fecha);
    }
}
