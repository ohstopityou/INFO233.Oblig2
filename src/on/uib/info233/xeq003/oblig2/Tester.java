package on.uib.info233.xeq003.oblig2;

import static org.junit.Assert.*;

import java.util.ArrayDeque;

import org.junit.Test;

public class Tester {

	private Bag<String> bag = new Bag<String>();
	private Advisor advisor = new Advisor();

	@Test
	public void test() { //change day weekLength to 1 in advisor to test
		ArrayDeque<Lecture> deque = (ArrayDeque<Lecture>) advisor.makeSchedule(advisor.createLectures());
		System.out.println(deque.remove());

		Lecture previous = (Lecture) deque.remove();
		System.out.println("1 = before, -1 = after");
		String previousLectureDay = previous.getStartTime().getDay();
		
		while (!deque.isEmpty()){
			Lecture lecture = (Lecture) deque.remove();
			if (lecture.getStartTime().getDay() != previousLectureDay){
				//day rollover
			}
			int status = previous.compareTo(lecture); //checks if previous lecture ends before lecture
			System.out.print(previous + " ends (status: "+status+") " + lecture + "\n");
			assertEquals(1, status);
			previous = lecture;
		}
	}
}