package exam.scheduling;

public class Assignment {
	 private ExamHall hall;
	    private Timeslot startslot;
	    private int duration;
	    public Assignment(ExamHall hall, Timeslot start, int dur)
	    { this.hall = hall; this.startslot = start; this.duration = dur; }
	    public ExamHall getHall() { return hall; }
	    public Timeslot getStartSlot() { return startslot; }
	    public int getDuration() { return duration; }
}
