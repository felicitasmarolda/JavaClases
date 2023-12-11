package reserva1ArchivosSeparados;

class ReservaCerrada extends Reserva {
    protected String ganador;

    public ReservaCerrada(String aName) {
        ganador = aName;
    }

    public String consultar() {
        return ganador;
    }
}
