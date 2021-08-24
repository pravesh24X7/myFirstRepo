import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;


public class sorted_matrix {

	/**
	 * @param item -> {
	 * 			refers to the key that will be deleted from the matrix
	 * 	}
	 * @param arr -> {
	 *			refers to the 2-D array from where the given item is
	 * 		deleted, if present in the matrix else return.
	 * 		time_complexity : O(N*log(N))
	 * 		space_complexity : O(1)
	 * 	}
	 * 
	 **/
	static void delete(Integer[][] arr, Integer item) {
		for (Integer[] one : arr) {
			var top = 0;
			var bottom = one.length - 1;
			int mid_idx = top + (bottom - top) / 2;

			while (top <= bottom) {
				if (Objects.equals(one[mid_idx], item)) {
					one[mid_idx] = Integer.MAX_VALUE;
					Arrays.sort(one);
					return;
				} else if (one[mid_idx] < item) {
					top = mid_idx+1;
				} else {
					bottom = mid_idx-1;
				}
			}
		}
	}

	/**
	 * @param item -> {
	 *			refers to item to be searched in the matrix
	 * 	}
	 * @param arr -> {
	 * 			refers to 2-D array
	 * 		time_complexity : O(N*log(N))
	 * 		space_complexity : O(1)
	 * 	}
	 * 	
	 **/
	static boolean search(Integer[][] arr, Integer item) {
		var result = false;
		for (Integer[] one : arr) {
			if (Arrays.binarySearch(one, item) != -1) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * @param arr -> {
	 * 			refers to 2-D array
	 * 		this function will print the given matrix
	 * 	}
	 * 
	 **/
	static void show(Integer[][] arr) {
		for (Integer[] one : arr) {
			System.out.println(Arrays.toString(one));
		}
	}

	/**
	 * @param arr -> {
	 * 			refers to 2-D array 
	 * 		this function will perform isertion in matrix
	 * 
	 * 		time_complexity : O(N)
	 * 		space_complexity : O(N^2)
	 * 	}
	 * 
	 **/
	static void insert(Integer[][] arr) throws IOException {
		for (var i=0; i<arr.length; i++) {
			if (arr[arr.length-1][arr[i].length-1] != Integer.MAX_VALUE) {
			} else {
				for (var j=arr[i].length-1; j>=0; j--) {
					if (arr[i][j] == Integer.MAX_VALUE) {
						arr[i][j] = Integer.parseInt(input.readLine());
					}
				}
			}
		}
	}

	/**@param arr -> {
	 * 			refers to 2-D array
	 * 		this function will fill the whole matrix with 
	 * 		parameter Integer.MAX_VALUE
	 *  }
	 * 
	 **/
	static void fillUp(Integer[][] arr) {
		for (Integer[] one : arr) {
			Arrays.fill(one, Integer.MAX_VALUE);
		}
	}

	/** static Object to take input-output in program from console
	 **/
	static BufferedReader input = new BufferedReader
			(new InputStreamReader(System.in));

	/**
	 * Driver Code main function
	 **/
	public static void main(String[] args) throws IOException
	{ 	
		Integer[][] arr = new Integer[Integer.parseInt(input.readLine
			())][Integer.parseInt(input.readLine())];

		fillUp(arr);
		insert(arr);
		show(arr);
		System.out.println(search(arr, Integer.parseInt(input.readLine())));
		delete(arr, Integer.parseInt(input.readLine()));
		show(arr);

		input.close();
	}

}