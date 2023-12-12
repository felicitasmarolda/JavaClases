import java.time.LocalDate;

public class OneDayHoliday extends Holiday{
    private LocalDate date;

    public OneDayHoliday(LocalDate date) {
        this.date = date;
    }

    public boolean isHoliday(LocalDate of) {
        return date.equals(of);
    }
}
