package cocheraA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cochera {

    ArrayList<Postulante> candidatosForCochera = new ArrayList<Postulante>();
    ArrayList<Postulante> candidatosYaReservados = new ArrayList<Postulante>();
    ArrayList<LocalDate> fechasReservadas = new ArrayList<LocalDate>();

    public void cerrarFecha(LocalDate fecha) {
        ArrayList<Postulante> candidatosEnFecha = getPostulantesEnFechaEspecifica(fecha);
        if (candidatosEnFecha.size() == 1){
            reservarCandidato(candidatosEnFecha.get(0));
            return;
        }
        List<Postulante> candidatosConReunionConCliente = filtraPorMotivo(candidatosEnFecha, "Tengo reunión con cliente");

        if (candidatosConReunionConCliente.size() == 1){
            reservarCandidato(candidatosConReunionConCliente.get(0));
            return;
        }

        else if (candidatosConReunionConCliente.size() == 0) {
            List<Postulante> candidatosConClase = filtraPorMotivo(candidatosEnFecha, "Tengo que dar una clase");

            if (candidatosConClase.size() == 1){
                reservarCandidato(candidatosConClase.get(0));
                return;
            }

            else if (candidatosConClase.size() == 0) {
                List<Postulante> candidatosConUsoPersonal = filtraPorMotivo(candidatosEnFecha, "Uso personal");

                if (candidatosConUsoPersonal.size() == 1){
                    reservarCandidato(candidatosConUsoPersonal.get(0));
                    return;
                }
                else if (candidatosConUsoPersonal.size() == 0) {
                    return;
                }
                reservarCandidato(filtraPorOrdenDePostularse(candidatosConUsoPersonal));
                return;
            }
            reservarCandidato(filtraPorOrdenDePostularse(candidatosConClase));
            return;
        }
        else {
            reservarCandidato(filtraPorOrdenDePostularse(candidatosConReunionConCliente));
            return;
        }
    }
    private void reservarCandidato(Postulante candidato) {
        candidatosYaReservados.add(candidato);
        candidato.marcaComoReservado();
        fechasReservadas.add(candidato.getFechaAReservar());
    }
    private static List<Postulante> filtraPorMotivo(ArrayList<Postulante> candidatosEnFecha, String motivo) {
        List<Postulante> candidatosConReunionConCliente = candidatosEnFecha.stream()
                .filter(candidato -> candidato.getMotivo().equals(motivo))
                .collect(Collectors.toList());
        return candidatosConReunionConCliente;
    }
    private Postulante filtraPorOrdenDePostularse(List<Postulante> candidatosConMotivo) {
            return candidatosForCochera.stream()
                    .filter(candidatoForCochera -> candidatosConMotivo.stream()
                            .anyMatch(candidatoDeMotivoActual ->
                                    candidatoDeMotivoActual.getMotivo().equals("Uso personal") &&
                                            candidatoDeMotivoActual.equals(candidatoForCochera)))
                    .findFirst()
                    .orElse(null);
        }

    private ArrayList<Postulante> getPostulantesEnFechaEspecifica(LocalDate fecha) {
        ArrayList<Postulante> postulantesEnFechaEspecifica = candidatosForCochera.stream()
                .filter(candidato -> candidato.getFechaAReservar().equals(fecha))
                .collect(Collectors.toCollection(ArrayList::new));

        return postulantesEnFechaEspecifica;
    }

    public Postulante getCandidatoReservadoEn(LocalDate fecha){
        Postulante aDevolver = candidatosYaReservados.stream()
                .filter(candidato -> fechasReservadas.contains(fecha) && candidato.getFechaAReservar().equals(fecha))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se puede consultar la fecha si no está cerrada"));

        if (aDevolver == null){
            throw new RuntimeException("No se puede consultar la fecha si no está cerrada");
        }
        else{
            return aDevolver;
        }
    }
    public void registrarPostulante(Postulante postulante) {
        LocalDate fecha = postulante.getFechaAReservar();
        String motivo = postulante.getMotivo();

        fechasReservadas.stream()
                .filter(fechaReservada -> fechaReservada.equals(fecha))
                .findAny()
                .ifPresentOrElse(
                        fechaReservada -> {
                            throw new RuntimeException("No se puede postular una vez cerrada la fecha");
                        },
                        () -> candidatosForCochera.add(postulante)
                );
    }

}
