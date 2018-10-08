package cs2400;

public class ArrayStackDemo {
	public static void main(String[] args) {
		System.out.println("Creating an empty stack(table).");
		ArrayStackInterface<String> booksOnTable = new ArrayStack<>();
		testIsEmpty(booksOnTable);
		String[] books = {"Book 1", "Book 2", "Book 3", "Book 4", "Book 5"};
			add(booksOnTable,books);
			String[] moreBooks = {"Book 6", "Book 7","Book 8", "Book 9"};
			addingMore(booksOnTable,moreBooks);
		System.out.println("Is the array full now? " + "(MAX: " + booksOnTable.maxLength()
			+ ") " +booksOnTable.isFull() + "\n");
		remove(booksOnTable);
		System.out.println("Current books: ");
		show(booksOnTable);
		System.out.println("");
		testIsEmpty(booksOnTable);
		remove(booksOnTable);
		System.out.println("Inside the stack is now: " );
		show(booksOnTable);
		System.out.println("Current size of the stack is: " + booksOnTable.getCurrentSize());
		remove(booksOnTable);
		show(booksOnTable);
		System.out.println("Current size of the stack is: " + booksOnTable.getCurrentSize());
	}
	private static void remove(ArrayStackInterface<String> booksOnTable) {
		System.out.println("Removing " +booksOnTable.peek() +" from the stack."+
	"\n----------------------------------------------------");
		booksOnTable.pop();
	}
	private static void add(ArrayStackInterface<String> booksOnTable, String[] books){
		System.out.println("Stacking books onto table.....\n(Please note: First entry is the bottom book)");
		for(int index = 0; index < books.length; index++) {
			booksOnTable.push(books[index]);
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	private static void addingMore(ArrayStackInterface<String> booksOnTable, String[] books){
		System.out.print("Stacking more books onto table.....");
		for(int index = 0; index < books.length; index++) {
			booksOnTable.push(books[index]);
			System.out.print("\nNew book added: ");
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	private static void testIsEmpty(ArrayStackInterface<String> booksOnTable) {
		 System.out.print("The table currently has ");
	      if (booksOnTable.isEmpty())
				System.out.print("no books on it.");
	      else
				System.out.print("books on it.");      
			System.out.println();
	}
	private static void show(ArrayStackInterface<String> booksOnTable) {
		ArrayStackInterface<String> booksOnTableCopy = new ArrayStack<>();
		//popping stack onto temp stack
		System.out.println("(The output is displayed visually with the \ntop book being the top of the stack)");
		while(!booksOnTable.isEmpty()) {
			String tempString = booksOnTable.peek();
			
			booksOnTableCopy.push(tempString);
			System.out.println(booksOnTable.peek() + " ");
			booksOnTable.pop();
		}
		//adding the stacks back onto the original stack
		while(!booksOnTableCopy.isEmpty()) {
			String originalString = booksOnTableCopy.peek();
			booksOnTable.push(originalString);
			booksOnTableCopy.pop();
		}
		
	}
	
}
