package cocheraReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConReunion extends Postulante{
    ArrayList<Postulante> conReunionLista = new ArrayList<Postulante>();

    public ConReunion(LocalDate fechaAReservar) {
        super(fechaAReservar);
    }

    @Override
    public void registrar() {
        conReunionLista.add(this);
    }

    @Override
    public ArrayList<Postulante> getLista() {
        return conReunionLista;
    }
}
