import java.util.ArrayList;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Agenda {
    ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    public int size() {
        return holidays.size();
    }

    public void addHoliday(LocalDate holidayToAdd) {
        holidays.add(new OneDayHoliday(holidayToAdd));
    }

    public void addHoliday(LocalDate initialDate, LocalDate finalDate) {
        holidays.add(new PeriodHoliday(initialDate, finalDate));
    }

    public void addHoliday(DayOfWeek dayOfWeek) {
        holidays.add(new WeekHoliday(dayOfWeek));
    }

    public boolean isHoliday(LocalDate of) {
        return holidays.stream().anyMatch(holiday -> holiday.isHoliday(of));
    }
}
