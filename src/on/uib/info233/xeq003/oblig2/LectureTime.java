package on.uib.info233.xeq003.oblig2;

public class LectureTime {
	private String day;
	private int hour, minute;

	public LectureTime (String day, int hour, int minute) 
	{
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public String getDay(){
		return day;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}
}
