package agenda.agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FeriadosEnIntervalo extends Feriado{
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public FeriadosEnIntervalo(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean esFeriado(LocalDate date) {
        return date.isAfter(fechaInicio) && date.isBefore(fechaFin) || date.isEqual(fechaInicio) || date.isEqual(fechaFin);
    }
}
