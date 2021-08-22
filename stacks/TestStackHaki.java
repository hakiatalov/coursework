// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 3 Programming 2
// IDE:			Eclipse

package assignment3;

import java.util.Scanner;

public class TestStackHaki {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Initialize scanner. 
		
		StackHaki<Integer> myStack = new StackHaki<>(); // Initialize Stack
		
		boolean runProgram = true; // Initializing boolean to control program level sentinel loop
		
		while (runProgram) { // Sentinel while loop to control re-running the program based on user input Y/N
			
			// Constructing main prompt
			System.out.print("----------Main Menu----------\n" + 
								"0 - Exit Program\n" +
								"1 - Push\n" + 
								"2 - Pop\n" + 
								"3 - Peek (Top)\n" + 
								"4 - Size\n" + 
								"5 - Is Empty?\n" + 
								"6 - Print Stack\n" + 
								"Select Option: ");
			
			int option = input.nextInt(); // Grabbing user input
			int element; // initializing element input
			
			switch (option) { // Switch to react to user input
				case 0:
					// Exit the program and set the sentinel variable to false to stop the loop. 
					System.out.println("\nThank you for using the Stack Test Program.");
					System.out.println("Your Stack:" + myStack.toString() + "\n");
					runProgram = false;
					break;
				case 1:
					// Grab the integer the user wants to add and call the method to add the element to the stack.
					System.out.print("\nEnter element to add (integer): ");
					element = input.nextInt();
					System.out.print("\nStack before pushing element: " + myStack.toString());
					myStack.push(element);
					System.out.print("\nStack after pushing element: " + myStack.toString() + "\n\n");
					break;
				case 2: 
					// Creating user prompts to describe stack and calling method to pop the last element
					System.out.print("\nStack before popping top element: " + myStack.toString());
					System.out.print("\nPopped element: " + myStack.pop());
					System.out.print("\nStack after popping top element: " + myStack.toString() + "\n\n");
					break;
				case 3:
					// Creating user prompts to describe stack and calling method to peek the last element
					System.out.print("\nStack before peeking top element: " + myStack.toString());
					System.out.print("\nTop element: " + myStack.peek());
					System.out.print("\nStack after peeking top element: " + myStack.toString() + "\n\n");
					break;
				case 4:
					// Creating user prompts to describe stack and calling method to return the size
					System.out.print("\nStack before checking size: " + myStack.toString());
					System.out.print("\nStack size: " + myStack.size());
					System.out.print("\nStack after checking size" + myStack.toString() + "\n\n");
					break;
				case 5: 
					// Creating user prompts to describe stack and calling method to check if stack is empty
					System.out.print("\nStack before checking empty: " + myStack.toString());
					System.out.print("\nIs stack empty?: " + myStack.isEmpty());
					System.out.print("\nStack after checking empty: " + myStack.toString() + "\n\n");
					break;
				case 6:
					// Creating user prompts to describe stack and calling method to print stack
					System.out.print("\nYour stack: " + myStack.toString() + "\n\n");
			}
		}
		
		input.close();
	}

}
