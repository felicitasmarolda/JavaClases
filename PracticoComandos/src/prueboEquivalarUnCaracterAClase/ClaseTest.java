package prueboEquivalarUnCaracterAClase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClaseTest {
    @Test
    public void test00LaPlabraMASSuma(){
        Matematica matematica = new Matematica();
        matematica.aplicarOperacion(2,4,"mas");
        assertEquals(6,matematica.getResultado());
    }
    @Test public void test01LaPlabraMENOSResta(){
        Matematica matematica = new Matematica();
        matematica.aplicarOperacion(2,4,"menos");
        assertEquals(-2,matematica.getResultado());
    }
    @Test public void test02LaPlabraPORMultiplica(){
        Matematica matematica = new Matematica();
        matematica.aplicarOperacion(2,4,"por");
        assertEquals(8,matematica.getResultado());
    }
    @Test public void test03LaPlabraDIVIDIRDivide(){
        Matematica matematica = new Matematica();
        matematica.aplicarOperacion(2,4,"dividir");
        assertEquals(0,matematica.getResultado());
    }

}
