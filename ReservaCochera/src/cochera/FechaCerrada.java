package cochera;

import java.time.LocalDate;
import java.util.Map;

public class FechaCerrada extends FechaState {

    @Override
    public void reservarEnFecha(Reserva reserva, Map<Fecha, Reserva> reservas, Fecha fecha) {
        throw new RuntimeException("No se puede reservar en una fecha cerrada");
    }

    @Override
    public String assertConsultable(Map<Fecha, Reserva> reservas, Fecha fecha) {
        return reservas.get(fecha).getCliente();
    }
}
