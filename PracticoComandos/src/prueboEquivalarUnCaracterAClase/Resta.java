package prueboEquivalarUnCaracterAClase;

public class Resta extends Operaciones{

    @Override
    public boolean canHandle(String op) {
        return op == "menos";
    }

    @Override
    public int aplicar(int a, int b) {
        return a - b;
    }
}
