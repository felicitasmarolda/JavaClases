package cocheraA;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reunion extends Postulante{
    ArrayList<Postulante> candidatos = new ArrayList<>();
    public Reunion(LocalDate fechaAReservar, String motivo) {
        super(fechaAReservar, motivo);
    }
//
//    @Override
//    public void registraEspecifica() {
//        listaReunion.add(this);
//
//    }
}
