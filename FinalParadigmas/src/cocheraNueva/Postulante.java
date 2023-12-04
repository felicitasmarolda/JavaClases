//package cocheraNueva;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public abstract class Postulante {
//
//    ArrayList<Postulante> listaReunion = new ArrayList<>();
//    ArrayList<Postulante> listaClase = new ArrayList<>();
//    ArrayList<Postulante> listaPersonal = new ArrayList<>();
//
//    private LocalDate fechaAReservar;
//    private String motivo;
//    private boolean estaReservado;
//
//    public Postulante(LocalDate fechaAReservar, String motivo) {
//        this.motivo = motivo;
//        boolean estaReservado = false;
//    }
//    public void marcaComoReservado(){
//        estaReservado = true;
//    }
//
//    public boolean estaReservado(){
//        return estaReservado;
//    }
//    public LocalDate getFechaAReservar(){
//        return fechaAReservar;
//    }
//    public String getMotivo() {
//        return motivo;
//    }
//
//    public abstract void registraEspecifica();
//}
