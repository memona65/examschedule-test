package exam.scheduling;

public class ExamHall implements Comparable<ExamHall> {
	 private String name;
	    private int capacity;
	    public ExamHall(String name, int capacity) { this.name = name; this.capacity = capacity; }
	    public String getName() { return name; }
	    public int getCapacity() { return capacity; }
	    public void setName(String n) { name = n; }
	    public void setCapacity(int c) { capacity = c; }
	    @Override public int compareTo(ExamHall other) { return Integer.compare(other.capacity, this.capacity); }
	    @Override public String toString() { return name + " (" + capacity + ")"; }
}
