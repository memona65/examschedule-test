package exam.scheduling;
import java.util.Objects;

public class Timeslot {
	private final int dayIndex;
    private final int periodIndex;
    public Timeslot(int day, int period) { dayIndex = day; periodIndex = period; }
    public int getDayIndex() { return dayIndex; }
    public int getPeriodIndex() { return periodIndex; }
    public String getDayName() { return new String[]{"Mon","Tue","Wed","Thu","Fri"}[dayIndex]; }
    public String getTime() { return new String[]{"8:00","9:00","10:00","11:00","12:00"}[periodIndex]; }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Timeslot)) return false;
        Timeslot t = (Timeslot) o;
        return dayIndex == t.dayIndex && periodIndex == t.periodIndex;
    }
    @Override public int hashCode() { return Objects.hash(dayIndex, periodIndex); }
    @Override public String toString() { return getDayName() + " " + getTime(); }

}
