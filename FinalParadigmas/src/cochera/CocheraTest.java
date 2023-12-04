//package cochera;
//import org.junit.Test;
//import org.junit.jupiter.api.function.Executable;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class CocheraTest {
//
//    @Test
//    public void test00CocheraBeginsEmpty(){
//        assertPosultantesYReservas(new Cochera(),0,0);
//    }
//
//    @Test public void test01NuevoPostulanteConReunionSeRegistraCorrectamente(){
//        assertPostulantesYReservasAfterRegistrar(new Cochera(),1,0, new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente"));
//
//    }
//
//    @Test public void test02NuevoPostulanteConClaseSeRegistraCorrectamente(){
//        assertPostulantesYReservasAfterRegistrar(new Cochera(),1,0, new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase"));
//    }
//
//    @Test public void test03NuevoPostulanteConUsoPersonalSeRegistraCorrectamente(){
//        assertPostulantesYReservasAfterRegistrar(new Cochera(),1,0, new Postulante(LocalDate.of(2023,1,1), "Uso personal"));
//    }
//
//    @Test public void test04DosPostulantesEnDistintasFechasSeRegistranCorrectamente(){
//        assertPostulantesYReservasAfterRegistrar(new Cochera(),2,0, new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente"), new Postulante(LocalDate.of(2023,1,2), "Tengo reunión con cliente"));
//    }
//
//    @Test public void test05DosPostulantesEnLaMismaFechaSeRegistranCorrectamente(){
//        assertPostulantesYReservasAfterRegistrar(new Cochera(),2,0, new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente"), new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente"));
//    }
//
//    @Test public void test06CocheraReservaBienCuandoHayUnPostulanteConReunionEnUnaFecha(){
//        assertAfterRegistrarYCerrar(new Cochera(), 1,1,LocalDate.of(2023,1,1), new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente"));
//    }
//
//    @Test public void test07CocheraReservaBienCuandoHayUnPostulanteConClase(){
//        assertAfterRegistrarYCerrar(new Cochera(), 1,1,LocalDate.of(2023,1,1), new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase"));
//    }
//
//    @Test public void test08CocheraReservaBienCuandoHayUnPostulanteConUsoPersonal(){
//        assertAfterRegistrarYCerrar(new Cochera(), 1,1,LocalDate.of(2023,1,1), new Postulante(LocalDate.of(2023,1,1), "Uso personal"));
//    }
//
//    @Test public void test09CocheraReservaBienCuandoHayDosPostulantesConElMismoMotivo(){
//        Cochera cochera = new Cochera();
//        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
//        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
//        assertAfterRegistrarYCerrar(cochera, 2,1,LocalDate.of(2023,1,1), postulante1, postulante2);
//        assertEquals(postulante1, cochera.candidatosYaReservados.get(0));
//    }
//
//    @Test public void test10CocheraReservaBienCuandoHayDosCandidatosConDiferentesMotivos(){
//        Cochera cochera = new Cochera();
//        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Uso personal");
//        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Tengo que dar una clase");
//        assertAfterRegistrarYCerrar(cochera, 2,1,LocalDate.of(2023,1,1), postulante1, postulante2);
//        assertEquals(postulante2, cochera.candidatosYaReservados.get(0));
//    }
//
//    @Test public void test11NoSePuedeConsultarUnaFechaCerradaSiNoHayNadieReservado(){
//        Cochera cochera = new Cochera();
//        cochera.cerrarFecha(LocalDate.of(2023,1,1));
//        assertPosultantesYReservas(cochera,0,0);
//        assertThrowsLike( ()->cochera.getCandidatoReservadoEn(LocalDate.of(2023,1,1) ), "No se puede consultar la fecha si no está cerrada");
//    }
//
//    @Test public void test04NoSePuedePostularUnaVezCerradaLaFecha(){
//        Cochera cochera = new Cochera();
//        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
//        Postulante postulante2 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
//        cochera.registrarPostulante(postulante1);
//        cochera.cerrarFecha(LocalDate.of(2023,1,1));
//        assertThrowsLike( ()->cochera.registrarPostulante(postulante2), "No se puede postular una vez cerrada la fecha");
//    }
//
//    @Test public void test05NoSePuedeConsultarLaFechaSiNoEstaCerrada(){
//        Cochera cochera = new Cochera();
//        Postulante postulante1 = new Postulante(LocalDate.of(2023,1,1), "Tengo reunión con cliente");
//        cochera.registrarPostulante(postulante1);
//        assertThrowsLike( ()->cochera.getCandidatoReservadoEn(LocalDate.of(2023,1,1) ), "No se puede consultar la fecha si no está cerrada");
//    }
//    private void assertThrowsLike( Executable executable, String message ) {
//        assertEquals(message,
//                assertThrows(Exception.class, executable)
//                        .getMessage());
//    }
//
//    private static void assertPosultantesYReservas(Cochera cochera, int postulantes, int reservas) {
//        assertEquals(postulantes, cochera.candidatosForCochera.size());
//        assertEquals(reservas, cochera.fechasReservadas.size());
//    }
//
//    private static void assertPostulantesYReservasAfterRegistrar(Cochera cochera, int pos, int reservas, Postulante... postulantes) {
//        Arrays.stream(postulantes).forEach(postulante -> {
//            cochera.registrarPostulante(postulante);
//        });
//                assertPosultantesYReservas(cochera, pos, reservas);
//    }
//
//    private static void assertAfterRegistrarYCerrar(Cochera cochera, int pos, int res,LocalDate fecha, Postulante ... postulantes) {
//        Arrays.stream(postulantes).forEach(postulante -> {
//            cochera.registrarPostulante(postulante);
//        });
//        cochera.cerrarFecha(fecha);
//        assertPosultantesYReservas(cochera,pos,res);
//    }
//    }
