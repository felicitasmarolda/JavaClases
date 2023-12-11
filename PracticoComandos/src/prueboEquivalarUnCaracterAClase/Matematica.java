package prueboEquivalarUnCaracterAClase;

public class Matematica {
    private int resultado;
    public Matematica() {
        this.resultado = resultado;
    }
    public int getResultado() {
        return resultado;
    }
    public Operaciones consigoOperacion(int a, int b, String op) {
        return Operaciones.buscoOperacion(op);
    }
    public void aplicarOperacion(int a, int b, String op) {
        Operaciones operacion = consigoOperacion(a,b,op);
        this.resultado = operacion.aplicar(a,b);
    }
}
