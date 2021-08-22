// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 4 Programming 1
// IDE:			Eclipse

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortHaki {

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
			
			System.out.println("Inputs array before sorting (quick):\t" + Arrays.toString(inputs));
			
			quickSort(inputs); // Call quickSort base method 
			
			System.out.println("Inputs array after sorting (quick):\t" + Arrays.toString(inputs));
			
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

	// QuickSort base method
	public static void quickSort(int[] list) {
		// Call recursive helper method and pass the list + the first and last element to start. 
		quickSort(list, 0, list.length - 1); 
	}

	// QuickSort recursive helper method
	private static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last); // Get the pivot index
			quickSort(list, first, pivotIndex - 1); // Sort left side
			quickSort(list, pivotIndex + 1, last); // Sort right side
		}
	}

	// Partition the array list[first..last]
	private static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) { // Keep going until high index crosses over low index
			/* 
			 * Search forward from left
			 * Keep incrementing low index while the low index is less than high index and
			 * the element at the low index is less than the pivot element. 
			 */
			while (low <= high && list[low] <= pivot) {
				low++;
			}

			/* 
			 * Search backward from right
			 * Keep decrementing the high index while the high index is greater than the low index and
			 * the element at the high index is greater than the pivot element. 
			 */
			while (low <= high && list[high] > pivot) {
				high--;
			}

			// Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		/*
		 * Keep decrementing the high index while it's greater than the first index and
		 * while the element at the high index is greater than the pivot element.
		 */
		while (high > first && list[high] >= pivot) {
			high--;
		}

		// Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

}
