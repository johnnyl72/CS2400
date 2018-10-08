package cs2400;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements VectorStackInterface<T>{
	private Vector<T> stack;   // Last element is the top entry in stack 
	private boolean integrityOK; 
	private static final int DEFAULT_CAPACITY = 50; 
	private static final int MAX_CAPACITY = 10000;
	private int numberOfEntries;
	public VectorStack() { 
		this(DEFAULT_CAPACITY); 
	} // end default constructor
	
	public VectorStack(int initialCapacity) { 
		integrityOK = false; 
		checkCapacity(initialCapacity); 
		stack = new Vector<>(initialCapacity); // Size doubles as needed 
		integrityOK = true; 
	} // end constructor
	public boolean isFull() {
		return numberOfEntries == stack.size();
	}
	public void push(T newEntry) { 
		checkIntegrity(); 
		stack.add(newEntry); 
	} // end push
	public T pop() { 
		checkIntegrity(); 
		if (isEmpty()) 
			throw new EmptyStackException(); 
		else 
			return stack.remove(stack.size() - 1); 
	} // end pop
	public T peek() { 
		checkIntegrity(); 
		if (isEmpty()) 
			throw new EmptyStackException(); 
		else 
			return stack.lastElement(); 
	} // end peek
	public boolean isEmpty() { 
		checkIntegrity(); 
		return stack.isEmpty(); 
	} // end isEmpty
	public void clear() { 
		checkIntegrity(); 
		stack.clear(); 
	} // end clear
	// throws an exception if this object isn't initialized
	private void checkIntegrity() {
		if(!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt");
		}
	/* throws an exception if the cilent requests a capacity
	 * bigger than the MAX_CAPACITY*/
	private void checkCapacity(int capacity){
		if(capacity > MAX_CAPACITY)
			System.out.println("You have added more items in the bag bigger than"
					+ " the exceeded maximum of " + MAX_CAPACITY + ".\n"
							+ "Will now double the size of stack to: " + capacity);
	}
}
