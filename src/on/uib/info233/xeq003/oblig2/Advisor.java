package on.uib.info233.xeq003.oblig2;

import java.util.ArrayDeque;
import java.util.Random;

public class Advisor {
	private Bag<Lecture> lectures;
	private ArrayDeque<Lecture> deque = new ArrayDeque<Lecture>();
	private Lecture[] bagArray = new Lecture[15];
	private final static int numbOfLectures = 15;
	private final static int firstLectureStart = 8;
	private final static int lastLectureEnd = 23;
	private final static int  maxLectureLength = 3;
	String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	boolean debug = false;
	
	public Advisor () 
	{
		getAllLectures();
		System.out.println("------------Schedule------------");
		livMakeSchedule(lectures);
		while (!deque.isEmpty()){
			System.out.println(deque.remove());
		}
	}
	
	public void livMakeSchedule (Bag<Lecture> bag)
	{
		//Lecture[] bagArray = bag.toArray();		//create an array from bag
		for (int i = 0; i < 7; i++) { 				//do for every day in week
			
			String today=days[i];
			int previousLectureEndHour = 8;			
			int tempLectureEndHour;			

			boolean addMoreLectures = true;
			while (addMoreLectures){
				Lecture tempLecture = null;
				tempLectureEndHour = lastLectureEnd;
				//loops to find the best lecture for this hour
				for (int j = 0; j < bagArray.length; j++) { //do until all lectures have been checked
					debug("\nProcessing " + bagArray[j] + " : ");
					if(betterLecture(bagArray[j], today, previousLectureEndHour, tempLectureEndHour)){
						tempLecture = bagArray[j];		//sets new tempLecture
						debug("set as new temp");	
						tempLectureEndHour = tempLecture.getEndTime().getHour();
					}
				}
				
				if (tempLecture == null){			
					addMoreLectures = false;
				} else {
					deque.push(tempLecture);	//add lecture to schedule
					debug("\n" + tempLecture + " : added to deque");
					debug("\n-----------------------------");
					previousLectureEndHour = tempLecture.getEndTime().getHour();
				}
			}//while end
		}
	}
	
	//returns true if lecture ends earlier than maxEndHour, while day and startHour is valid
	private boolean betterLecture(Lecture lecture, String startDay, int minStartHour, int maxEndHour)
	{
		
		String tryLectureDay 	= lecture.getStartTime().getDay();
		int tryLectureStartHour = lecture.getStartTime().getHour();
		int tryLectureEndHour 	= lecture.getEndTime().getHour();
		
		//System.out.println("minStartHour = " + minStartHour + " tryLectureEndHour = " + tryLectureEndHour);
		
		if (tryLectureDay 		== startDay			&&
			tryLectureEndHour 	<= maxEndHour 		&&
			tryLectureStartHour >= minStartHour) 
			{return true;}
		else return false;
	}
	
	public static void main(String[] args) {
		Advisor test = new Advisor();
	}

	public ArrayDeque<Lecture> makeSchedule (Bag<Lecture> bag) {
		return deque;
	}

	private void getAllLectures() {
		lectures = new Bag<Lecture>();
		for (int i = 0; i < numbOfLectures; i++) {
			Lecture randomLecture = createRandomLecture(i);
			lectures.add(randomLecture);
			//deque.add(randomLecture);
			bagArray[i] = randomLecture;
		}
	}
	
	private Lecture createRandomLecture(int classNumber)
	{
		String className = "INFO" + classNumber;
		String day = days[newRandom(0,6)];			//the day the lecture starts
		int hour = newRandom(firstLectureStart,lastLectureEnd - maxLectureLength);	//starthour
		int length = newRandom(1, maxLectureLength);				//lectureLength(hours)
		Lecture lecture = new Lecture(className, day, hour, length);
		return lecture;
	}
	
    public int newRandom(int min, int max) //including
    {
        return new Random().nextInt(max - min + 1) + min;
    } 
    
    public void debug(String s){
    	if (debug){
    		System.out.print(s); // \n = new line
    	}
    }
}