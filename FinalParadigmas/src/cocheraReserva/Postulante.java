package cocheraReserva;
import java.time.LocalDate;

public class Postulante {

    private LocalDate fechaAReservar;
    private String motivo;
    private boolean estaReservado;

    public Postulante(LocalDate fechaAReservar, String motivo) {
        this.fechaAReservar = fechaAReservar;
        this.motivo = motivo;
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

    public String getMotivo() {
        return motivo;
    }
}
