package primegen;

/**
* This interface specifies the methods to be 
* implemented by prime number generator classes
*
* @author  Vivekanandh Vel Rathinam
* @version 1.0
* @since   02/11/2015
*/

import java.util.List;

public interface PrimeNumberGenerator {
	List<Integer> generate(int startingValue, int endingValue);
	boolean isPrime(int value);
}