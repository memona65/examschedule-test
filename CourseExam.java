package exam.scheduling;

public class CourseExam {
	private String courseName;
    private int studentCount;
    private int duration;
    private int[] studentIds;      // manual array, no Set
    public CourseExam(String name, int count, int duration) {
        this.courseName = name;
        this.studentCount = count;
        this.duration = duration;
        this.studentIds = new int[count];
        for (int i = 0; i < count; i++) studentIds[i] = i + 1;  // dummy IDs
    }
    public String getCourseName() { return courseName; }
    public int getStudentCount() { return studentCount; }
    public int getDuration() { return duration; }
    public int[] getStudentIds() { return studentIds; }
    public boolean hasStudent(int id) {
        for (int i = 0; i < studentCount; i++) if (studentIds[i] == id) return true;
        return false;
    }
    public void setStudentIds(int[] ids) 
    { this.studentIds = ids; this.studentCount = ids.length; }
    
    @Override
    public String toString() {
        return courseName + " (" + studentCount + " students, " + duration + "h)";
    }
}
