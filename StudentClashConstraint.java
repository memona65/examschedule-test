package exam.scheduling;

public class StudentClashConstraint implements Constraint {
    public boolean isSatisfied(CourseExam exam, ExamHall hall, Timeslot start, int duration, ExamSchedule current) {
        int day = start.getDayIndex();
        int startP = start.getPeriodIndex();
        int endP = startP + duration - 1;
        for (int i = 0; i < current.getSize(); i++) {
            Assignment otherAss = current.getAssignmentAt(i);
            Timeslot otherStart = otherAss.getStartSlot();
            if (otherStart.getDayIndex() != day) continue;
            int otherStartP = otherStart.getPeriodIndex();
            int otherEndP = otherStartP + otherAss.getDuration() - 1;
            if (startP <= otherEndP && endP >= otherStartP) {
                // overlapping – check student clash
                CourseExam otherExam = current.getExam(i);
                for (int s1 = 0; s1 < exam.getStudentCount(); s1++) {
                    int sid = exam.getStudentIds()[s1];
                    for (int s2 = 0; s2 < otherExam.getStudentCount(); s2++) {
                        if (sid == otherExam.getStudentIds()[s2]) 
                        	return false;
                    }
                }
            }
        }
        return true;
    }

}
