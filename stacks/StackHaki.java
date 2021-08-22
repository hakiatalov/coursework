// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 3 Programming 1
// IDE:			Eclipse

package assignment3;

import java.util.EmptyStackException;

public class StackHaki <E> {
	
	// Stack data parameters
	private Node head;
	private Node tail;
	private int size;
	
	public class Node {
		
		// Node data parameters
		E data;
		Node next;
		
		// Node constructor
		Node(E element) {
			data = element;
			next = null;
		}
		
		//Node toString method to print Node element
		public String toString() { 
			return String.valueOf(this.data);
		}
		
	}
	
	// Stack constructor
	public StackHaki() {
		size = 0;
		head = null;
		tail = null;
	}
	
	// Method that checks if stack is empty by validating if size is 0
	public Boolean isEmpty() {
		
		return size == 0;
	}
	
	// Method that returns the value of the size data parameter
	public int size() {
		
		return size;
	}
	
	// Method that returns the element at the top of the stack without removing the element.
	public E peek() {
		
		E returnValue = null; // New generic to initialize the return value. 
		
		if (size == 0) {
			// If the stack is empty, let the user know and throw an exception. 
			System.out.println("\nThe list is empty\n");
			throw new EmptyStackException();
		} else {
			// If stack is not empty, set return to the tail value since that is the last item / top of the stack.  
			returnValue = tail.data;
		}
		return returnValue; // Return the element
	}
	
	// Method that returns the element at the top of the stack and removes the element.
	public E pop() {
		
		E returnValue = null; // New generic to initialize the return value.
		
		if (size == 0) {
			// If the stack is empty, let the user know and throw an exception.
			System.out.println("\nPop failed. List is Empty now.\n");
			throw new EmptyStackException();
		} else {
			
			// If stack is not empty, grab the tail value and set the tail as the previous value.
			// Grab the last element to return since the method will remove the last element. 
			returnValue = tail.data;
			
			if (size == 1) {
				// If there is only one element in the stack, popping the element will leave 0 elements. 
				// Need to set the head and tail to null to indicate no elements.
				head = null;
				tail = null;
				
			} else {
				
				Node current = head; // Create a temp node from head to begin iterating. 
				
				// Iterate through the stack until the second to last one
				for (int i = 0; i < size - 2; i++) {
					current = current.next;
				}
				
				// Set the next value as null to remove the top element from the stack. 
				current.next = null;
				tail = current; // Set the second to last value as the tail. 
			}
			
			size--; // Decrement size.
		}
		
		return returnValue;
	}
	
	// Method to add a new element to the top of the stack. 
	public void push(E element) {
		
		// Create the new node with the given element. 
		Node newNode = new Node(element);
		
		if (tail == null) {
			// If tail is null then the stack is currently empty. 
			// If the stack is empty then the head and tail are set to the same element. 
			head = newNode;
			tail = newNode;
		} else {
			// If the stack is not empty, set the next value of tail to the new node and set the tail equal to the new node as the last element. 
			tail.next = newNode;
			tail = newNode;
		}
		
		size++; // Increment size.
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
