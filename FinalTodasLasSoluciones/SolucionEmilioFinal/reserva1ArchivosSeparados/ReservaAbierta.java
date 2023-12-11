package reserva1ArchivosSeparados;

class ReservaAbierta extends Reserva {
    public Reserva cerrar() {
        return new ReservaVacante();
    }

    public Reserva mejorDe(Reserva nueva) {
        return nueva;
    }
}
