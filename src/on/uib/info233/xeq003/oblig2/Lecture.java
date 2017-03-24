package on.uib.info233.xeq003.oblig2;

import java.util.Date;

public class Lecture implements Comparable<Lecture>{
	private LectureTime startTime, endTime;
	private String lectureName;
	
	public Lecture (String name, int day, int hour, int length) {
		lectureName = name;
		startTime = new LectureTime(day, hour, 15);
		endTime = new LectureTime(day, hour + length, 00);
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
						", startHour: " + startTime +
						", endHour: " + endTime;
		return info;
	}
	
	//compareTo : return 1 if this is larger than other
	public int compareTo(Lecture other)
	{
		Date thisDate = this.endTime.getDate();
		Date otherDate = other.getEndTime().getDate();
		if (thisDate.after(otherDate)){
			return 1;
		} return -1;
	}
}
