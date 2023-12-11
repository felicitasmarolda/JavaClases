package prueboEquivalarUnCaracterAClase;

public class Division extends Operaciones{

    @Override
    public boolean canHandle(String op) {
        return op == "dividir";
    }

    @Override
    public int aplicar(int a, int b) {
        return 0;
    }
}
