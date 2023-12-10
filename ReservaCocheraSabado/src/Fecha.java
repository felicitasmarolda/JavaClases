import java.time.LocalDate;

public class Fecha {
    private LocalDate date;
    private FechaState state;

    public Fecha(LocalDate date) {
        this.date = date;
        this.state = new FechaStateOpen();
    }
    public void close(){
        this.state = new FechaStateClosed();
    }

    public Object getState() {
        return state;
    }

    public String checkIfFechaIsClosed(Cochera cochera) {
        return state.checkIfFechaIsClosed(cochera, this);
    }
}
