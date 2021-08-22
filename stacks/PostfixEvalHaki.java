// Class:		CS 5040
// Term:		Summer 2021
// Name:		Haki Atalov
// Program Number: Assignment 3 Programming 4
// IDE:			Eclipse

package assignment3;

import java.util.Scanner;

public class PostfixEvalHaki {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Initialize the scanner
		
		System.out.print("Enter a postfix expression: "); // Ask user to enter expression
		
		String expression = input.next(); // Grab the next input as a string
		
		StackHaki<Double> operandStack = new StackHaki<>(); // Initialize the stack with Double data type
		
		boolean validExpressionSyntax = true; // Flag to check if expression contains only 0-9 and accepted operators.
		
		// Loop through the string and act on each character. 
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i); // Grab the character at each index
			
			if (ch >= 48 && ch <= 57) {
				// If 0-9, push to stack as integer
				operandStack.push(Double.parseDouble(String.valueOf(ch)));
			} else if (ch == 42 || ch == 43 || ch == 45 || ch == 47 || ch == 94) {
				
				// If operator, do the operation with the top 2 elements in the stack
				double operand1 = operandStack.pop(); // Temp variable to hold the first element
				double operand2 = operandStack.pop(); // Temp variable to hold the second element
				double result = calc(String.valueOf(ch), operand2, operand1); // Result variable to hold the calculation
				operandStack.push(result); // Push the result to the stack.
			} else {
				// If characters are not 0-9 or accepted operators, flip the flag and break the loop. 
				validExpressionSyntax = false;
				break;
			}
		}
		
		System.out.println("\nEntered expression:\t" + expression); // User prompt to show entered expression
		
		String result = "The input Postfix expression is not valid."; // Set the result string. Default as invalid expression.
		
		// Check valid expression flag before printing result. 
		if (validExpressionSyntax) {
			// Before printing result, check if stack size is 1. If more elements remain in the stack, then the expression was not valid.
			if (operandStack.size() == 1) {
				result = String.valueOf(operandStack.peek()); // Return the string value of the top element without removing the element. 
			}
		} else {
			// If invalid, tell user to only enter valid characters.
			System.out.println("Please only enter 0-9 or ^+-*/");
		}
		
		System.out.println("Result value:\t\t" + result);
		
		input.close();
		
	}
	
	/*
	 * Helper method to calculate the result given an operator and 2 operands. 
	 * The method accepts the operator as a string and the operands as doubles. 
	 * The method implements a switch statement to apply logic for each potential operator. 
	 */
	public static double calc(String operator, double operand2, double operand1) {
		
		double result = 0;
		
		switch (operator) {
			case "^":
				result = Math.pow(operand2, operand1);
				break;
			case "+":
				result = operand2 + operand1;
				break;
			case "-":
				result = operand2 - operand1;
				break;
			case "*":
				result = operand2 * operand1;
				break;
			case "/":
				result = operand2 / operand1;
				break;
		}
		
		return result;
	}

}
