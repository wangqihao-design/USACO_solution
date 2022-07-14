package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class palsquare {
	public static void main(String[] args) throws IOException {
		

		long start=System.currentTimeMillis();
		Input input = new Input();
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		int bs = input.nextInt(1, 1);
		
		System.out.println("================ ");
		
		String max = Integer.toString(300, bs);
		
		for(int base = 1; base < 300; base ++) {
			String square = pow(Integer.toString(base, bs), bs);
			if(palindromes(square)) {
				System.out.println("base   | " + Integer.toString(base, bs).toUpperCase() + "	|");
				System.out.println("square | " + String.valueOf(square).toUpperCase() + "	|");
				System.out.println("================");
				input.write(Integer.toString(base, bs).toUpperCase(), false);
				input.write(" ", false);
				input.write(String.valueOf(square).toUpperCase(), true);
			}
		}
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	static String pow(String num, int base) {
		return (Integer.toString((Integer.parseInt(num, base) * Integer.parseInt(num, base)), base));
	}
	
	static boolean palindromes(String square) {
		String num = square;
		
		int left = 0, right = num.length() - 1;
		boolean isPal = true;
		
		while(left <= right) {
			isPal = isPal && (num.charAt(left) == num.charAt(right));
			left++; right--;
		}
		
		return isPal;
	}
	

}
