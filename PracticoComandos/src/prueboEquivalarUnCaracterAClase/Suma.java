package prueboEquivalarUnCaracterAClase;

public class Suma extends Operaciones{
    public boolean canHandle(String op) {
        return op == "mas";
    }

    @Override
    public int aplicar(int a, int b) {
        return a + b;
    }
}
