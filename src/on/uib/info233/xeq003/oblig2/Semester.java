package on.uib.info233.xeq003.oblig2;

import java.util.Random;

public class Semester {
	
	private int numbOfLectures = 10;
	private int firstLectureStart = 8;
	private int lastLectureEnd = 23;
	private int maxLectureLength = 3;
	private  int weekLength = 7;
	private Bag<Lecture> lectures;
	
	public Semester(int numbOfLectures) {
		this.numbOfLectures = numbOfLectures;
		createLectures();
	}
	
	public Bag<Lecture> getLectures()
	{
		return lectures;
	}
	
	private void createLectures() {
		lectures = new Bag<Lecture>();
		for (int i = 0; i < numbOfLectures; i++) {
			Lecture randomLecture = createRandomLecture(i);
			lectures.add(randomLecture);
		}
	}
	
	private Lecture createRandomLecture(int classNumber)
	{
		String className = "INFO" + classNumber;
		int day = newRandom(1, weekLength);
		int hour = newRandom(firstLectureStart,lastLectureEnd - maxLectureLength);
		int length = newRandom(1, maxLectureLength);
		Lecture lecture = new Lecture(className, day, hour, length);
		return lecture;
	}
	
    private int newRandom(int min, int max) //including
    {
        return new Random().nextInt(max - min + 1) + min;
    }
}
