// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 4 Programming 2
// IDE:			Eclipse

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RadixSortHaki {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		boolean runProgram = true; // Initializing boolean to control program level sentinel loop
		
		while (runProgram) { // Sentinel while loop to control re-running the program based on user input Y/N
		
			// Grabbing the number of students
			System.out.print("How many integer numbers do you have? ");
			int inputSize = input.nextInt();
	
			// Initializing array to capture grades
			int[] inputs = new int[inputSize];
	
			// Getting all the grades from the user - looping through for inputs
			System.out.print("Enter " + inputs.length + " integer numbers: ");
			for (int i = 0; i < inputs.length; i++) {
				inputs[i] = input.nextInt();
			}
			
			System.out.println("------------------------------------------------------");
			
			System.out.println("Inputs array before sorting (radix):\t" + Arrays.toString(inputs));
			
			radixSort(inputs); // Call radixSort method 
			
			System.out.println("Inputs array after sorting (radix):\t" + Arrays.toString(inputs));
			
			/* 
			 * Sentinel loop retry logic
			 */
			
			System.out.print("\n\nDo you want to re-run code with different inputs (Y/N): "); // Request retry input
			
			String retry = ""; // Initialize retry String
			
			/* 
			 * Sentinel loop to ensure user enters Y or N
			 * The loop runs as long as the input is not Y or N to force the user to enter a valid input. 
			 */
			
			while (!retry.equals("Y") && !retry.equals("N")) {
				retry = input.next().toUpperCase(); // Capture retry input, Y or N
				
				if (retry.equals("N")) { // First check if input is N 
					runProgram = false; // If N, set sentinel negative value for program iteration
					System.out.println("Program Terminated"); // Print program terminated message
					break; // Break loop. Technically not needed for this simple program.  
				} else if (retry.equals("Y")) { // Then check if Y so we can add spacer if user will retry. 
					System.out.println("");
				} else { // All other inputs will re-run the loop and request a valid input
					System.out.print("Please enter only Y or N: "); // Tell user to enter Y or N
				}
			}
		}
		
		input.close();

	}
	
	/*
	 * Method to perform a radix sort on a given list.
	 * Uses various data structures to modify the given list.
	 */
	public static void radixSort(int[] list) {
		
		// Initialize a List of Queues that acts like the bucket list.
		ArrayList<Queue<Integer>> bucketList = new ArrayList<Queue<Integer>>();

	    // Add 10 empty Queues to the List. One Queue/bucket for integers 0-9.
		for (int i = 0; i < 10; i++) {
	    	bucketList.add(new Queue<Integer>());
	    }
		
		int max = getMax(list); // Get the greatest Integer in the given list.
		int lengthOfMax = getDigitCount(max); // Get the length of the greatest integer in the given list.
		
		for (int k = 0; k < lengthOfMax; k++) { // Perform the sorting algorithm K times for the length of the largest Integer in the given list.  
			for (int number : list) { // For each number in the given list.
				
				/*
				 * Check if the length of the current number is less than or equal to the length of the largest number. 
				 * Check if the length of the current number is greater than the current iteration of the sort.
				 * If this is false, it means the current number does not have remaining digits and belongs to bucket 0.
				 */
				if (getDigitCount(number) <= lengthOfMax && getDigitCount(number) > k) {
					int digit = extractDigit(number).get(k); // Extract all the digits into a list and grab the required digit based on the pass iteration.
					bucketList.get(digit).enqueue(number); // Add the number to the proper Queue using the current focus digit as the index of the list of Queues.  
				} else {
					// Capture numbers without remaining digits and place them in bucket 0
					bucketList.get(0).enqueue(number);
				}
			}
			
			ArrayList<Integer> tempList = new ArrayList<Integer>(); // Initialize an empty List to capture all of the sorted elements in the Queues.
			
			// Loop through the List of Queues and act on each Queue
			for (Queue<Integer> bucket: bucketList) {
				/*
				 * While the Queue has elements, add the top element to the temp List
				 * and then remove the top element of the Queue. 
				 */
				while (!bucket.isEmpty()) {
					tempList.add(bucket.front());
					bucket.dequeue();
				}
			}
			
			// Update the given array with the sorted values from the temp List.
			for (int i = 0; i < list.length; i++) {
				list[i] = tempList.get(i);
			}
		}	
		
	}
	
	/*
	 * Method to get the max integer in the array.
	 * Accepts the array as an input parameter. 
	 */
	public static int getMax(int[] list) {
        
		int max = list[0]; // Set the first item as the initial max. 
        
		/*
		 * Loop through the array and check each element against the current max. 
		 * If the current element is greater than the current max, set the current element as the current max. 
		 */
		for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
	
	/*
	 * Method to get the number of digits in an Integer.
	 */
	public static int getDigitCount(int number) {
		
		int length = 0; // Length counter
		
		/*
		 * Temp variable with a length of 1.
		 * Initialized as a double to ensure the temp variable can store a number larger than the largest possible Integer
		 */
		double temp = 1;
		
		// Loop to increment the length of the give number. 
		while (temp <= number) {
		    length++; // Increment length of the given number
		    temp *= 10; // Multiply the temp value by 10 to increase the length of the comparator by 1. 
		}
		return length;
	}
	
	/*
	 * Method to extract the digits of an Integer into a list.
	 * Returns the list of digits in the reverse order.
	 */
	public static ArrayList<Integer> extractDigit(int number) {
		
		ArrayList<Integer> digitList = new ArrayList<Integer>(); // Initialize List to store the digits. 
		
		/*
		 * Loop to add each digit to the List. 
		 * Keeps dividing the number by 10 and storing the remainder in the List. 
		 * Continues while the number is greater than 0.
		 */
		while (number > 0) {
			digitList.add(number % 10); // Grab the remainder of the current number divided by 10. This returns the last digit in the number.
			number = number / 10; // Actually divide the number. Will return an Integer value without the decimal. 
		}
		
		return digitList;
	}

}
