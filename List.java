

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTORS ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition
	 */
	public List() {
		length = 0;
		first = null;
		last = null;
		iterator = null;

	}

	/**
	 * Instantiates a new List by copying another List
	 * 
	 * @param original the List to make a copy of
	 * @postcondition a new List object, which is an identical but separate copy of
	 *                the List original
	 */
	public List(List<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		} else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}
	
	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition length != 0
	 * @return the value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFirst:List is Empty.No data to access!");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition length != 0
	 * @return the value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast:List is Empty. No data to access!");
		}
		return last.data;
	}

	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns the current length of the list
	 * 
	 * @return the length of the list from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns the element that the iterator is pointing at
	 * 
	 * @precondition iterator !=0
	 * @return the value pointed by the iterator
	 * @throws NullPointerException when precondition is violated
	 */
	public T getIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("getIterator: " + "iterator is of the end of the list");
		}
		return iterator.data;
	}

	/**
	 * Returns whether or not the iterator is off the end of the list , i.e null
	 * 
	 * @return whether the iterator is null
	 */
	public boolean offEnd() {
		return iterator == null;
	}

	/**
	 * Returns Boolean Whether two lists are the same or not
	 * 
	 * @param another linked list
	 * @return boolean value of true or false
	 */

	@Override
	public boolean equals(Object a) {
		if (this == a) {
			return true;
		} else if (!(a instanceof List)) {
			return false;
		} else {
			List<T> otherList = (List<T>) a;

			if (this.length == otherList.length) {

				Node list1 = this.first;
				Node list2 = otherList.first;

				while (list1 != null) {
					if (!(list1.data.equals(list2.data))) {
						return false;
					}
					list1 = list1.next;
					list2 = list2.next;
				}
				return true;
			}
		}
		return true;
	}


	/**** MUTATORS ****/
	
	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition A new node will be added before the first node
	 */
	public void addFirst(T data) {
		if (length == 0) {
			Node n = new Node(data);
			first = last = n;
		} else {
			Node n = new Node(data);
			n.next = first;
			first.prev = n;
			first = n;
		}
		length++;
	}
	
	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the list
	 * @postcondition a new node will be added after the last node
	 */
	public void addLast(T data) {
		if (length == 0) {
			first = last = new Node(data);
		} else {
			Node n = new Node(data);
			last.next = n;
			n.prev = last;
			last = n;
		}
		length++;
	}

	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition length !=0
	 * @postcondition the first element will be removed
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeFirst: list is empty. Nothing to remove.");
		} else if (length == 1) {
			first = last = iterator = null;

		} else {
			first = first.next;
			first.prev = null;
		}
		length--; 
	}

	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition length != 0
	 * @postcondition the last element will be removed
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("removeLast: list is empty. Nothing to remove.");
		} else if (length == 1) {
			first = last = iterator = null;
		} else {
			last = last.prev;
			last.next = null;
			}
		length--;
	}

	/**
	 * Places an iterator at the beginning of the list
	 * 
	 */
	public void placeIterator() {
		iterator = first;
	}

	/**
	 * Remove the element currently pointed at by the iterator
	 * 
	 * @precondition iterator != null
	 * @throws NullPointerException when precondition is violated
	 */
	public void removeIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException(
					"removeIterator: " + "Current iterator points at null, no data available to remove");
		}else if (iterator == first){
			removeFirst ();
		}else if (iterator == last){
			removeLast();
		}else {
			iterator.next.prev = iterator.prev;
			iterator.prev.next = iterator.next;
			length--;
		}
		iterator = null;
	}

	/**
	 * Inserts new data in the List after the iterator
	 * 
	 * @param data the new data to insert
	 * @precondition iterator != null
	 * @throws NullPointerException when the precondition is violated
	 */
	public void addIterator(T data) throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException("addIterator " + "Iterator is off end. Cannot add.");
		} else if (iterator == last) { // edge case
			addLast(data);
			length++;
		} else { // general case
			Node n = new Node(data);
			n.next = iterator.next;
			n.prev = iterator;
			iterator.next.prev = n;
			iterator.next = n;
			length++;
		}
	}

	/**
	 * Advances the iterator by one node in the list
	 * 
	 * @precondition !offEnd()
	 * @throws NullPointerException when the precondition is violated
	 */
	public void advanceIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("advanceIterator: " + "Iterator is null and cannot advance.");
		}
		iterator = iterator.next;
	}

	/**
	 * Reverses the iterator by one node in the list
	 * 
	 * @precondition iterator != null
	 * @throws NullPointerException when the precondition is violated
	 */
	public void reverseIterator() {
		if (iterator == null) {
			throw new NullPointerException("reverseIterator: " + "Iterator is null and cannot reverse.");
		}
		iterator = iterator.prev;
	}

	
	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * List with each value on its own line At the end of the List a new line
	 * 
	 * @return the List as a String for display
	 */

	@Override
	public String toString() {

		String result = "";

		Node temp = first;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		return result + "\n";
	}

	public void printNumberedList() {
		Node n = first;
		int count = 0;
		while (n != null) {
			count++;
			System.out.print(count + ". " + n.data + "\n");
			n = n.next;

		}
	}

/**
* Advances the iterator exactly n times
* @param n the number of times to advance
* the iterator
* @precondition iterator != null
* @precondition (n + indexIterator) <= length
* @throws NullPointerException when the 
* iterator is offEnd
* @throws IndexOutOfBoundsException when
* (iterator position + n) > length
*/
public void advanceNTimes(int n) throws NullPointerException, IndexOutOfBoundsException{
	if (offEnd()) {
		throw new NullPointerException("advanceNTimes " + "Iterator is off end. Cannot advance.");
	} else if ((n+this.linearSearch(iterator.data)) > length) {
		throw new IndexOutOfBoundsException("advanceNTimes " + "Index is out of bounds. Cannot advance.");
	} else {
		this.placeIterator();
		for (int i = 0; i < n ; i++) {
			this.advanceIterator();
		}
	}
}

/**
* Searches the List for a specific element
* @param data the element to search for
* @return the location of the element in the 
* List from 1 to length or -1 if not found
* @postcondition the position of the iterator remains
* unchanged
*/
public int linearSearch(T data) {
	if (!isEmpty()) {
		Node temp = first;
		int count = 1;
		while (!temp.data.equals(data)) {
			count++;
    		if (temp.next == null) 
    			return -1;
			temp = temp.next;
		}

			return count;
	}
	return -1;
}
}
