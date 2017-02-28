package on.uib.info233.xeq003.oblig2;

public class Lecture {
	private LectureTime time;
	private String lectureName;
	
	public Lecture (String name, String day, int hour, int minute) {
		lectureName = name;
		time = new LectureTime(day, hour, minute);
	}
	
	public LectureTime getStartTime() {
		return time;
	}
	
	public LectureTime getEndTime() {
		return time;
	}
	
	public String getLectureName(){
		return lectureName;
	}
}
