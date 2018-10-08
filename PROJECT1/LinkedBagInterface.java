//package cs2400;

public interface LinkedBagInterface<T> {
		/*obtains current number of entries in the bag
		@returns an int value of the amount of entries*/
		public int getCurrentSize(); 
		/*determines whether the bag is empty
		@returns a boolean value if this is true or not*/
		public boolean isEmpty(); 
		/*adds a new entry into the bag in no specific order
		@param newEntry object to be added into the bag
		@returns boolean value that is either true or false*/
		public boolean add(T newEntry); 
		/*removes a random entry from the bag, if possible
		@returns null if false, true it just proceeds*/
		public T remove();
		/*removes one entry of the desired entry in the bag, if possbile
		@param anEntry desired object to be removed
		@returns boolean value that is either true or false*/
		public boolean remove(T anEntry); 
		//removes all entries in the bag
		public void clear(); 
		/*shows how many of the entries appear in the bag
		@param anEntry the entry the user wants to see the frequency of
		@return the number of times the desired entry is in the bag*/
		public int getFrequencyOf(T anEntry); 
		/*determines whether the bag has the desired entry selected
		@param anEntry object to be checked in the bag
		@returns boolean value that is either true or false*/
		public boolean contains(T anEntry); 
		/*gathers all entries in the bag and puts them into an array
		@returns a newly allocated array which can be manipulated to perform
		actions such as outputting all entries in bag*/
		public T[] toArray(); 

}
