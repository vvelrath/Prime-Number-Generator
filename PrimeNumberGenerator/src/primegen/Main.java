package primegen;

import java.util.List;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import primegen.test.PrimeNumberGeneratorImplTest;

/**
* The main program is a startup program to 
* generate prime numbers within a given range.
*
* @author  Vivekanandh Vel Rathinam
* @version 1.0
* @since   02/11/2015
*/

public class Main {

	static Scanner scan = null;
	static String option = null;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
			
		while(true){
			System.out.println("Enter any one of the following options:");
			System.out.println("a) Press 1 to find prime numbers within a range");
			System.out.println("b) Press 2 to check all the test cases for this program");
			System.out.println("c) Press 3 to exit the program");
			
			option = scan.next().trim();
			
			switch(option){
				case "1":
					runPrimeNumberGenerator();
					break;
				case "2":
					runTestCases();
					break;
				case "3":
					runExit();
					break;
				default:
					System.out.println("\n"+"\""+option +"\""+ " is not a valid option\n");
					break;
			}			
		}
		
	}//end main


	//Get input from user and generate prime numbers
	private static void runPrimeNumberGenerator() {
		//Local variables
		String start = null;
		String end = null;
		List<Integer> primeNumbersInRange = null;
		
		//Prime number generator instance
		PrimeNumberGenerator primegen = new PrimeNumberGeneratorImpl();
		
		//Reading the starting value of the range from user
		System.out.println();
		do{
			System.out.print("Please enter the starting value of the range in (Integer): ");
			start = scan.next();
		}while(!isInteger(start));
		
		//Reading the ending value of the range from user
		do{
			System.out.print("Please enter the ending value of the range in (Integer): ");
			end = scan.next();
			System.out.println();
		}while(!isInteger(end));
		
		primeNumbersInRange = primegen.generate(Integer.parseInt(start), Integer.parseInt(end));
	
		//Printing the prime numbers between the given range
		System.out.println("Prime numbers between " + start + " and " + end + " are: ");
		System.out.print("{ ");
		
		for(int i = 0; i < primeNumbersInRange.size(); i++){
			System.out.print(primeNumbersInRange.get(i)+" ");
		}
		
		System.out.print("}");
		System.out.print("\n\n");
	
	}//end func

	
	//Run all the test cases
	private static void runTestCases() {
		
		//Running the test cases from the PrimeNumberGeneratorImplTest class
		Result result = JUnitCore.runClasses(PrimeNumberGeneratorImplTest.class);
	    
		if(result.wasSuccessful()){
			System.out.println("\nSuccess: All 6 of 6 test cases passed\n");
		}else{
			System.out.println();
			for (Failure failure : result.getFailures()) {
			      System.out.println(failure.toString());
			}
			System.out.println();
		}
	}//end func
	
	
	//Exiting the program gracefully
	private static void runExit() {
		System.out.println("\nThank you for using my program to generate prime numbers");
		scan.close();
		System.exit(0);
	}//end func
	
	
	//Checks if a string is an integer
	private static boolean isInteger(String str) {
	    try { 
	        Integer.parseInt(str); 
	    } catch(NumberFormatException e) {
	    	return false; 
	    }
	    return true;
	}//end func

}