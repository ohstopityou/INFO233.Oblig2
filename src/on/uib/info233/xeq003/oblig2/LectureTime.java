package on.uib.info233.xeq003.oblig2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class LectureTime {
	private Date date;
	
	public LectureTime (int day, int hour, int minute) 
	{
		this.date = new Date(117, 0, day +1, hour, minute);
	}
	
	public String getDay() {
		return new SimpleDateFormat("E").format(date);
	}
	
	public int getHour() {return date.getHours();}
	
	public int getMinute() {return date.getMinutes();}
	
	public Date getDate() {return date;}
	
	@Override
	public String toString() {
		return new SimpleDateFormat("HH:mm").format(date);
	}
}
