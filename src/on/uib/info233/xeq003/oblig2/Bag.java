package on.uib.info233.xeq003.oblig2;

import java.util.Arrays;

public class Bag<T> implements BagInterface<T>
{	
	private Node<T> firstNode;
	private int numbOfEntries;

	/**
	 * Creates an empty bag with specified capacity.
	 * @param capacity of bag
	 */
	public Bag(){
		firstNode = null;
		numbOfEntries = 0;
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
	public boolean add(T newEntry)
	{	
		Node<T> newNode = new Node<>(newEntry);
		newNode.setNextNode(firstNode);		//link new node to first in chain
		firstNode = newNode;				//make newnode chain´s beginning							
		numbOfEntries++;
		return true;
	}
	
	/**
	 * Removes the first entry from bag
	 */
	public T remove()
	{
		T item = firstNode.getData(); //try nullPointerException
		firstNode = firstNode.getNextNode();
		numbOfEntries--;
		return item;				//returns null if bag is empty
	}
	
	/**
	 * Removes a specified object from the bag
	 * @return true if object is found, else returns false
	 */
	public boolean remove(T anEntry)
	{
		Node<T> current = firstNode;
		Node<T> previous = null;
		while (current != null)						//checks current node
		{
			if (current.getData() == anEntry) { 	//current == object found
				if (previous == null){				//object is first in chain
					firstNode = firstNode.getNextNode();	//sets second node as firstNode
				} else {
					previous.setNextNode(current.getNextNode());	//is null if last in chain
				}
				numbOfEntries--;
				return true;
			} else {
				previous = current;					//sets current as previous node
				current = current.getNextNode();	//goes to next node
			}
		} 
		return false;								//false when current node is null
	}
	
	/**
	 * clears the current bag by creating a new bag
	 */
	public void clear()
	{
		firstNode = null;
		numbOfEntries = 0;
	}
	
	/**
	 * Loops over the bag and stops when it has found the object
	 * @return true if object is found, else returns false
	 */
	public boolean contains(T anEntry)
	{
		Node<T> current = firstNode;
		while (current != null) {					//checks current node
			if (current.getData() == anEntry){
				return true;
			} else {
				current = current.getNextNode();	//goes to next node
			}
		}
		return false;
	}
	
	/**
	 * Loops over the bag and counts how many times the object appears
	 * @return amount of times the object is found in bag
	 */
	public int getFrequencyOf(T anEntry)
	{
		Node<T> current = firstNode;
		int frequency = 0;
		while (current != null) {					//checks current node
			if (current.getData() == anEntry){
				frequency++;						//adds 1 to frequency
			} else {
				current = current.getNextNode();	//goes to next node
			}
		}
		return frequency;
	}
	
	/**
	 * Creates a new array by looping over the current bag and creating a copy
	 * @return copy of bag
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return T[] t = new (T[]) Object T[];
	}
}