package exam.scheduling;

public class ExamSchedule {
	private CourseExam[] exams;      // parallel arrays
    private Assignment[] assignments;
    private int size;
    public ExamSchedule(int maxExams)
    { exams = new CourseExam[maxExams]; 
    assignments = new Assignment[maxExams]; 
    size = 0; 
    }
    
    public void assign(CourseExam exam, Assignment a) {
        exams[size] = exam;
        assignments[size] = a;
        size++;
    }
    
    public Assignment getAssignment(CourseExam exam) {
        for (int i = 0; i < size; i++) if (exams[i] == exam) return assignments[i];
        return null;
    }
    
    public int getSize() 
    { return size; }
    public CourseExam getExam(int idx)
    { return exams[idx]; }
    public Assignment getAssignmentAt(int idx)
    { return assignments[idx]; }
    
    public void removeLast() {
        if (size > 0) {
            size--;
            exams[size] = null;
            assignments[size] = null;
        }
    }
}
