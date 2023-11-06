package agenda;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class FeriadoPorDia extends Feriado{
    private DayOfWeek dia;

    public FeriadoPorDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public boolean esFeriado(LocalDate date) {
        return dia.equals(date.getDayOfWeek());
    }
}
