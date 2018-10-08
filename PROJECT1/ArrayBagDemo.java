//package cs2400;

import java.util.Scanner;
/** A class that uses array to demonstrate stacking books onto 
 *  a table and tracking it using a BagInterface.
 */
public class ArrayBagDemo {
	public static void main(String[] args) {
		boolean valid = true; //boolean flag used for input validation 
		BagInterface<String> booksOnTable = new ArrayBag<>(); 
		String[] books = {"Book 1", "Book 2", "Book 3", "Book 4", "Book 5"};
			add(booksOnTable, books);
			showBag(booksOnTable);
			bagContains(booksOnTable, books);
			Scanner kb= new Scanner(System.in);
			 do {
				 System.out.print("What book would you like at (starting from bottom to top)? ");
		    			if(!kb.hasNextInt()) {
		    				System.out.println("Invalid reponse!");
		    				kb.next();
		    				valid = false;
		    			}
		    			else { 
		    				int input = kb.nextInt();
		    			
		    				if((input <= 0 ) || (input >= books.length + 1)) {
		    					System.out.println("Please enter between 1 through " + books.length);
		    					valid = false;
		    					continue;
		    				}
		    				else 
		    				search(input,booksOnTable);
		    				valid = true;
		    			}
		    }while(!valid);
			kb.close();
	System.out.println("Now performing other actions to show manipulation of books...");
	System.out.println("\nRemoving a book...");
	//remove a random entry from the bag (in this situation, the top book will be removed)
	booksOnTable.remove();
	showBag(booksOnTable);
	
	System.out.println("Clearing all books from stack one at a time...");
	Object[] bagArray = booksOnTable.toArray();
	for (int index = 0; index < bagArray.length; index++)
	{
		booksOnTable.remove();
		System.out.println("Amount of books left on table: " + booksOnTable.getCurrentSize());
	} // end for
	System.out.println("Is the table empty now?");
	System.out.println(booksOnTable.isEmpty());

	}//end of main
	
	/* searches for a desired entry in the bag
	 * @param desired Desired position of the book to look at
	 * @param booksOnTable bag to look into 
	 */
	private static void search(int desired, BagInterface<String> booksOnTable) {
		System.out.println("Checking book at position " + desired );
		//utilize toArray() method to transfer entries in bag to a new array
		Object[] bagArray = booksOnTable.toArray();
		System.out.print("The book is: " + bagArray[desired-1]);
	    System.out.println("\n---------------------------------");
		
	}
	/* adds entries into a desired bag
	 * @param booksOnTable bag which entries will be added into
	 * @param books string entries to add into the bag 
	 */
	private static void add(BagInterface<String> booksOnTable, String[] books){
		System.out.println("Stacking books onto table.....\n(Please note: First entry is the bottom book)");
		//stimulates stacking books and showing it visually
		for(int index = 0; index < books.length; index++) {
			booksOnTable.add(books[index]);
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	/* displays all entries in the bag
	 * @param booksOnTable selected bag which will display all its entries
	 */
	public static void showBag(BagInterface<String> booksOnTable) {
		System.out.println("The bag contains " + booksOnTable.getCurrentSize() +
                " books, as follows:");		
	Object[] bagArray = booksOnTable.toArray();
	for (int index = 0; index < bagArray.length; index++)
	{
		System.out.print(bagArray[index] + " ");
	} // end for

	System.out.println("\n----------------------------------");
	}
	/* determines if the selected entry is in the bag
	 * @param booksOnTable bag which the program will look into
	 * @param books the desired entry to search for
	 */
	private static void bagContains(BagInterface<String> booksOnTable, String[] books)
	{
 		System.out.println("Checking availibilty of books in pile...");
      for (int index = 0; index < books.length; index++)
         System.out.println("Does this bag contain " + books[index] + 
                            "? " + booksOnTable.contains(books[index])); //will return false if item is not in the bag
      System.out.println("---------------------------------");
   } //
}//end of demo

