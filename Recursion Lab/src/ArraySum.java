/**
 * Recursive Lab - sum the values in an array of integers
 * @author Sai Abhishek Gangineni
 *
 */
public class ArraySum {

	/**
	 * Recursive method to sum the values in an array of integers
	 * @param a the integer of arrays
	 * @param index the number in the array to summed next
	 * @return sum - the sum of values in array
	 */
	public int sumOfArray(Integer[] a, int index) {
		if (index < 0) {
			return 0;
		}
		return sumOfArray(a, index-1) + a[index];
	}
}
