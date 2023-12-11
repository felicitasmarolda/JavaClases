package prueboEquivalarUnCaracterAClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Operaciones {
    private static int a;
    private static int b;
    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    static ArrayList<Operaciones> posiblesOperaciones = new ArrayList<>(Arrays.asList(
            new Suma(a,b),
            new Resta(a,b),
            new Multiplicacion(a,b),
            new Division(a,b)));
    public static Operaciones buscoOperacion(String op){
        return posiblesOperaciones
                .stream()
                .filter(operacion -> operacion.canHandle(op))
                .collect(Collectors.toUnmodifiableList())
//                .toList()
                .get(0);
    }

    public abstract boolean canHandle(String op);

    public abstract int aplicar(int a, int b);
}
