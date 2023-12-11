package reserva1ArchivosSeparados;

class ReservaNominada extends Reserva {
    private int prioridad;
    protected String nombre;

    public ReservaNominada(String aName, int prioridad) {
        this.prioridad = prioridad;
        this.nombre = aName;
    }

    public Reserva cerrar() {
        return new ReservaCerrada(nombre);
    }

    public int prioridad() {
        return prioridad;
    }

    public Reserva mejorDe(Reserva nueva) {
        if (prioridad >= nueva.prioridad()) {
            return this;
        } else {
            return nueva;
        }
    }
}
