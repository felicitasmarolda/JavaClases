package cocheraReserva;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CocheraTest {

    @Test
    public void test00CocheraBeginsEmpty(){
        Cochera cochera = new Cochera();
        assertEquals(0,cochera.candidatosForCochera.size());
        assertEquals(0, cochera.fechasReservadas.size());
    }

    @Test public void test01NuevoPostulanteConReunionSeRegistraCorrectamente(){
        Cochera cochera = new Cochera();
        Postulante postulante = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante);
        assertEquals(1, cochera.candidatosForCochera.size());
        assertEquals(0, cochera.fechasReservadas.size());
    }
    @Test public void test02NuevoPostulanteConClaseSeRegistraCorrectamente(){
        Cochera cochera = new Cochera();
        Postulante postulante = new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase");
        cochera.registrarPostulante(postulante);
        assertEquals(1, cochera.candidatosForCochera.size());
    }

    @Test public void test03NuevoPostulanteConUsoPersonalSeRegistraCorrectamente(){
        Cochera cochera = new Cochera();
        Postulante postulante = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
        cochera.registrarPostulante(postulante);
        assertEquals(1, cochera.candidatosForCochera.size());
        assertEquals(0, cochera.fechasReservadas.size());
    }

    @Test public void test04DosPostulantesEnDistintasFechasSeRegistranCorrectamente(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,2), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante1);
        cochera.registrarPostulante(postulante2);
        assertEquals(2, cochera.candidatosForCochera.size());
        assertEquals(0, cochera.fechasReservadas.size());
    }

    @Test public void test05DosPostulantesEnLaMismaFechaSeRegistranCorrectamente(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante1);
        cochera.registrarPostulante(postulante2);
        assertEquals(2, cochera.candidatosForCochera.size());
    }

    @Test public void test06CocheraReservaBienCuandoHayUnPostulanteConReunionEnUnaFecha(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante1);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertEquals(1, cochera.fechasReservadas.size());
        assertEquals(1, cochera.candidatosYaReservados.size());
    }

    @Test public void test07CocheraReservaBienCuandoHayUnPostulanteConClase(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase");
        cochera.registrarPostulante(postulante1);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertEquals(1, cochera.fechasReservadas.size());
        assertEquals(1, cochera.candidatosYaReservados.size());
    }

    @Test public void test08CocheraReservaBienCuandoHayUnPostulanteConUsoPersonal(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
        cochera.registrarPostulante(postulante1);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertEquals(1, cochera.fechasReservadas.size());
        assertEquals(1, cochera.candidatosYaReservados.size());
    }

    @Test public void test09CocheraReservaBienCuandoHayDosPostulantesConElMismoMotivo(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
        cochera.registrarPostulante(postulante1);
        cochera.registrarPostulante(postulante2);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertEquals(1, cochera.fechasReservadas.size());
        assertEquals(1, cochera.candidatosYaReservados.size());
        assertEquals(postulante1, cochera.candidatosYaReservados.get(0));
    }

    @Test public void test10CocheraReservaBienCuandoHayDosCandidatosConDiferentesMotivos(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase");
        cochera.registrarPostulante(postulante1);
        cochera.registrarPostulante(postulante2);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertEquals(1, cochera.fechasReservadas.size());
        assertEquals(1, cochera.candidatosYaReservados.size());
        assertEquals(postulante2, cochera.candidatosYaReservados.get(0));
    }

//    @Test public void test11NoSePuedeConsultarUnaFechaCerradaSiNoHayNadieReservado(){
//        Cochera cochera = new Cochera();
//        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
//        cochera.registrarPostulante(postulante1);
//        cochera.cerrarFecha(LocalDate.of(2023,1,1));
//        assertEquals(1, cochera.fechasReservadas.size());
//        assertEquals(1, cochera.candidatosYaReservados.size());
//        assertEquals(postulante1, cochera.candidatosYaReservados.get(0));
//    }

    @Test public void test04NoSePuedePostularUnaVezCerradaLaFecha(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante1);
        cochera.cerrarFecha(LocalDate.of(2023,1,1));
        assertThrowsLike( ()->cochera.registrarPostulante(postulante2), "No se puede postular una vez cerrada la fecha");
    }

    @Test public void test05NoSePuedeConsultarLaFechaSiNoEstaCerrada(){
        Cochera cochera = new Cochera();
        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
        cochera.registrarPostulante(postulante1);
        assertThrowsLike( ()->cochera.getCandidatoReservadoEn(LocalDate.of(2023,1,1) ), "No se puede consultar la fecha si no está cerrada");
    }
    private void assertThrowsLike( Executable executable, String message ) {
        assertEquals(message,
                assertThrows(Exception.class, executable)
                        .getMessage());
    }

    }
