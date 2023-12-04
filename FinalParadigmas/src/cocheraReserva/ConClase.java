package cocheraReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConClase extends Postulante {
    ArrayList<Postulante> conClase = new ArrayList<Postulante>();
    public ConClase(LocalDate fechaAReservar) {
        super(fechaAReservar);
    }

    @Override
    public void registrar() {
        conClase.add(this);
    }

    @Override
    public ArrayList<Postulante> getLista() {
        return conClase;
    }

}
