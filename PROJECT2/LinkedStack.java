package cs2400;

import java.util.EmptyStackException;
//numberOfEntries conflicts with my method to show stack as it doubles, must divide by 2
public class LinkedStack<T> implements LinkedStackInterface<T>{
	private Node topNode;
	private int numberOfEntries;
	
	public LinkedStack() {
	topNode = null;
	}
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		numberOfEntries++;
	}
	public int getCurrentSize() {
		return numberOfEntries;
	}
	public T pop() {
		T top = peek();
		topNode = topNode.getNextNode();
		numberOfEntries--;
		return top;
	}
	
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
	
	public void clear() {
		topNode = null;
	}
	/** Retrieves all entries that are in this bag
	 *  @return A newly allocated array of all the entries in this bag */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //unchecked cast
		
		int index = 0;
		Node currentNode = topNode;
		while((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		}
		return result;
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
}
