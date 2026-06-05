package exam.scheduling;

public class PreferredSlotConstraint implements Constraint {
    private CourseExam targetExam;
    private Timeslot[] preferredSlots;   // array of allowed start slots
    private int prefCount;
    public PreferredSlotConstraint(CourseExam exam, Timeslot[] slots, int count) {
        this.targetExam = exam;
        this.preferredSlots = new Timeslot[count];
        for (int i = 0; i < count; i++) 
        	preferredSlots[i] = slots[i];
        this.prefCount = count;
    }
    public boolean isSatisfied(CourseExam exam, ExamHall hall, Timeslot start, int duration, ExamSchedule current)
    {
        if (exam != targetExam) return true;
        for (int i = 0; i < prefCount; i++)
            if (preferredSlots[i].equals(start)) return true;
        return false;
    }
}
