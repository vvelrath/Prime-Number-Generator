package primegen;

/**
* This class implements the methods required for a Prime Number Generator
*
* @author  Vivekanandh Vel Rathinam
* @version 1.0
* @since   02/11/2015
*/

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

	/*Returns the list of prime numbers in the given range*/
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		
		//Making sure that startingValue < endingValue
		if(startingValue > endingValue) return generate(endingValue, startingValue);
		
		//The lowest prime number in a range can be 2
		if(startingValue < 2) startingValue = 2;
		
		//An ordered List of prime numbers in range 
		List<Integer> primeNumbersInRange = new ArrayList<Integer>();
		
		for(int num = startingValue; num <= endingValue; num++){
			if(isPrime(num)) primeNumbersInRange.add(num); 
		}
		
		return primeNumbersInRange;	
	}

	/*Checks if the given value is a prime number*/
	@Override
	public boolean isPrime(int value) {
		
		//Lowest prime number is 2
		if(value < 2) return false;
		
		for(int num = 2; num <= Math.sqrt(value); num++){
			if(value % num == 0) return false;
		}
		
		return true;
	}

}
