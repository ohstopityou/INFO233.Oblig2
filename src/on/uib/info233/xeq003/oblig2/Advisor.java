package on.uib.info233.xeq003.oblig2;

import java.util.ArrayDeque;

public class Advisor {
	private Bag<Lecture> lectures;
	private ArrayDeque<Lecture> deque;

	public Bag<Lecture> makeSchedule () {
		deque = new ArrayDeque<Lecture>();
		deque.add(new Lecture("INFO233", "Mon", 8, 15));
		return getAllLectures();
	}

	private Bag<Lecture> getAllLectures() {
		lectures = new Bag<Lecture>();
		lectures.add(new Lecture("INFO233", "Mon", 8, 15));
		lectures.add(new Lecture("INFO234", "Mon", 9, 15));
		lectures.add(new Lecture("INFO239", "Mon", 9, 15));
		lectures.add(new Lecture("INFO234", "Tue", 9, 15));
		lectures.add(new Lecture("INFO235", "Thu", 8, 15));
		lectures.add(new Lecture("INFO236", "Thu", 9, 15));
		return lectures;
	}
}