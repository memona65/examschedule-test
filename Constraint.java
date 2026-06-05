package exam.scheduling;

public interface Constraint {
	boolean isSatisfied(CourseExam exam, ExamHall hall, Timeslot start, int duration, ExamSchedule current);

}


