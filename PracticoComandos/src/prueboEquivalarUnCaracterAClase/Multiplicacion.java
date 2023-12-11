package prueboEquivalarUnCaracterAClase;

public class Multiplicacion extends Operaciones{

    @Override
    public boolean canHandle(String op) {
        return op == "por";
    }

    @Override
    public int aplicar(int a, int b) {
        return a * b;
    }
}
