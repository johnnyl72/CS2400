package cs2400;

public interface ArrayStackInterface<T> {
	/** Adds a new entry to the top of this stack. 
	  	@param newEntry An object to be added to the stack. */ 
	public void push(T newEntry);
	/** Removes and returns this stack's top entry. 
	 	@return The object at the top of tShe stack. 
	 	@throws EmptyStackException if the stack is empty before the operation. */ 
	public T pop();
	/** Retrieves this stack's top entry. 
	 	@return The object at the top of the stack. 
	 	@throws EmptyStackException if the stack is empty. */ 
	public T peek();
	/** Detects whether this stack is empty. 
	 	@return True if the stack is empty. */ 
	public boolean isEmpty();
	/** Removes all entries from this stack. */ 
	public void clear();
	// Tests if the stack is full
	public boolean isFull();
	// Returns the length of the stack before having to double it
	public int maxLength();
	/* Returns the total amount of entries in the 
	   stack by locating the top most entry's index */
	public int getCurrentSize();
}// end of StackInterface

