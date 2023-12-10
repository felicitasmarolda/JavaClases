import java.util.HashMap;
import java.util.stream.Collectors;

public class Cochera {
    HashMap<Fecha, Reservation> reservas;
    Cochera(){
        reservas = new HashMap<Fecha,Reservation>();
    }
    public int sizeOfReservas(){
        return reservas.size();
    }
    public void reservWithMeeting(Fecha fecha, String reservador){
        Reservation personaBuscandoReservar = new Reservation(reservador,new WithMeeting());
        filterReservationByPreviousAndReserv(fecha, personaBuscandoReservar);
    }
    public void reservWithClass(Fecha fecha, String reservador){
        Reservation personaBuscandoReservar = new Reservation(reservador,new WithClass());
        filterReservationByPreviousAndReserv(fecha, personaBuscandoReservar);
    }
    public void reservWithPersonalUse(Fecha fecha, String reservador){
        Reservation personaBuscandoReservar = new Reservation(reservador,new WithPersonalUse());
        filterReservationByPreviousAndReserv(fecha, personaBuscandoReservar);
    }
    private void filterReservationByPreviousAndReserv(Fecha fecha, Reservation personaBuscandoReservar) {
        reservas.putIfAbsent(fecha, personaBuscandoReservar);
        personaBuscandoReservar.getReason().filterByReason(reservas.get(fecha).getReason(), this, personaBuscandoReservar, fecha);
    }
    public void cerrarFecha(Fecha fecha){
        fecha.close();
    }
    public String getReservador(Fecha fecha){
        return fecha.checkIfFechaIsClosed(this);
    }
    public String getReservadorIfClosed(Fecha fecha){
        return reservas.computeIfAbsent(fecha, key -> {
            throw new RuntimeException("Fecha no reservada");
        }).getReservador();
    }
    public void reservAfterFiltering(Reservation personaBuscandoReservar, Fecha fecha) {
                reservas.remove(fecha);
                reservas.put(fecha, personaBuscandoReservar);
    }
}
