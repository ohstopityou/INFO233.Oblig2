package on.uib.info233.xeq003.oblig2;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Advisor {
	public ArrayDeque<Lecture> makeSchedule (Bag<Lecture> bag) {
		ArrayDeque<Lecture> schedule = new ArrayDeque<Lecture>();
		int bagSize = bag.getCurrentSize();
		Lecture[] lecArray = new Lecture[bagSize];
		
		//add lectures from bag to array
		for (int j = 0; j < bagSize; j++) {lecArray[j] = bag.remove();}
		Arrays.sort(lecArray); //by endTime, earliest first
		
		if (lecArray.length > 0) {schedule.add(lecArray[0]);}
		for (int i = 1; i < lecArray.length; i++) {
			LectureTime preLecEnd = schedule.peekLast().getEndTime();
			LectureTime newLecStart = lecArray[i].getStartTime();
			boolean sameDay = (preLecEnd.getDay().equals(newLecStart.getDay()));
			boolean validStartTime = (newLecStart.getHour() >= preLecEnd.getHour());
			//adds iterated lecture to schedule if valid startTime or new day
			if (!sameDay || validStartTime) { schedule.add(lecArray[i]); }
		} return schedule;
	}
}