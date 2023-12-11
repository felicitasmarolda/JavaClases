package prueboEquivalarUnCaracterAClase;

public class Division extends Operaciones{
    public Division(int a, int b) {
        super(a, b);
    }

    @Override
    public boolean canHandle(String op) {
        return op == "dividir";
    }

    @Override
    public int aplicar(int a, int b) {
        return 0;
    }
}
