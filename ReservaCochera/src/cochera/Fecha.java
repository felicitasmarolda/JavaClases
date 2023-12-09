package cochera;

import java.time.LocalDate;
import java.util.Map;

public class Fecha {
    private LocalDate fecha;
    private FechaState state = new FechaAbierta();
    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
        this.state = state;
    }

    public LocalDate getFecha(){
        return fecha;
    }
    public FechaState getState(){
        return state;
    }
    public void setStateToClosed(){
        this.state = new FechaCerrada();
    }
    public void reservarEnFecha(Reserva reserva, Map<Fecha, Reserva> reservas){
        state.reservarEnFecha(reserva, reservas, this);
    }

    public void cerrarConFecha(){
        this.state = new FechaCerrada();
    }

    public String assertConsultable(Map<Fecha, Reserva> reservas) {
        return state.assertConsultable(reservas, this);
    }
}
