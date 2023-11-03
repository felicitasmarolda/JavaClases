package agenda.agenda;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;
public class Agenda {

    public List<Feriado> todosLosFeriados;

    public Agenda(){
        todosLosFeriados = new ArrayList<Feriado>();
    }
    public Agenda agregaFeriado(LocalDate fecha) {
           todosLosFeriados.add( new FeriadoPorFecha (fecha));
     return this;
     }
    public Agenda agregaFeriado(DayOfWeek dia){
      todosLosFeriados.add(new FeriadoPorDia(dia));
      return this;
      }
    public Agenda agregaFeriado(LocalDate fechaInicial, LocalDate fechaFinal) {
        todosLosFeriados.add(new FeriadosEnIntervalo(fechaInicial, fechaFinal));
        return this;
    }

    public Boolean esFeriado( LocalDate fecha) {
        return todosLosFeriados.stream().anyMatch(feriado -> feriado.esFeriado(fecha));
        }


    public boolean esVacia() {
        return true;
    }
}
