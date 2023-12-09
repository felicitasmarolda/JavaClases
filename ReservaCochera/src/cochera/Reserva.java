package cochera;

public class Reserva {
    Motivo motivo;
    String cliente;
    Fecha fecha;
    public Reserva(Fecha fecha, Motivo motivo, String cliente) {
        this.motivo = motivo;
        this.cliente = cliente;
        this.fecha = fecha;
    }
    public Motivo getMotivo() {
        return motivo;
    }
    public Fecha getFecha() {
        return fecha;
    }
    public String getCliente() {
        return cliente;
    }
    public Reserva filterReservaWith(Reserva reservaAComparar){
        return reservaAComparar.getMotivo().filterMotivosByImportance(this.getMotivo()) ? reservaAComparar : this;
    }

}
