public class FechaStateOpen extends FechaState{
    @Override
    public String checkIfFechaIsClosed(Cochera cochera, Fecha fecha) {
        throw new RuntimeException("No se puede consultar una fecha abierta");
    }
}
