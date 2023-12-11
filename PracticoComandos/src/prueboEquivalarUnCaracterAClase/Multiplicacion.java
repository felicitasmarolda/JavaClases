package prueboEquivalarUnCaracterAClase;

public class Multiplicacion extends Operaciones{
    public Multiplicacion(int a, int b) {
        super(a, b);
    }

    @Override
    public boolean canHandle(String op) {
        return op == "por";
    }

    @Override
    public int aplicar(int a, int b) {
        return a * b;
    }
}
