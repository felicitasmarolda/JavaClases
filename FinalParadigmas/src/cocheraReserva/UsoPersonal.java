package cocheraReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsoPersonal extends Postulante{
    ArrayList<Postulante> usoPersonal = new ArrayList<Postulante>();
    public UsoPersonal(LocalDate fechaAReservar) {
        super(fechaAReservar);
    }

    @Override
    public void registrar() {
        usoPersonal.add(this);
    }

    @Override
    public ArrayList<Postulante> getLista() {
        return usoPersonal;
    }


}
