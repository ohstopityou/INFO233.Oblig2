package on.uib.info233.xeq003.oblig2;

import java.util.Arrays;

public class Bag<T> implements BagInterface<T>{
	
	private T[] bag;
	private int numbOfEntries = 0;
	private int maxSize;

	/**
	 * Creates an empty bag with specified capacity.
	 * @param capacity of bag
	 */
	@SuppressWarnings("unchecked")
	public Bag(int capacity){
		maxSize = capacity;
		//Cast is safe, contains null entries
		bag = (T[])new Object[maxSize];
	}
	
	/**
	 * @return Number of entries in bag
	 */
	public int getCurrentSize() {return numbOfEntries;}
	
	/**
	 * @return true if amount of entries in bag is 0
	 */
	public boolean isEmpty() {return numbOfEntries == 0;}
	
	/**
	 * checks if bag is full, if so, adds more space
	 * then adds entry to bag
	 */
	public boolean add(T newEntry){
		if (numbOfEntries == maxSize) {increaseSize();}
		bag[numbOfEntries] = newEntry;
		numbOfEntries++;
		return true;
	}
	
	/**
	 * Increases the size of the bag array by making a copy that has 5 more spaces
	 */
	private void increaseSize(){
		maxSize +=5;
		bag = Arrays.copyOf(bag, maxSize);
	}
	
	/**
	 * Removes a random entry from the bag
	 */
	public T remove(){
		int rnd = (int) Math.floor(Math.random() * numbOfEntries);
		T item = bag[rnd];
		bag[rnd] = null;
		return item;
	}
	
	/**
	 * Removes a specified object from the bag
	 * @return true if object is found, else returns false
	 */
	public boolean remove(T anEntry){
		int i = 0;
		while (i < maxSize) {
			if (bag[i] == anEntry)
			{
				bag[i] = null;
				bag[numbOfEntries] = bag[i];
				numbOfEntries--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * clears the current bag by creating a new bag
	 */
	@SuppressWarnings("unchecked")
	public void clear(){
		//Cast is safe, contains null entries
		bag = (T[])new Object[maxSize];
	}
	
	/**
	 * Loops over the bag and stops when it has found the object
	 * @return true if object is found, else returns false
	 */
	public boolean contains(T anEntry){
		for (int i = 0; i < numbOfEntries; i++) {
			if (bag[i] == anEntry){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Loops over the bag and counts how many times the object appears
	 * @return amount of times the object is found in bag
	 */
	public int getFrequencyOf(T anEntry){
		int frequency = 0;
		for (int i = 0; i < numbOfEntries; i++) {
			if (bag[i] == anEntry) {frequency++;}
		}
		return frequency;
	}
	
	/**
	 * Creates a new array by looping over the current bag and creating a copy
	 * @return copy of bag
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray(){
		//Cast is safe, contains null entries
		T[] newbag = (T[])new Object[maxSize];
		for (int i = 0; i < numbOfEntries; i++){
			newbag[i] = bag[i];
		}
		return newbag;
	}
	
}
