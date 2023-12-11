package prueboEquivalarUnCaracterAClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Operaciones {
    public Operaciones() {
    }
    static ArrayList<Operaciones> posiblesOperaciones = new ArrayList<>(Arrays.asList(
            new Suma(),
            new Resta(),
            new Multiplicacion(),
            new Division()));
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
