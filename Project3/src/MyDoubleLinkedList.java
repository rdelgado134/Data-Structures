import java.util.Collection;
import java.util.Iterator;


public class MyDoubleLinkedList<E extends Comparable<E>> implements MyList<E> {
	
   private Node<E> head, tail;
   private int size;

	    /** Create a default list */
   public MyDoubleLinkedList() 
   {
	   head = null;
	   tail = null;
	   size = 0;
   }

	    /** Create a list from an array of objects */
   public MyDoubleLinkedList(E[] objects) {
      for (E e : objects)
         addLast(e);
   }
	    
   public MyDoubleLinkedList(Collection<? extends E> c) {
      try {
         for (E e : c)
            addLast(e);
      }
      catch (NullPointerException ex) {
         System.out.println(ex);
      }
   }
      
   @Override
   	public boolean add(E e) {
   		//Left as Exercise
      return true;
   }

        /**
	     * Add a new element at the specified index in this list The index of the
	     * head element is 0
	     */
   public void add(int index, E e) {
       	// Left as exercise
   }
   
   @Override
   	public boolean addAll(Collection<? extends E> c) {
   		// Left as exercise
      return true;
   }
   
   /** Add an element to the beginning of the list */
   public void addFirst(E e) {
   // Left as exercise
   }

/** Add an element to the end of the list */
   public void addLast(E e) {
   // Left as exercise
   }
   
   
	    /** Clear the list */
   public void clear() {
      head = tail = null;
   }

   /** Make deep copy of this list */
   @Override
        public Object clone()
   {
          	// Left as exercise
      return null;
   }
   
   /** Check to see if this list contains element e */
   @Override
   public boolean contains(Object e) {
     	// Left as Exercise
      return true;
   }
   
/** Return the element from this list at the specified index */
   public E get(int index) {
        // Left as exercise   
      return null;
   }

  
	    /** Return the head element in the list */
   public E getFirst() {
      // Left as Exercise
      return null;
   }

	    /** Return the last element in the list */
   public E getLast() {
      // Left as Exercise
      return null;
   }

 /**
	* Return the index of the head matching element in this list. Return -1 if
	* no match.
   */
   public int indexOf(Object e) {
      // Left as an exercise;
      return -1;
   }
   
   /**
	  * Return the index of the last matching element in this list Return -1 if
	  * no match.
	 */
   public int lastIndexOf(Object e) {
        // Left as an exercise
      return -1;
   }

   /**
	  * Remove the element at the specified position in this list. Return the
	  * element that was removed from the list.
	 */
   public E remove(int index) {
      // Left as exercise
      return null;
      
   }
	    
	/** Remove the first occurrence of the element e 
	  *  from this list. Return true if the element is removed. 
     */
   @Override
        public boolean remove(Object e)
   {
      	  // Left as Exercise
      return true;
   }
   
    /**
	   * Remove the head node and return the object that is contained in the
	   * removed node.
	   */
   public E removeFirst() {
     // Left as exercise
      return null;
      
   }

	/**
	  * Remove the last node and return the object that is contained in the
	  * removed node.
	  */
   public E removeLast() {
      // Left as exercise
      return null;
      
   }
	    
   /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
   public E set(int index, E e) {
   // Left as exercise
      return null;
       	
   }
   
   /** Return the number of elemnts in this list */
   public int size() {
      return size;
   }
   
   /** Split the original list in half. The original     
	  * list will continue to reference the 
	  * front half of the original list and the method 
	  * returns a reference to a new list that stores the 
	  * back half of the original list. If the number of 
	  * elements is odd, the extra element should remain 
	  * with the front half of the list. */
   public MyDoubleLinkedList<E> split(){
          // Left as Exercise
      return null;
     	   
   }
   
   @Override
   /** Returns an array containing all of the elements in this list in proper sequence 
     * (from first to last element).
     */
   public Object[] toArray() {
      // Left as Exercise 
      return null;
   }

   /** Returns an array containing all of the elements in this list in proper sequence 
     * (from first to last element); the runtime type of the returned array is that 
     * of the specified array.
     */
   //@SuppressWarnings("unchecked")
   //public Object[] toArray(E[] a) {
   	// Left as Exercise 
   //   return null;
   //}



   /** Add a new element at the specified index in this list in ascending order */
   public void addInOrder(E e) {
      // Left as exercis
     		  
   }

	/** Return true if this list contains no elements */
   public  boolean isEmpty() {
      return size() == 0;
   }
    
	    	    
   private void checkIndex(int index) {
      if(index<0 || index >=size)
         throw new IndexOutOfBoundsException("Index "+index +" out of bound for length "+size);
   }
 
   @Override
   public String toString() {
      StringBuilder result = new StringBuilder("[");
   
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
         result.append(current.element);
         current = current.next;
         if (current != null) {
            result.append(", "); // Separate two elements with a comma
         } else {
            result.append("]"); // Insert the closing ] in the string
         }
      }
   
      return result.toString();
   }
	    
   /**  Check to see if this list is identical to the list o */   	    
   public boolean equals(Object o)
   {
     // Left as exercise
      return true;
   }
           
   
	/** Return the element at the middle of this list */   
   public E middleElement() {
     // Left as exercise
      return null;       	
   }

   /** Reverse the elements of this list without creating an extra list. */
   public void reverse() {
      // Left as exercise       	
   }
		
   /** Returns true if this collection contains all of the elements 
     * in the specified collection.
     */

   @Override
   	public boolean containsAll(Collection<?> c) {
      // left as exercsie
      return true;
   }

   /** Removes all of this collection's elements that are also contained in the 
     * specified collection.
     */
   @Override
   	public boolean removeAll(Collection<?> c) {
   	// Left as exercise
      return true;
   }

   /** Retains only the elements in this collection that are contained in the 
     * specified collection
     */
   @Override
   	public boolean retainAll(Collection<?> c) {
   		// Left as exercise
      return true;
   }
		
   /** Override iterator() defined in Iterable */
   @Override
   	public java.util.Iterator<E> iterator() {
      return new DoubleLinkedListIterator();
   }

   private class DoubleLinkedListIterator 
   	    implements java.util.Iterator<E> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}
     // Left as exercise
     
   }
		
   public class Node<T> {
      T element;
      Node<T> next;
      Node<T> previous;
   
      public Node(T o) {
         element = o;
      }
   }

@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}

}
	
