// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 2 Programming 1
// IDE:			Eclipse

package assignment2;

import java.util.NoSuchElementException;

public class LinkedListHaki <E> {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	// Because LinkedList and Node use same element type <E>,
	// I don't need to use another generic <T> for internal Node Class (I used it in our class, but not now)
	public class Node {
		E data;
		Node next;
		//Node constructor
		public Node(E element) { 
			data = element;
			next = null;
			}
		//Node toString method to print Node element
		public String toString() { 
			return String.valueOf(this.data);
		}
	}

	public LinkedListHaki (){
		head = null;
		tail = null;
		size = 0;
	}

	public void add(int index, E element) {
		
		// add an element(as a node) at given index
		
		// Check if given index is first element. If so, call add first method. 
		if (index == 0) {
			
			addFirst(element);
			
		} else if (index <= size - 1) { // logic if not first index
			
			System.out.println("\nTesting method addAtIndex()");
			System.out.println("List content before adding node at index " + index + " is: " + toString());
			
			Node temp1 = head; // Grab the first element to begin iteration
			
			while (--index > 0) { // Iterate through all elements until element right before target index is reached
				temp1 = temp1.next;
			}
			
			Node temp2 = temp1.next; // Grab the element that will become the new nodes next link
			Node newNode = new Node(element); // Create the new element
			
			temp1.next = newNode; // set the element right before target index next value to new element
			newNode.next = temp2; // set the new element next value to the stored value of the previous elements next value
			
			// If the next link is null it means it is the last element in the list. Need to update tail to reflect the new last element
			if (newNode.next == null) {
				tail = newNode; 
			}
			
			size++; // Increment size
			
			System.out.println("List content after adding node at index " + index + " is:  " + toString());
			System.out.print("\n");
			
		} else {
			
			// If index is greater than list size, show error message. 
			System.out.print("\nCannot add at index greater than list size - ");
			System.out.print("Index: " + index + ", Size: " + size + "\n"); 
			
		}
		
	}
	
	public void addFirst(E element) {
		
		// add an element(as a node) at the first of the list.
		
		System.out.println("\nTesting method addFirstNode()");
		System.out.println("List content before adding first node is: " + toString());
		
		Node newNode = new Node(element); // Create the new element as a Node.
		newNode.next = head; // Set the next value of that element to the current head. 
		head = newNode; // The head now becomes the new element.
		
		// If the next link is null it means it is the last element in the list. Need to update tail to reflect the new last element
		if (newNode.next == null) {
			tail = newNode;
		}
		
		size++; // Increment size
		
		System.out.println("List content after adding first node is:  " + toString());
		System.out.print("\n");
		
	}
	
	public void addLast(E element) {
		
		// add an element(as a node) at the last of current list
		
		System.out.println("\nTesting method addLastNode()");
		System.out.println("List content before adding last node is: " + toString());
		
		if (size == 0) {
			// If the list is empty then just need to add the first element. The first element method will set the tail since the next value will be null. 
			addFirst(element);
			
		} else { // If not empty
		
			Node newNode = new Node(element); // Create the new element as a Node.
			tail.next = newNode; // Set the next value of the current tail to be the new element. The existing tail will now become second to last. 
			tail = newNode; // Set the tail of the list to the new element.
			
			size++; // Increment size
		}
		
		System.out.println("List content after adding last node is:  " + toString());
		System.out.print("\n");
		
	}
	
	public E getFirst() {
		
		// Return the element value of first node
		
		if (head == null) {
			throw new NoSuchElementException(); // If head is null, throw exception
		} else {
			return head.data; // Return the element of head
	
		}
	}
	
	public E getLast() {

		// Return the element value of first node
		
		if (tail == null) { 
			throw new NoSuchElementException(); // If tail is null, throw exception
		} else {
			return tail.data; // Return the element of tail
		}
	}
	
	public void remove(int index) {
		
		// Remove an element(a node) at given index
		
		if (size == 0) { // If list is empty, print a message that the remove failed and throw an exception. 
			
			System.out.println("\nRemove failed. List is Empty now.\n");
		
		} else {
			
			if (index == 0) { // If index targets first element, remove first. 
				
				removeFirst();
				
			} else if (index == size - 1) { // If index targets last element, remove last.
				
				removeLast();
				
			} else if (index < size - 1) { // Otherwise, remove element at specified index
				
				System.out.println("\nTesting method removeAtIndex()");
				System.out.println("List content before removing at index " + index + " is: " + toString());
				
				if (size == 1) { // If there is only 1 element in the list, remove the links from head and tail. This orphans the element for garbage collection. 
					
					head = null;
					tail = null;
					size--; // Decrement size
					
				} else { // Otherwise, update the links
					
					Node cur = head; // Get the first element for iteration and iterate until just before target element
					while (--index > 0) {
						cur = cur.next;
					}
					
					Node targetNode = cur.next; // Create a new element for the targeted index. 
					cur.next = targetNode.next; // Set the next value of the element just before the target to the element right after the target. This orphans the target element for garbage collection.
					
					size--; // Decrement size
					
				}
				
				System.out.println("List content after removing at index " + index + " is:  " + toString());
				System.out.print("\n");
				
			} else {
				
				// If index is greater than list size, show error message. 
				System.out.print("/nCannot remove at index greater than list size - ");
				System.out.print("Index: " + index + ", Size: " + size + "\n"); 
				
			}
		}
		

	}

	public E removeFirst() {
		
		// Remove an element(a node) at given index		
		
		if (size == 0) { // If list is empty, print a message that the remove failed
			
			System.out.println("\nRemove failed. List is Empty now.\n");
			return null;
			
		} else {
		
			System.out.println("\nTesting method removeFirstNode()");
			System.out.println("List content before removing first node is: " + toString());
			
			Node temp1 = head; // Grab the head for removal
			
			if (size == 1) { // If there is only 1 element in the list, remove the links from head and tail. This orphans the element for garbage collection.
				
				head = null;
				tail = null;
				size--; // Decrement size
				
			} else {
				
				Node temp2 = head.next; // Get the next item right after head. 
				head = temp2; // Set the head to be the item right after head. 
				size--; // Decrement size
				
			}
			
			System.out.println("Removing element: " + temp1.data);
			System.out.println("List content after removing first node is:  " + toString());
			System.out.print("\n");
			
			return temp1.data; // Returning the element that was removed.
		}
		
	}
	
	public E removeLast() {
		
		// Remove an element(a node) at given index
		
		int index = size - 1; // Set the target index to be the last element in the list. 
		
		if (size == 0) { // If list is empty, print a message that the remove failed
			System.out.println("\nRemove failed. List is Empty now.\n");
			return null;
		} else {
		
			System.out.println("\nTesting method removeLastNode()");
			System.out.println("List content before removing last node is: " + toString());
			
			Node cur = head; // Grab the head for iteration
			
			while (--index > 0) { // Iterate through the list until right before target/last element
				cur = cur.next;
			}
			
			Node targetNode = cur.next; // Grab the target/last element so it can be returned. 
			
			tail = cur; // Set the tail to be the element right before the target/last element
			
			tail.next = null; // Set the next value to be null since this is now the last element
			
			size--; // Decrement size
			
			System.out.println("Removing element: " + targetNode.data);
			System.out.println("List content after removing last node is:  " + toString());
			System.out.print("\n");
			
			return targetNode.data; // Returning the element that was removed.
		}
	}
	
	public int size() {
		
		// Return how many elements in current list
		
		return size; // Return the size data field. 
	}
	
	public String toString() {
		Node temp = head;
		if(temp==null)
			return "[]";
		String str = "[";
		while(temp.next != null) {
			str = str + temp.data + ", ";
			temp = temp.next;
		}
		str = str + temp.data;
		
		return str + "]";
	}
	
}
