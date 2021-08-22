// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 3 Programming 3
// IDE:			Eclipse

package assignment3;

import java.util.Scanner;

public class TestPalindromeHaki {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Initialize scanner
		
		System.out.print("Enter a string: "); // Prompt user to enter a string
		
		String string = input.nextLine(); // Grab the next line including spaces
		String string1 = ""; // Temp variable to store the sanitized string
		String string2 = ""; // Temp variable to store the string backwards. 
		
		string1 = string.replace((" "), ""); // Get rid of spaces.
		string1 = string1.toUpperCase(); // Set to upper case to ignore case.
		
		StackHaki<Character> charStack = new StackHaki<>(); // Initialize the stack
		
		// Loop through the string and push the characters to the stack
		for (int i = 0; i < string1.length(); i++) {
			charStack.push(string1.charAt(i));
		}
		
		// Iterate through the stack and create the backwards string.
		while (!charStack.isEmpty()) {
			// Build the backwards string by concatenating the top character from the stack to the string on each iteration.
			string2 = string2 + charStack.pop();
		}
		
		System.out.println("Input string:\t" + string);
		
		String returnString; // Temp variable to hold the return string.
		
		// Check if the sanitized string equals the reverse string and set the return string appropriate.
		if (string1.equals(string2)) {
			returnString = "Palindrome";
		} else {
			returnString = "Not Palindrome";
		}
		
		System.out.println("Judgment:\t" + returnString); // print the judgment  
		
		input.close();
		

	}

}
