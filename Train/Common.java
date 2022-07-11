package Train;

import java.lang.reflect.Array;
import java.util.*;

public class Common {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2};
		System.out.println();
	}
	
	public static List<?> swap(List<?> arr, int a, int b) {
		Collections.swap(arr, a, b);
		arr.toArray();
		return arr;
	}
	public static void print2DArray(Object[][] arr) {
	    for(int i = 0; i < arr.length; i++) {
	        System.out.print(Arrays.toString(arr[i]));
	    }
		
	}
}
