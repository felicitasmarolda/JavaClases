package cocheraReserva;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Postulante {

    private LocalDate fechaAReservar;
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
    public abstract void registrar();
    public abstract ArrayList<Postulante> getLista();
}
