package cs2400;
/**
 *  Notes for myself: tried making a numberOfEntries counter such as one in the bag
 *  data structure but however ends up with a wierd number, keeps track of total
 *  entries by locating the index of the top item in the stack
 */
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements ArrayStackInterface<T>{
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 5;
	private boolean integrityOK = false;
	public ArrayStack() { 
		this(DEFAULT_CAPACITY); 
	} // end default constructor
	
	public ArrayStack(int initialCapacity) { 
		integrityOK = false; 
	//	checkCapacity(initialCapacity);
		// The cast is safe because the new array contains null entries 
		@SuppressWarnings("unchecked") T[] tempStack = (T[])new Object[initialCapacity]; 
		stack = tempStack; 
		topIndex = -1; 
		integrityOK = true; 
	} // end constructor
	public int getCurrentSize() {
		//obtains the current size of the stack by locating the index of the top index 
		return topIndex + 1;
	}
	public void push(T newEntry) { 
		checkIntegrity(); 
		ensureCapacity(); 
		//note top index is -1
		stack[topIndex + 1] = newEntry; 
		topIndex++; 
	} // end push
	
	public T pop() { 
		checkIntegrity(); 
		if (isEmpty()) { 
			throw new EmptyStackException();
		}
		else { 
			T top = stack[topIndex]; 
			stack[topIndex] = null; 
			topIndex--; 
			return top; 
		} // end if 
	} // end pop
	public T peek() { 
		checkIntegrity(); 
		if (isEmpty()) 
			throw new EmptyStackException(); 
		else return 
			stack[topIndex]; 
		} // end peek
	public boolean isEmpty() { 
		return topIndex < 0; 
	} // end isEmpty
	public void clear() { 
		checkIntegrity();
		
		// Remove references to the objects in the stack, 
		// but do not deallocate the array 
		while (topIndex > -1) { 
			stack[topIndex] = null; 
			topIndex--; 
		} // end while 
		//Assertion: topIndex is -1 
	} // end clear
	public boolean isFull() {
		return topIndex + 1 == stack.length;
	}
	public int getLength() {
		return stack.length;
	}
	private void ensureCapacity() { 
		if (topIndex >= stack.length - 1) // If array is full, double its size 
			{ int newLength = 2 * stack.length; 
		//	checkCapacity(newLength); 
			stack = Arrays.copyOf(stack, newLength); 
			} // end if 
	} // end ensureCapacity
	/* throws an exception if the cilent requests a capacity
	 * bigger than the MAX_CAPACITY*/
	/*
	private void checkCapacity(int capacity){
		if(capacity > MAX_CAPACITY)
			System.out.println("You have added more items in the bag bigger than"
					+ " the exceeded maximum of " + MAX_CAPACITY + ".\n"
							+ "Will now double the size of array to: " + stack.length * 2);
	}
	*/
	// throws an exception if this object isn't initialized
	private void checkIntegrity() {
		if(!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt");
		}

	public int maxLength() {
		return stack.length;
	}
}
