/* Richie Delgado
 * Data Structures 16786-FA2024
 * 9/29/2024
 */
import java.util.*;

public class MyArrayList<E> implements MyList<E> {
   private E[] list;
   private int size=0;
   private int capacity=10;
	
   @SuppressWarnings("unchecked")
   /**A default constructor that creates an empty list with an initial capacity of 10.*/
   public MyArrayList() //[DONE] 
   {
      size = 0;
      list = (E[])(new Object[capacity]);
   }
	
   @SuppressWarnings("unchecked")
   /**A constructor that takes an initial capacity as an argument and creates a list with that capacity.
    * @param initialCapacity */
   public MyArrayList(int initialCapacity)
   {
	  if(initialCapacity < 0)
	  {
		  throw new IllegalArgumentException("The initial capacity cannot be negative: " + initialCapacity);
	  }
      size = 0;
      capacity = initialCapacity;
      list = (E[])(new Object[capacity]);
   }
	
   @SuppressWarnings("unchecked")
   /**A constructor that takes a Collection<? extends E> and adds all its elements to the list.
    * A collection could be any sort of data type such as Abstract data, sequential list, arraylist, 
    * vector, stack, linked list
    * @param c
    */
   public MyArrayList(Collection<E> c) //[DONE]
   {
	   if(c == null)
	   {
		   throw new NullPointerException("The collection cannot be null.");
	   }
	   size = 0;
	   list = (E[])(new Object[capacity]);//allocate an array with 10 spaces
	   for(E e: c) 						  //For each element in c add e
	   {
		   this.add(e);	   
	   }
   }
	
   @Override
   /** Add a new element at the specified position. @param e*/
   public boolean add(E e)
   {
   	// TODO Auto-generated method stub
	   //allowing null elements????
	  ensureCapacity();
	   list[size] = e; //this assumes that size is within bounds...Might need exception handling
		size++;
      return true;
   }
	
   /**Verifies that the index given is valid for our use cases. @param index*/
   private void checkIndex(int index)
   {
      if(index < 0 || index >= size)
         throw new IndexOutOfBoundsException("Index "+index +" out of bound for length "+size);
   }
	
   /**Adds the element at the given index. @Param index, element.*/
   @Override
   public void add(int index, E element)//[DONE]
   {
	   	// TODO Auto-generated method stub
	   try {
		   checkIndex(index);//if it doesnt catch shift to the right to add our new element
		   //ensure there is room
		   ensureCapacity();
		   for(int i = size; i > index; i--)
		   {
			   list[i] = list[i-1];
		   }
		   list[index] = element;
		   size++;
	   }
	   catch(IndexOutOfBoundsException ex) 
	   {
		   System.out.println(ex);
	   }
   }
	
	/**add all elements from c into the calling object @param c*/
   @SuppressWarnings("unchecked")
public boolean addAll(Collection<? extends E> c)
   {
	    boolean addedAll = false;
	    Object[] givenList = c.toArray();  // Convert the collection to an array

	    // Ensure there's enough capacity to hold all new elements
	    ensureCapacity();  // This will now handle resizing automatically

	    // Add elements from the collection
	    for (int i = 0; i < givenList.length; i++) 
	    {
	        this.add((E) givenList[i]);  // Cast and add each element
	    }

	    // Mark success if elements were added
	    if (givenList.length > 0) 
	    {
	        addedAll = true;
	    }

	    return addedAll;
   }
   @Override
 /**Clears the calling  list of its elements.*/
   public void clear()
   {
	   //for every element use remove() until size == 0
	   while(!this.isEmpty())
	   {
		   this.remove(0);
	   }
	   
   }
	
   public String toString()
   {
      if(size==0)
         return "[]";
      @SuppressWarnings("unchecked")
         E[] temp = (E[])(new Object[size]);
      System.arraycopy(list, 0, temp, 0, size);
      return Arrays.asList(temp).toString();
   }
	
   /*Check if the calling method contains o. @param o*/
   @SuppressWarnings({ "unchecked", "unchecked" })
   public boolean contains(Object o) 
   {
   // TODO Auto-generated method stub
	   boolean found = false;
	   for(int i = 0; i < size ; i++)
	   {
		   if(this.get(i).equals(o))
		   {
			   found = true;
		   }
	   }
      return found;
   }
	  /** Returns the element from this list at the specified index Throw exception if index out of range. @param index*/
   public E get(int index) 
   {
	   try
	   {
		   checkIndex(index);
	   }
	   catch (IndexOutOfBoundsException e)
	   {
		   System.out.println("Error: " + e.getMessage());
	   }
	   return list[index];	
   }
   
	  /** Returns the index of the first matching element in this list. @param o */
   @SuppressWarnings("unchecked")
   public int indexOf(Object o) //[DONE]
   {
	   //parse through the passed object and check the contents of each element. increment indexFound for every occasion
	  for(int i = 0; i < this.size(); i++)
	  {
		  if(this.get(i).equals(o))
		  {
			  return i;
		  }
	  }
      return -1;
   }
	/*Checks if calling list is empty. */
   @Override
   public boolean isEmpty()
   {
	   return (size == 0);
   }
	
   @SuppressWarnings("unchecked")
   /** Returns the index of the last matching element in this list. @param o*/
   public int lastIndexOf(Object o) 
   {
   // TODO Auto-generated method stub
	   int indexFound = this.size() - 1;
		  	
	   for(int i = this.size()-1; i > 0; i--) //start the search at the end of arraylist at the end and return first occurance index
	   {
		   if(this.get(i).equals(o))
		   {
			   return indexFound;
		   }
		   indexFound--;
	   }
	   return -1; //return -1 if not found
   }
	  /** Remove the element at the specified position in this list and move everything after it the value of i+1
	   *  Return the element that was removed from the list. 
	   *  Throw exception if index out of range. @param index
	  */
   @Override
   public E remove(int index)//[Sorta]
   {
	   try
	   {
		   checkIndex(index);
		   E oldValue = list[index];	 //save the element to be removed so you can return it
		   for(int i = index; i < size- 1; i++) //start at the index that is getting removed
		   	{
		   		list[i] = list[i + 1]; 	//shift every value of arrayList to the left
		   	}
		   list[size - 1] = null;
		   size--;						//make the last element null
		   	return oldValue;			//this will return the element at the called index
	   }
	   catch (IndexOutOfBoundsException e)
	   {
		   System.out.println("Error: " + e.getMessage());
		   return null;
	   }
	   
	 	  
	   	
	   	
	   	
   }
	/**Removes the passed object from the calling list. @param o*/
   @Override
   public  boolean remove(Object o) 
   {
   // TODO Auto-generated method stub
	   boolean removedElement = false;
	   	for(int i = 0; i < size; i++) //parse the array to find o
	   	{
	   		if(this.get(i).equals(o)) //if atleast one element is removed return true
	   		{
	   			 remove(i);
	   			 
	   			removedElement = true;
	   		}
	   	}
      return removedElement;
   }
	
   /** Replace element at given index with new element and return old element
	   * Throw exception if index out of range. @param index , element
	  */
   public E set(int index, E element)
   {
	   try 
	   {
		   checkIndex(index);
		   E oldValue = list[index]; //store old element to return
		   list[index] = element;	//list at given index equals new value
		
	      return oldValue;
	   }
	   catch (IndexOutOfBoundsException e)
	   {
		   System.out.println("Error: " + e.getMessage());
		   return null;
	   }
   }
	
   @Override
   public int size() //[]
   {
      return size;
   }

   public int getCapacity()
   {
	   return capacity;
   }
   
	/** reduces the capacity of a list to fit exactly 
	 * the number of items that the list contains*/
   @SuppressWarnings("unchecked")
public void trimToSize()
   {
	    if (capacity > size) 
	    {
	        E[] newList = (E[]) new Object[size];		//Create a new array of type E with length 'size'
	        System.arraycopy(list, 0, newList, 0, size);// Use System.arraycopy for efficient copying
	        list = newList;								// Update the internal list and capacity
	        capacity = size;
	    }
   
   }
	
   /**If the list is full, increase its capacity by 5.*/
   @SuppressWarnings("unchecked")
private void ensureCapacity() 
   {
	   if(size >= capacity)
	   {
		   capacity += 5;
		   E[] newList = (E[]) new Object[capacity]; 		//Create a new array with the increased capacity
		   
		   System.arraycopy(list,  0,  newList,  0,  size); //Copy existing elements from the old array into the new one.
		   list = newList;									//Update reference
	   }
   }
   /**Creates the calling object into an array*/
   @Override
   public Object[] toArray()
   {
	   Object[] result = new Object[size];
	   for(int i = 0; i < size; i++)
	   {
		   result[i] = this.list[i];
	   }
      return result;
   }

	/** Returns an array containing all of the elements in this collection; 
     * the runtime type of the returned array is that of the specified array. @param array
     */
	
   @SuppressWarnings("unchecked")
   public  <E> E[] toArray(E[] array)
   {
	   //this will handle integer[], string[], and character[] objects and not their primitives ie int[]
	    // Check if the provided array is large enough
	    if (array.length < size)
	    {
	        // If not, create a new array of the same type
	        array = (E[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
	    }
	    
	    // Copy elements from the internal list to the provided array
	    for (int i = 0; i < size; i++) 
	    {
	        array[i] = (E) list[i];  // Cast to E to ensure type safety
	    }
	    
	    // If the array is longer than size, null remaining elements
	    if (array.length > size) 
	    {
	        array[size] = null;  // Null the element at index 'size'
	    }

	    return array;  // Return the filled array
   }
   /**Checks if calling list has all objects from given Collection. @param c */
   @Override
   public boolean containsAll(Collection<?> c)
   {
	   for(Object element : c)
	   {
		   if(!this.contains(element))
		   {
			   return false;
		   }
	   }
      return true;
   }
   /**Removes all elements from c that are in the calling object. @param c*/
   @Override
   public boolean removeAll(Collection<?> c) 
   {
   	// TODO Auto-generated method stub
	   boolean collectionModified = false;
	   for(int i = 0; i < this.size(); i++) //parse the list
	   {
		   if(c.contains(list[i]))			//if list hasa value from c, remove it 
		   {
			   remove(i);
			   i--; 						//bring i back one since as element was removed
			   collectionModified = true;	
		   }
	   }
      return collectionModified;
   }

   /**Calling list keeps all elements from c. @param c.*/
   @Override
   public boolean retainAll(Collection<?> c)
   {
	   boolean collectionModified = false;
	   for(int i = 0; i < this.size(); i++)
	   {
		   if(!c.contains(list[i]))
		   {
			   remove(i);
			   i--;
			   collectionModified = true;
		   }
	   }
      return collectionModified;
   }
	
   @Override 
     public java.util.Iterator<E> iterator() 
   {
      return new ArrayListIterator();
   }
	 
   private class ArrayListIterator 
         implements java.util.Iterator<E> 
   {
      private int current = 0;
   
      @Override
       public boolean hasNext() 
      {
         return current < size;
      }
   
      @Override
       public E next() 
      {
    	  if(!hasNext())
    	  {
    		  throw new NoSuchElementException();
    	  }
         return (E)list[current++];
      }
   
      /* Remove the element returned by the last next()*/
      @Override
       public void remove() 
      {
         if (current == 0) 
            throw new IllegalStateException(); 
         MyArrayList.this.remove(--current);
      }
   }
}
