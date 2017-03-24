package on.uib.info233.xeq003.oblig2;

import static org.junit.Assert.*;

import java.util.ArrayDeque;

import org.junit.Test;

public class Tester {

	@Test
	public void scheduleTest() {
		int totalLectures = 10;
		Semester semester = new Semester(totalLectures);
		Bag<Lecture> bag = semester.getLectures();
		
		//checks if bag (which semester created) contains 25 lectures
		assertTrue(bag.getCurrentSize() == totalLectures);
		ArrayDeque<Lecture> deque = new Advisor().makeSchedule(bag);
		
		System.out.println("----Scheduled " + deque.size() + " of " + totalLectures + " lectures ----");
		while (!deque.isEmpty()){
			System.out.println(deque.remove());
		}
		
		//checks if removed all items
		assertTrue(deque.size() == 0);
	}
	
	@Test
	public void lectureCompareTest() {
		Lecture lecture8 = new Lecture("8am", 1, 8, 1);
		Lecture lecture9 = new Lecture("9am", 1, 9, 1);
		int compareValue = lecture8.compareTo(lecture9);
		//8 ends after 9
		assertEquals(compareValue, -1);
	}
	
	@Test
	public void DateCompareTest() {
		//checks if date compare works correctly by creating to LectureTime elements and getting their date
		assertTrue(new LectureTime(1, 8, 0).getDate().before(new LectureTime(1, 9, 0).getDate()));
	}
}