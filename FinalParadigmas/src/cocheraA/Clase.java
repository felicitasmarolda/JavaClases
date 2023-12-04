package cocheraA;

import java.time.LocalDate;
import java.util.ArrayList;

public class Clase extends Postulante{
    ArrayList<Postulante> candidatos = new ArrayList<>();

    public Clase(LocalDate fechaAReservar, String motivo) {
        super(fechaAReservar, motivo);
    }
//
//    @Override
//    public void registraEspecifica() {
//        listaClase.add(this);
//    }
}
