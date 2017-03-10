package on.uib.info233.xeq003.oblig2;

public class Lecture {
	private LectureTime startTime, endTime;
	private String lectureName;
	
	public Lecture (String name, String day, int hour, int length) {
		lectureName = name;
		//LectureTime (String day, int hour, int minute) 
		startTime = new LectureTime(day, hour, 15);
		endTime = new LectureTime(day, hour + length, 00);
		//lastLectureStart (20:00)
	}
	
	public LectureTime getStartTime() {
		return startTime;
	}
	
	public LectureTime getEndTime() {
		return endTime;
	}
	
	public String getLectureName(){
		return lectureName;
	}
	
	@Override
	public String toString() {
		String info = 	"Name: " + lectureName + 
						", Day: " + startTime.getDay() + 
						", sHour: " + startTime.getHour() +
						", eHour: " + endTime.getHour();
		return info;
	}
}
