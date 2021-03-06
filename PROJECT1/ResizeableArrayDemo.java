//package cs2400;
/** A class that uses a resizeable array to demonstrate stacking books 
  * onto a table and tracking it using a BagInterface
  *	will double the size of the bag when it determines the bag is full*/
public class ResizeableArrayDemo {
	public static void main(String[] args) {
		System.out.println("Creating an empty bag.");
		BagInterface<String> booksOnTable = new ResizeableArrayBag<>();
	    showBag(booksOnTable);
	    testIsEmpty(booksOnTable);
		String[] books = {"Book 1", "Book 2", "Book 3", "Book 4", "Book 5"};
			add(booksOnTable, books);
			showBag(booksOnTable);
			// tests where the bag is full or not
			System.out.println("Is the array full? (MAX 5): " + booksOnTable.isFull());
			//demonstrates adding more entries to a already full bag
		String[] moreBooks = {"Book 6", "Book 7"};
			addingMore(booksOnTable,moreBooks);
			showBag(booksOnTable);
			System.out.println("Is the array full now? (MAX 10): " + booksOnTable.isFull() + "\n");
		search(6,booksOnTable);
		
			
	}//end of main
	
	/* searches for a desired entry in the bag
	 * @param desired Desired position of the book to look at
	 * @param booksOnTable bag to look into 
	 */
	private static void search(int desired, BagInterface<String> booksOnTable) {
		System.out.println("Checking book at position " + desired );
		Object[] bagArray = booksOnTable.toArray();
		System.out.print("The book is: " + bagArray[desired-1]);
	    System.out.println("\n---------------------------------");
		
	}
	/* adds entries into a desired bag
	 * @param booksOnTable bag which entries will be added into
	 * @param books string entries to add into the bag 
	 */
	private static void add(BagInterface<String> booksOnTable, String[] books){
		System.out.println("Stacking more books onto table.....\n(Please note: First entry is the bottom book)");
		for(int index = 0; index < books.length; index++) {
			booksOnTable.add(books[index]);
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	/** A modified method of the add() method which will add more entries
	 *  into an existing bag but will display only the books to be added
	 */
	private static void addingMore(BagInterface<String> booksOnTable, String[] books){
		System.out.println("Stacking more books onto table.....");
		for(int index = 0; index < books.length; index++) {
			booksOnTable.add(books[index]);
			System.out.print("\nNew book added: ");
			System.out.print(books[index] + " ");
		}
		System.out.println("\n---------------------------------");
	}
	/* displays all entries in the bag
	 * @param booksOnTable selected bag which will display all its entries
	 */
	public static void showBag(BagInterface<String> booksOnTable) {
		System.out.println("The bag contains " + booksOnTable.getCurrentSize() +
                " books, as follows (from bottom to top):");		
	Object[] bagArray = booksOnTable.toArray();
	for (int index = 0; index < bagArray.length; index++)
	{
		System.out.print(bagArray[index] + " ");
	} // end for

	System.out.println("\n----------------------------------");
	}
	/* Determines if the selected entry is in the bag
	 * @param booksOnTable bag which the program will look into
	 * @param books the desired entry to search for
	 */
	private static void bagContains(BagInterface<String> booksOnTable, String[] books)
	{
 		System.out.println("Checking availibilty of books in pile...");
      for (int index = 0; index < books.length; index++)
         System.out.println("Does this bag contain " + books[index] + 
                            "? " + booksOnTable.contains(books[index]));
      System.out.println("---------------------------------");
   }
	private static void testIsEmpty(BagInterface<String> aBag)
	{
      System.out.print("The table currently has ");
      if (aBag.isEmpty())
			System.out.print("no books on it.");
      else
			System.out.print("books on it.");      
		System.out.println();
	} // end testIsEmpty
}
