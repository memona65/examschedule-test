package exam.scheduling;

import java.io.*;

public class DataManager {
	 private static final String HALLS_FILE = "halls.txt";
	    private static final String EXAMS_FILE = "exams.txt";
	    private static final String SCHEDULE_FILE = "schedule.txt";

	    public static void saveHalls(ExamHall[] halls, int count) throws IOException {
	        try (PrintWriter out = new PrintWriter(new FileWriter(HALLS_FILE))) {
	            out.println(count);
	            for (int i = 0; i < count; i++)
	                out.println(halls[i].getName() + "," + halls[i].getCapacity());
	        }
	    }

	    public static ExamHall[] loadHalls() throws IOException {
	        File f = new File(HALLS_FILE);
	        if (!f.exists()) return new ExamHall[0];
	        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	            int count = Integer.parseInt(br.readLine());
	            ExamHall[] halls = new ExamHall[count];
	            for (int i = 0; i < count; i++) {
	                String[] parts = br.readLine().split(",");
	                halls[i] = new ExamHall(parts[0], Integer.parseInt(parts[1]));
	            }
	            return halls;
	        }
	    }

	    public static void saveExams(CourseExam[] exams, int count) throws IOException {
	        try (PrintWriter out = new PrintWriter(new FileWriter(EXAMS_FILE))) {
	            out.println(count);
	            for (int i = 0; i < count; i++) {
	                CourseExam e = exams[i];
	                out.print(e.getCourseName() + "," + e.getStudentCount() + "," + e.getDuration());
	                int[] ids = e.getStudentIds();
	                for (int id : ids) out.print("," + id);
	                out.println();
	            }
	        }
	    }

	    public static CourseExam[] loadExams() throws IOException {
	        File f = new File(EXAMS_FILE);
	        if (!f.exists())
	        	return new CourseExam[0];
	        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	            int count = Integer.parseInt(br.readLine());
	            CourseExam[] exams = new CourseExam[count];
	            for (int i = 0; i < count; i++) {
	                String[] parts = br.readLine().split(",");
	                String name = parts[0];
	                int stud = Integer.parseInt(parts[1]);
	                int dur = Integer.parseInt(parts[2]);
	                CourseExam e = new CourseExam(name, stud, dur);
	                int[] ids = new int[stud];
	                for (int j = 0; j < stud; j++) ids[j] = Integer.parseInt(parts[3 + j]);
	                e.setStudentIds(ids);
	                exams[i] = e;
	            }
	            return exams;
	        }
	    }

	    public static void saveSchedule(ExamSchedule schedule) throws IOException {
	        try (PrintWriter out = new PrintWriter(new FileWriter(SCHEDULE_FILE))) {
	            out.println(schedule.getSize());
	            for (int i = 0; i < schedule.getSize(); i++) {
	                CourseExam e = schedule.getExam(i);
	                Assignment a = schedule.getAssignmentAt(i);
	                out.println(e.getCourseName() + "," + a.getHall().getName() + "," +
	                           a.getStartSlot().getDayIndex() + "," + a.getStartSlot().getPeriodIndex() + "," +
	                           a.getDuration());
	            }
	        }
	    }

	    public static ExamSchedule loadSchedule(ExamHall[] halls, int hallCount, CourseExam[] exams, int examCount) throws IOException {
	        File f = new File(SCHEDULE_FILE);
	        if (!f.exists()) return null;
	        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	            int size = Integer.parseInt(br.readLine());
	            ExamSchedule schedule = new ExamSchedule(examCount);
	            for (int i = 0; i < size; i++) {
	                String[] parts = br.readLine().split(",");
	                String courseName = parts[0];
	                String hallName = parts[1];
	                int day = Integer.parseInt(parts[2]);
	                int period = Integer.parseInt(parts[3]);
	                int dur = Integer.parseInt(parts[4]);
	                CourseExam exam = null;
	                for (int j = 0; j < examCount; j++) if (exams[j].getCourseName().equals(courseName)) { exam = exams[j]; break; }
	                ExamHall hall = null;
	                for (int j = 0; j < hallCount; j++) if (halls[j].getName().equals(hallName)) { hall = halls[j]; break; }
	                if (exam != null && hall != null)
	                    schedule.assign(exam, new Assignment(hall, new Timeslot(day, period), dur));
	            }
	            return schedule;
	        }
	    }

}
