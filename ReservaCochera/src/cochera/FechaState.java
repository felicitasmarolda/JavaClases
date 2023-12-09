package cochera;

import java.time.LocalDate;
import java.util.Map;

public abstract class FechaState {
    public abstract void reservarEnFecha(Reserva reserva, Map<Fecha, Reserva> reservas, Fecha fecha);

    public abstract String assertConsultable(Map<Fecha, Reserva> reservas, Fecha fecha);
}
