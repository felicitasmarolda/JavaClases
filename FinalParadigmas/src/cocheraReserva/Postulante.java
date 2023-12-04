package cocheraReserva;
import java.time.LocalDate;

public abstract class Postulante {

    private LocalDate fechaAReservar;
    private String motivo;
    private boolean estaReservado;

    public Postulante(LocalDate fechaAReservar) {
        this.fechaAReservar = fechaAReservar;
        boolean estaReservado = false;
    }
    public void marcaComoReservado(){
        estaReservado = true;
    }

    public boolean estaReservado(){
        return estaReservado;
    }
    public LocalDate getFechaAReservar() {
        return fechaAReservar;
    }
}
