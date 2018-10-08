//package cs2400;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/** A class that uses nodes to demonstrate stacking books onto a table and tracking it 
 *  using a BagInterfacethere is no need to expand the size of this bag, as it will 
 *  constantly expand as more entries are entered*/
public class LinkedBagDemo
{
	public static void main(String[] args) 
	{
      // Tests on a bag that is empty
      System.out.println("Creating an empty bag.");
      LinkedBagInterface<String> aBag = new LinkedBag<>();
      displayBag(aBag);
      testIsEmpty(aBag);
      // creating entries and adding them into the bag contentsOfBag
      String[] contentsOfBag = {"Book A", "Book D", "Book B", "Book A", "Book C", "Book A", "Book D"};
      testAdd(aBag, contentsOfBag);
      displayBag(aBag);
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
	    			
	    				if((input <= 0 ) || (input >= contentsOfBag.length + 1)) {
	    					System.out.println("Please enter between 1 through " + contentsOfBag.length);
	    					valid = false;
	    					continue;
	    				}
	    				else 
	    				search(input,aBag);
	    				valid = true;
	    			}
	    }while(!valid);
		kb.close();
      testFrequency(aBag, contentsOfBag);
      System.out.println("Removing a random book now (Will be first node)");
      aBag.remove();
      displayBag(aBag);
      System.out.println("Removing a desired book now (Will remove \"Book B\")");
      aBag.remove("Book B");
      displayBag(aBag);
      testIsEmpty(aBag);
  	  String[] moreBooks = {"Book 7", "Book 8"};
  	  testAdd(aBag, moreBooks);
  	  System.out.println("How many items are in the bag? " + aBag.getCurrentSize() + "\n");
	} // end main
	
	/* searches for a desired entry in the bag
	 * @param desired Desired position of the book to look at
	 * @param aBag bag to look into 
	 */
	private static void search(int desired, LinkedBagInterface<String> aBag) {
		System.out.println("Checking book at position " + desired );
		Object[] bagArray = aBag.toArray();
		Collections.reverse(Arrays.asList(bagArray));
		System.out.print("The book is: " + bagArray[desired-1]);
	    System.out.println("\n---------------------------------");
		
	}
	/* adds entries into a desired bag
	 * @param aBag bag which entries will be added into
	 * @param content string entries to add into the bag 
	 */
	private static void testAdd(LinkedBagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.println(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

    /* Tests the method isEmpty.
     * @param aBag bag that will be checked if its empty
     */   
	private static void testIsEmpty(LinkedBagInterface<String> aBag)
	{
      System.out.print("The table currently has ");
      if (aBag.isEmpty())
			System.out.print("no books on it.");
      else
			System.out.print("books on it.");      
		System.out.println();
	} // end testIsEmpty

	/* Tests the method gretFrequencyOf 
	 * @param aBag bag which entries will be added into
	 * @param tests string entries to add into the bag 
	 */
	private static void testFrequency(LinkedBagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method getFrequencyOf:");
      for (int index = 0; index < tests.length; index++)
         System.out.println("On the table, the frequence of the books " + tests[index] + 
                            " is " + aBag.getFrequencyOf(tests[index]));
   } // end testFrequency
  
   /* Tests the method toArray while displaying the bag.
    * @param aBag bag object to display
    */
	private static void displayBag(LinkedBagInterface<String> aBag)
	{
		System.out.println("The stack contains " + aBag.getCurrentSize() +
		                   " books, as follows (from bottom to top): ");		
		Object[] bagArray = aBag.toArray();
		Collections.reverse(Arrays.asList(bagArray));
		for (int index = 0 ; index < bagArray.length; index++)
		{
			System.out.println(index+1 + ": " + bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end LinkedBagDemo
