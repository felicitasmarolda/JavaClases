import java.time.LocalDate;

public class PeriodHoliday extends Holiday{
    private final LocalDate initialDate;
    private final LocalDate finalDate;

    public PeriodHoliday(LocalDate initialDate, LocalDate finalDate) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return date.isAfter(initialDate) && date.isBefore(finalDate) || date.equals(initialDate) || date.equals(finalDate);
    }
}
