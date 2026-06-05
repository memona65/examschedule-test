package exam.scheduling;

public class CapacityConstraint implements Constraint {
    public boolean isSatisfied(CourseExam exam, ExamHall hall, Timeslot start, int duration, ExamSchedule current)
    {
        return exam.getStudentCount() <= hall.getCapacity();
    }

}
