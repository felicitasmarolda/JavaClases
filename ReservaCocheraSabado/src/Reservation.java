public class Reservation {
    private Reason reason;
    private String reservador;
    public Reservation(String reservador, Reason reason){
        this.reservador = reservador;
        this.reason = reason;
    }
    public String getReservador(){
        return reservador;
    }
    public Reason getReason(){
        return reason;
    }
}
