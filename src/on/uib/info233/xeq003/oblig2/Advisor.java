package on.uib.info233.xeq003.oblig2;

import java.util.ArrayDeque;
import java.util.Random;

public class Advisor {
	private Bag<Lecture> lectures;
	private ArrayDeque<Lecture> schedule = new ArrayDeque<Lecture>();
	private final static int numbOfLectures = 10;
	private final static int firstLectureStart = 8;
	private final static int lastLectureEnd = 23;
	private final static int maxLectureLength = 1;
	private final static int weekLength = 1;
	String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	boolean debug = false;
	
	public Advisor ()
	{
		lectures = createLectures();
		makeSchedule(lectures);
		printSchedule();
	}
	
	public void printSchedule() {
		System.out.println("------------Schedule------------");
		while (!schedule.isEmpty()){System.out.println(schedule.remove());}
	}
	
	public ArrayDeque<Lecture> makeSchedule (Bag<Lecture> bag)
	{
		Object[] bagArray = bag.toArray();					//create an array from bag
		for (int i = 0; i < weekLength; i++) { 				//do for every day in week
			
			String today=days[i];
			int previousLectureEndHour = 8;			
			int tempLectureEndHour;			
			
			boolean addMoreLectures = true;
			while (addMoreLectures){
				Lecture tempLecture = null;
				tempLectureEndHour = lastLectureEnd;
				for (int j = 0; j < bagArray.length; j++) { 	//do until all lectures have been checked
					Lecture currentLecture = (Lecture) bagArray[j];
					debug("\nProcessing " + currentLecture + " : ");
					if ((currentLecture.getStartTime().getDay() == today) && 
						(currentLecture.getStartTime().getHour()) >= previousLectureEndHour){
						try{
							if (currentLecture.compareTo(tempLecture) == 1){ //compares end hour
							tempLecture = currentLecture;		//sets new tempLecture
							debug("set as new temp");	
							tempLectureEndHour = tempLecture.getEndTime().getHour();
						}} catch (NullPointerException e){ // first lecture checked this day which is allowed
							tempLecture = currentLecture;
						}
					}
				}
				if (tempLecture == null){			
					addMoreLectures = false;
					debug("\nNo more lectures found for " + today);
					debug("\n-----------------------------");
				} else {
					schedule.push(tempLecture);	//add lecture to schedule
					debug("\n" + tempLecture + " : added to schedule");
					debug("\n-----------------------------");
					previousLectureEndHour = tempLecture.getEndTime().getHour();
				}
			}//while end
		}
		schedule = reverseDeque(schedule);
		return schedule;
	}
	
	//yes iknow this is not efficient
	public ArrayDeque reverseDeque(ArrayDeque reverseMe) {
		ArrayDeque<Lecture> reversed = new ArrayDeque<Lecture>();
		while (!reverseMe.isEmpty()){
			reversed.push(schedule.remove());
		}
		return reversed;
	}
	
	public static void main(String[] args) {
		Advisor test = new Advisor();
	}

	public Bag<Lecture> createLectures() {
		Bag<Lecture> bag = new Bag<Lecture>();
		for (int i = 0; i < numbOfLectures; i++) {
			Lecture randomLecture = createRandomLecture(i);
			bag.add(randomLecture);
		}
		return bag;
	}
	
	private Lecture createRandomLecture(int classNumber)
	{
		String className = "INFO" + classNumber;
		String day = days[newRandom(0,weekLength -1)];
		int hour = newRandom(firstLectureStart,lastLectureEnd - maxLectureLength);
		int length = newRandom(1, maxLectureLength);
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