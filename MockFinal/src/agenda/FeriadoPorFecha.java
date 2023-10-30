package agenda;

import java.time.LocalDate;
public class FeriadoPorFecha extends Feriado{
    private LocalDate fecha;

    public FeriadoPorFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean esFeriado(LocalDate date) {
        return fecha.equals(date);
    }
}
