package cochera;

import java.time.LocalDate;
import java.util.Map;

public class FechaAbierta extends FechaState {

    @Override
    public void reservarEnFecha(Reserva reserva, Map<Fecha, Reserva> reservas, Fecha fecha) {
        reservas.put(fecha, reserva.filterReservaWith(reservas.get(fecha)));
    }

    @Override
    public String assertConsultable(Map<Fecha, Reserva> reservas, Fecha fecha) {
        throw new RuntimeException("No se puede consultar si la fecha esta abierta");
    }
}
