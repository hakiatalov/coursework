// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 2 Programming 1
// IDE:			Eclipse

package assignment2;

import java.util.Scanner;

public class ListTestHaki {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		LinkedListHaki<Integer> myList = new LinkedListHaki<Integer>();		
		
		boolean runProgram = true; // Initializing boolean to control program level sentinel loop
		
		while (runProgram) { // Sentinel while loop to control re-running the program based on user input Y/N
		
			// Constructing main prompt
			System.out.print("----------Linked List Test Program----------\n" + 
								"0 - Exit Program\n" +
								"1 - Add First Node\n" + 
								"2 - Add Last Node\n" + 
								"3 - Add at Index\n" + 
								"4 - Remove First Node\n" + 
								"5 - Remove Last Node\n" + 
								"6 - Remove at Index\n" + 
								"7 - Print List Size\n" +
								"Select Option: ");
			
			int option = input.nextInt(); // Grabbing user input
			int element; // initializing element input
			int index; // initializing index input
			
			switch (option) { // Switch to react to user input
				case 0:
					// Exit the program and set the sentinel variable to false to stop the loop. 
					System.out.println("\nThank you for using the Linked List Test Program.");
					System.out.println("Your list:" + myList.toString());
					System.out.print("\n");
					runProgram = false;
					break;
				case 1:
					// Grab the integer the user wants to add and call the method to add the first element.
					System.out.print("\nEnter element to add (integer): ");
					element = input.nextInt();
					myList.addFirst(element);
					break;
				case 2: 
					// Grab the integer the user wants to add and call the method to add the last element.
					System.out.print("\nEnter element to add (integer): ");
					element = input.nextInt();
					myList.addLast(element);
					break;
				case 3:
					// Grab the index and integer the user wants to add and call the method to add the element at the index.
					System.out.print("\nEnter index (integer): ");
					index = input.nextInt();
					System.out.print("Enter element to add (integer): ");
					element = input.nextInt();
					myList.add(index, element);
					break;
				case 4:
					myList.removeFirst();
					break;
				case 5: 
					myList.removeLast();
					break;
				case 6:
					// Grab the index and call the method to remove the element at that index. 
					System.out.print("\nEnter index (integer): ");
					index = input.nextInt();
					myList.remove(index);
					break;
				case 7: 
					System.out.println("\nThe list size is: " + myList.size());
					System.out.print("\n");
					break;
			}
		}
		
		input.close();
	}

}
