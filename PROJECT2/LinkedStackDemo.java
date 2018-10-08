package cs2400;

import java.util.Scanner;

public class LinkedStackDemo {
	public static void main(String[] args) {
	 System.out.println("Creating an empty stack.");
	 LinkedStackInterface<String> stack = new LinkedStack<>();
	  show(stack);
	  testIsEmpty(stack);
	  System.out.println("Now adding books onto table...");
	  String[] contentsOfStack = {"Book A", "Book B", "Book C", "Book D", "Book E", "Book F", "Book G"};
	  add(stack, contentsOfStack);
	  show(stack);
	  System.out.println("The size of the stack is " + stack.getCurrentSize());
	  boolean valid = true; //boolean flag for input validation
	  Scanner kb= new Scanner(System.in);
		 do {
			 System.out.print("What book would you like at? ");
	    			if(!kb.hasNextInt()) {
	    				System.out.println("Invalid reponse!");
	    				kb.next();
	    				valid = false;
	    			}
	    			else { 
	    				int input = kb.nextInt();
	    			
	    				if((input <= 0 ) || (input > stack.getCurrentSize())) {
	    					System.out.println("Please enter between 1 through " + stack.getCurrentSize());
	    					valid = false;
	    					continue;
	    				}
	    				else 
	    				search(input,stack);
	    				valid = true;
	    			}
	    }while(!valid);
	
	show(stack);
	System.out.println("Removing a book.......");
	stack.pop();
	show(stack);
	String[] moreBooks = {"Book 1", "Book 2","Book 3", "Book 4"};
	addingMore(stack,moreBooks);
	show(stack);
	}//end of main
	
	private static void addingMore(LinkedStackInterface<String> stack, String[] books){
		System.out.print("Stacking more books onto table.....");
		for(int index = 0; index < books.length; index++) {
			stack.push(books[index]);
			System.out.print("\nNew book added: ");
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	private static void search(int desired, LinkedStackInterface<String> stack) {
		LinkedStackInterface<String> booksOnTableCopy = new LinkedStack<>();	
		System.out.println("Checking book at position " + desired);
		while(!stack.isEmpty()) {
			int index = stack.getCurrentSize();
			String tempString = stack.peek();
			if(index == desired )
				System.out.println("Book is " + stack.peek());
			booksOnTableCopy.push(tempString);
			stack.pop();
			index--;
		}
	    System.out.println("\n---------------------------------");
	  //adding the stacks back onto the original stack
		while(!booksOnTableCopy.isEmpty()) {
			String originalString = booksOnTableCopy.peek();
			stack.push(originalString);
			booksOnTableCopy.pop();
		}
	}
	private static void add(LinkedStackInterface<String> stack, String[] contentsOfStack) {
		System.out.println("(Please note: First entry is the bottom book)");
		for(int index = 0; index < contentsOfStack.length; index++) {
			stack.push(contentsOfStack[index]);
			System.out.print(contentsOfStack[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	private static void show(LinkedStackInterface<String> stack) {
		
		System.out.println("The stack contains the following " +stack.getCurrentSize() + " books stacked visually"
						+ "\n(the output is displayed visually with the top book \nbeing the top of the stack)  \nas follows: ");		
		LinkedStackInterface<String> booksOnTableCopy = new LinkedStack<>();		
		while(!stack.isEmpty()) {
			String tempString = stack.peek();
			System.out.println(stack.peek() + " ");
			booksOnTableCopy.push(tempString);
			stack.pop();
		}
		//adding the stacks back onto the original stack
		while(!booksOnTableCopy.isEmpty()) {
			String originalString = booksOnTableCopy.peek();
			stack.push(originalString);
			booksOnTableCopy.pop();
		}
		System.out.println();
	} // end show
	private static void testIsEmpty(LinkedStackInterface<String> stack) {
		 System.out.print("The table currently has ");
	      if (stack.isEmpty())
				System.out.print("no books on it.");
	      else
				System.out.print("books on it.");      
			System.out.println();
	}
}
