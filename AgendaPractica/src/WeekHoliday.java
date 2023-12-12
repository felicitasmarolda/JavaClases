import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekHoliday extends Holiday{

    private DayOfWeek dayOfWeek;
    public WeekHoliday(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean isHoliday(LocalDate of) {
        return of.getDayOfWeek().equals(dayOfWeek);
    }
}
