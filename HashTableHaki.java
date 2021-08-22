// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 5 Programming 1
// IDE:			Eclipse

package assignment5;

import java.util.Scanner;

public class HashTableHaki {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Initialize scanner. 
		
		boolean runProgram = true; // Initializing boolean to control program level sentinel loop
		
		while (runProgram) { // Sentinel while loop to control re-running the program based on user input.
		
			// Initializing set of unique keys
			int[] keys = { 1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
		               5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
		               5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
		               5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
		               5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523 };
			
			// Initializing empty hash table
			int[][] table = new int[50][2];
			
			// Constructing main prompt
			System.out.print("----------Main Menu----------\n" + 
								"0 - Exit Program\n" +
								"1 - Run HF1 (Division with Linear Probing)\n" + 
								"2 - Run HF2 (Division with Quadratic Probing)\n" + 
								"3 - Run HF3 (Division with Double Hashing) (Top)\n" + 
								"4 - Run HF4 (Student-Designed Function)\n" + 
								"Select Option: ");
			
			int option = input.nextInt(); // Grabbing user input
			
			/*
			 * Switch statement that, depending on the input, will call each hash function
			 * and call a method to print the resulting hash table.
			 */
			switch (option) { // Switch to react to user input
			case 0:
				// Exit the program and set the sentinel variable to false to stop the loop. 
				System.out.println("\nThank you for using the Hash Table Test Program.");
				runProgram = false;
				break;
			case 1:
				System.out.print("\n");
				HF1(keys, table, table.length);
				System.out.println("Hash table resulted from HF1:\n");
				displayTable(table);
				break;
			case 2: 
				System.out.print("\n");
				HF2(keys, table, table.length);
				System.out.println("Hash table resulted from HF2:\n");
				displayTable(table);
				break;
			case 3:
				System.out.print("\n");
				HF3(keys, table, table.length);
				System.out.print("\n");
				System.out.println("Hash table resulted from HF3:\n");
				displayTable(table);
				break;
			case 4:
				System.out.print("\n");
				HF4(keys, table, table.length);
				System.out.print("\n");
				System.out.println("Hash table resulted from HF4:\n");
				displayTable(table);
				break;
			}
			
		}
		
		input.close();

	}
	
	/*
	 * Explanation of a pattern within each Hash Function.
	 * 
	 * For each Hash Function, first comes a check if the calculated index is occupied. 
	 * If not, the data is inserted at that index. 
	 * If occupied, each has function implements a loop with M (table size) iterations. 
	 * For each iteration, the index is modified according to the collision resolution
	 * and then Mod M applied to implement the circular array.   
	 */
	
	public static void HF1(int[] keys, int[][] table, int m) {
		
		// Loop through all the keys
		for (int i = 0; i < m; i++) {
			
			int index = keys[i] % m; // Apply hash function
			int numOfProbes = 0;
			
			// Check if index is empty
			if (table[index][0] == 0) {
				
				// Insert
				table[index][0] = keys[i];
				table[index][1] = 0;
			} else {
				
				/*
				 * if not empty, iterate M times and apply circular array technique.
				 * Do not need to iterate to end of table and then apply Mod M technique. 
				 * For indexes less than table size, this method will return that index as remainder. 
				 * Once index exceeds table size, the Mod M method will return a remainder starting with 0. 
				 * This will continue M times until the iteration completes at the base calculated index.
				 */
				for (int j = 0; j < table.length; j++) {
					if (table[(index + j) % m][0] == 0) { // Check if collision resolution index is empty
						
						// Insert
						table[(index + j) % m][0] = keys[i];
						table[(index + j) % m][1] = numOfProbes;
						break;
					}
					numOfProbes = j; // Number of probes is number of iterations before data is inserted.
				}
			}
				
		}
	}
	
	public static void HF2(int[] keys, int[][] table, int m) {
		
		// Loop through all the keys
		for (int i = 0; i < m; i++) {
			
			int index = keys[i] % m; // Apply hash function
			int numOfProbes = 0;
			
			// Check if index is empty
			if (table[index][0] == 0) {
				
				// Insert
				table[index][0] = keys[i];
				table[index][1] = 0;
			} else {
				
				/*
				 * if not empty, iterate M times and apply circular array technique.
				 * Do not need to iterate to end of table and then apply Mod M technique. 
				 * For indexes less than table size, this method will return that index as remainder. 
				 * Once index exceeds table size, the Mod M method will return a remainder starting with 0. 
				 * This will continue M times until the iteration completes at the base calculated index.
				 */
				for (int j = 0; j < table.length; j++) {
					if (table[(index + (int) Math.pow(j, 2)) % m][0] == 0) { // Check if collision resolution index is empty
						
						// Insert
						table[(index + (int) Math.pow(j, 2)) % m][0] = keys[i];
						table[(index + (int) Math.pow(j, 2)) % m][1] = numOfProbes;
						break;
					}
					numOfProbes = j; // Number of probes is number of iterations before data is inserted.
				}
			}
				
		}
		
	}
	
	public static void HF3(int[] keys, int[][] table, int m) {
		
		// Loop through all the keys
		for (int i = 0; i < m; i++) {
			
			int index = keys[i] % m; // Apply hash function
			int numOfProbes = 0;
			boolean inserted = false; // Is inserted flag to catch orphaned keys
			
			// Check if index is empty
			if (table[index][0] == 0) {
				
				// Insert
				table[index][0] = keys[i];
				table[index][1] = 0;
				inserted = true;
			} else {
				
				/*
				 * if not empty, iterate M times and apply circular array technique.
				 * Do not need to iterate to end of table and then apply Mod M technique. 
				 * For indexes less than table size, this method will return that index as remainder. 
				 * Once index exceeds table size, the Mod M method will return a remainder starting with 0. 
				 * This will continue M times until the iteration completes at the base calculated index.
				 */
				for (int j = 0; j < table.length; j++) {
					if (table[(index + j * (30 - keys[i] % 25)) % m][0] == 0) { // Check if collision resolution index is empty
						
						// Insert
						table[(index + j * (30 - keys[i] % 25)) % m][0] = keys[i];
						table[(index + j * (30 - keys[i] % 25)) % m][1] = numOfProbes;
						inserted = true;
						break;
					}
					numOfProbes = j; // Number of probes is number of iterations before data is inserted.
				}
			}
			
			// If key cannot be placed, print message for key
			if (!inserted) {
				System.out.println("Unable to store key " + keys[i] + " to the table.");
			}
	
		}
	}
	
	public static void HF4(int[] keys, int[][] table, int m) {
		
		// Loop through all the keys
		for (int i = 0; i < m; i++) {
			
			/*
			 *  Apply hash function.
			 *  Has function here is based on multiplicative hashing. 
			 *  I decided to try opposite of division hashing. 
			 */
			int index = (int) Math.floor(m * (keys[i] * 0.618033 % 1));
			int numOfProbes = 0;
			boolean inserted = false; // Is inserted flag to catch orphaned keys
			
			// Check if index is empty
			if (table[index][0] == 0) {
				
				// Insert
				table[index][0] = keys[i];
				table[index][1] = 0;
				inserted = true;
			} else {
				
				/*
				 * if not empty, iterate M times and apply circular array technique.
				 * Do not need to iterate to end of table and then apply Mod M technique. 
				 * For indexes less than table size, this method will return that index as remainder. 
				 * Once index exceeds table size, the Mod M method will return a remainder starting with 0. 
				 * This will continue M times until the iteration completes at the base calculated index.
				 */
				for (int j = 0; j < table.length; j++) {
					/*
					 * Check if collision resolution index is empty.
					 * Collision resolution is based on double hashing.  
					 */
					if (table[(index + j * (25 - keys[i] % 25)) % m][0] == 0) {
						
						// Insert
						table[(index + j * (25 - keys[i] % 25)) % m][0] = keys[i];
						table[(index + j * (25 - keys[i] % 25)) % m][1] = numOfProbes;
						inserted = true;
						break;
					}
					numOfProbes = j; // Number of probes is number of iterations before data is inserted.
				}
			}
			
			// If key cannot be placed, print message for key
			if (!inserted) {
				System.out.println("Unable to store key " + keys[i] + " to the table.");
			}
	
		}
	}
	
	/*
	 * Method that iterates through table and adds all probes.  
	 */
	
	public static int sumProbes(int[][] table) {
		
		int probes = 0;
		
		for (int i = 0; i < table.length; i++) {
			
			probes = probes + table[i][1];
		}
		return probes;
	}
	
	/*
	 * Method to print the resulting table
	 */
	
	public static void displayTable(int[][] table) {
		
		System.out.println("Index\t\tKey\t\tProbes");
		System.out.println("--------------------------------------");
		for (int i = 0; i < table.length; i++) {
			
			System.out.println(i + "\t\t" + table[i][0] + "\t\t" + table[i][1]);
		}
		System.out.println("--------------------------------------");
		System.out.println("Sum of probe values = " + sumProbes(table) + " probes."); 
		System.out.print("\n");
	}

}
