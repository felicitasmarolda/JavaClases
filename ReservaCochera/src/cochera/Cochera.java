package cochera;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cochera {
    HashMap<Fecha, Reserva> reservas;
    public Cochera() {
        this.reservas = new HashMap<Fecha, Reserva>();
    }

    public void reservarAsMeeting(Fecha fecha, String cliente) {
        Reserva reserva = new Reserva(fecha, new WithMeeting(), cliente);
        reservas.put(fecha, reserva);

//        reservaAndChecksForEmptyDate(fecha, reserva);
    }

    public getReservas(){
        return reservas;
    }

    public void reservarAsClass(Fecha fecha, String cliente) {
        Reserva reserva = new Reserva(fecha, new WithClass(), cliente);
        reservaAndChecksForEmptyDate(fecha, reserva);
    }
    public void reservarAsPersonalUse(Fecha fecha, String cliente) {
        Reserva reserva = new Reserva(fecha, new WithPersonalUse(), cliente);
        reservaAndChecksForEmptyDate(fecha, reserva);
    }

    private void reservaAndChecksForEmptyDate(Fecha fecha, Reserva reserva) {
//        Set<Fecha> fechasConReservas = reservas.keySet();
//        for (Fecha fechaConReserva : fechasConReservas){
//            if (fechaConReserva.equals(fecha)){
//                fechaConReserva.reservarEnFecha(reserva, reservas);
//                reservas.remove(fechaConReserva);
//                break;
//            }
//        }
        reservas.put(fecha, reserva);
    }

    public void cerrarFecha(Fecha fecha){
        fecha.cerrarConFecha();
            if (reservas.get(fecha) != null){
                reservas.remove(fecha);
        }
    }
//    public String getPersonReservedIn(Fecha fecha) {
//        Set<Fecha> fechasConReservas = reservas.keySet();
//        for (Fecha fechaConReserva : fechasConReservas) {
//            if (fechaConReserva.equals(fecha)) {
//                Reserva reserva = reservas.get(fechaConReserva);
//                if (reserva != null) {
//                    return reserva.getCliente();
//                } else {
//                    throw new RuntimeException("Reserva nula para la fecha");
//                }
//            }
//            }
//
////        return "Fecha no encontrada en las reservas";
////
////        return fecha.assertConsultable(reservas);
//    }

    public String getQuienFueAsignado(Fecha fecha){
        if (fecha.getState() instanceof FechaAbierta){
            throw new RuntimeException("No se puede consultar si la fecha esta abierta");
        }
        else{
            if(reservas.get(fecha) != null){
                return reservas.get(fecha).getCliente();
            }
            else{
                throw new RuntimeException("No hay reserva");
            }
        }
    }
}


