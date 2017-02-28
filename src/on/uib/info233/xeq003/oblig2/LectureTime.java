package on.uib.info233.xeq003.oblig2;

import java.util.Arrays;

public class LectureTime {
	private String day;
	private String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	private int hour, minute;

	public LectureTime (String day, int hour, int minute) {
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		if (minute > 59 || minute < 0){
			//invalid
		}
		if (hour > 23 || hour < 0){
			//invalid
		}
		if (Arrays.asList(days).contains(day)) {
			//invalid
		}
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
