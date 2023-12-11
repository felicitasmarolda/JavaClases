package prueboEquivalarUnCaracterAClase;

public class Suma extends Operaciones{
    public Suma(int a, int b) {
        super(a, b);
    }
    public boolean canHandle(String op) {
        return op == "mas";
    }

    @Override
    public int aplicar(int a, int b) {
        return a + b;
    }
}
