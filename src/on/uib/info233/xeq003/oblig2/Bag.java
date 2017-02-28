package on.uib.info233.xeq003.oblig2;

public class Bag<T> implements BagInterface<T>
{	
	private Node firstNode;
	private int numbOfEntries;
	//lastNode.next = null

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
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;	//link new node to first in chain
		firstNode = newNode;		//make newnode chain´s beginning							
		numbOfEntries++;
		return true;
	}
	
	/**
	 * Removes the first entry from bag
	 */
	public T remove()
	{
		T item = firstNode.data;
		firstNode = firstNode.next;
		return item;				//returns null if bag is empty
	}
	
	/**
	 * Removes a specified object from the bag
	 * @return true if object is found, else returns false
	 */
	public boolean remove(T anEntry)
	{
		Node current = firstNode;
		Node previous = null;
		while (current != null)					//checks current node
		{
			if (current.data == anEntry){ 		//current == object found
				if (previous == null){			//object is first in chain
					this.firstNode = current.next;	//sets next node as firstNode
				} else {
					previous.next = current.next; 	//sets previous node.next to next node
				}
				numbOfEntries--;
				return true;
			} else {
				previous = current;				//sets current as previous node
				current = current.next;			//goes to next node
			}
		} 
		return false;
	}
	
	/**
	 * clears the current bag by creating a new bag
	 */
	public void clear(){
		firstNode = null;
		numbOfEntries = 0;
	}
	
	/**
	 * Loops over the bag and stops when it has found the object
	 * @return true if object is found, else returns false
	 */
	public boolean contains(T anEntry)
	{
		Node current = firstNode;
		while (current != null) {				//checks current node
			if (current.data == anEntry){
				return true;
			} else {
				current = current.next;			//goes to next node
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
		Node current = firstNode;
		int frequency = 0;
		while (current != null) {				//checks current node
			if (current.data == anEntry){
				frequency++;					//adds 1 to frequency
			} else {
				current = current.next;			//goes to next node
			}
		}
		return frequency;
	}
	
	/**
	 * Creates a new array by looping over the current bag and creating a copy
	 * @return copy of bag
	 */
	public T[] toArray()
	{
		//the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[numbOfEntries]; //Unchecked cast
		int index = 0;
		Node current = firstNode;
		while (current != null) {
			array[index] = current.data;
			index++;
			current = current.next;
		}
		return array;
	}	
	
	private class Node
	{
		private T		data;
		private Node	next;
		
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}// end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		}// end constructor
	}// end node
}