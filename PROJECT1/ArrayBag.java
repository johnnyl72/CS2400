//package cs2400;

/** A class of bags whose entries are in a 
 *  fixed-sized array.
 */
public class ArrayBag<T> implements BagInterface<T>{
	
	private final T[] bag;
	private static final int DEFAULT_CAPACITY = 5;
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 5;
	
	//creates an empty bag with intial capacity of 5
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	/* creates an empty bag with a given initial capacity
	@param capacity the integer capacity desired*/
	public ArrayBag(int capacity) {
		if(capacity <= MAX_CAPACITY) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
		numberOfEntries = 0;
		integrityOK = true;
		}
		else
			throw new IllegalStateException("Bag created exceeds allowed limit");
	} 
	// throws an exception if this object isn't initialized
	private void checkIntegrity() {
		if(!integrityOK)
			throw new SecurityException("ArrayBag objet is corrupt");
		}
	/* locates a given entry inside the array ag
	 * returns the index of the entry or -1 if not located*/
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while(!found && (index < numberOfEntries)) {
			if(anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
				index++;
		}
		return where;
	}
	/* removes and returns the entry at a given index within the array bag
	 * if desired entry does not exists, return null */
	private T removeEntry(int givenIndex) {
		T result = null;
		if(!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex]; //entry to remove
			bag[givenIndex] = bag[numberOfEntries -1]; //replace entry with last entry
			bag[numberOfEntries - 1] = null; //remove lsat entry
			numberOfEntries--;
		}
		return result;
	}
	/* gets the current number of entries in this bag
	 * @return the integer number of entries currently in this bag*/
	public int getCurrentSize() {
		return numberOfEntries;
	}
	/* determines whether this bag is full
	 * @return if the bag is full, or false if not*/
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}
	/* determines whether this bag is empty
	 * @return if the bag is empty, or false if not*/
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	/* adds a new entry into this bag
	 * @param newEntry object to be added as a new entr*/
	public boolean add(T newEntry) {
		checkIntegrity();
		boolean result = true;
		if (isFull()) {
			result = false;
		}
		else {
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		}
		return result;
	}
	/* removes a random entry from this bag, if possible
	 * @return either the removed entry, if the remove was successful,
	 * or null otherwise*/
	public T remove() {
		checkIntegrity();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}
	/* removes one occurence of a given entry from this bag
	 * @param anEntry the entry to be removed
	 * @return true if the removal was successful, or false if it wasn't*/
	public boolean remove(T anEntry) {
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}
	//removes all entries from this bag
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	/* counts the number of times a given entry is in the bag
	 * @parma anEntry the entry to be counted
	 * @return the number of times anEntry appears in this bag*/
	public int getFrequency(T anEntry) {
		checkIntegrity();
		int counter = 0;
		
		for(int index =0; index < numberOfEntries; index++) {
			if(anEntry.equals(bag[index])) {
				counter++;
			}
		}//end of for
		return counter;
	}
	/* tests whether this bag contains a given entry
	 * @param anEntry the entry to be located
	 * @return true if this bag contains anEntry, or otherwise false*/
	public boolean contains(T anEntry) {
		checkIntegrity();
		return getIndexOf(anEntry) > -1;
	}
	/* gathers all entries that are in this bag
	 * @return a newly allocated array of all the entries in the bag*/
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
		}
}
	
