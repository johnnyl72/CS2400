//package cs2400;

public class LinkedBag<T> implements LinkedBagInterface<T> {
	private Node firstNode; // reference to first node
	private int numberOfEntries;
	
	public LinkedBag() {
		firstNode = null; 
		numberOfEntries = 0;
	}//end of default constructor
	
	/** Adds a new entry to this bag. 
	 *  @param newEntry The object to be added as a new entry 
	 *	@return True if the addition is successful, or false if not. */
	public boolean add(T newEntry) {
		// adds to beginning of the chain
		Node newNode = new Node(newEntry);
		newNode.next= firstNode; // makes a new node reference for the rest of the chain
		firstNode = newNode; //the new node is now the beginning of the chain
		numberOfEntries++;
		return true;
	}
	/** Removes one unspecified entry from this bag, if possible. 
	  *	@return Either the removed entry, if the removal was successful, or null.*/
	public T remove() {
		T result = null;
		if(firstNode != null){
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); //removes first node from the chain by skipping over it
			numberOfEntries--;
		}
		return result;
	}
	/** Removes one occurrence of a given entry from this bag, if possible. 
	 *  @param anEntry The entry to be removed. 
	 *  @return True if the removal was successful, or false otherwise. */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		
		if(nodeN != null) {
			//replace located entry with entry in the first node
			nodeN.setData(firstNode.getData());
			//then removes first node in the linked set
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
			result = true;
		}
		return result;
	}
	/** Sees whether this bag is empty.  
	 *  @return True if the bag is empty, or false otherwise. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	/** Retrieves the number of entries currently in the bag.  
	 *  @return Tthe integer number of entries currently in the bag */
	public int getCurrentSize() {
		return numberOfEntries;
	}
	//remove all entries from this bag
	public void clear() {
		while(!isEmpty()) 
			remove();
	}
	/** Counts the number of times a given entry appears in this bag
	 *  @param anEntry the entry to be counted
	 *  @return The number of times anEntry apepars in the bag */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int counter = 0;
		Node currentNode = firstNode;
		while((counter < numberOfEntries) && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData())) {frequency++;}
			
			counter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}
	/** Tests whether this bag contains a given entry
	 *  @param anEntry the entry to be located
	 *  @return True if this bag contains anEntry, or false otherwise */
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}
	/** Retrieves all entries that are in this bag
	 *  @return A newly allocated array of all the entries in this bag */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //unchecked cast
		
		int index = 0;
		Node currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		}
		return result;
	}
	/** Locates a given entry within this bag and returns a reference to the node 
	 *  containing the entry, returns null if it isn't located
	 */
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found=true;
			else
				currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}
	
	//private inner class Node, does not require <T> because it will be the same type as declared in outer class
	private class Node{
		private T data; //entry in bag
		private Node next; //link to next node
		
		private Node(T dataPortion) {
			this(dataPortion,null);
		}
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		private T getData() {
			return data;
		}
		private void setData(T newData) {
			data = newData;
		}
		private Node getNextNode() {
			return next;
		}
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}//end Node
	
}//end of LinkedBag
