package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class dualpal {
	public static void main(String[] args) throws IOException {
		

		long start=System.currentTimeMillis();
		Input input = new Input();
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		
		
		int N = input.nextInt(1, 1), S = input.nextInt(1, 2);
		int idx = 0;
		
		while(idx < N) {
			S++;
			if(isPalInNBase(S)) {
				idx ++;
				input.write(S, true);
			}
		}
		
		
		
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
		
	}
	
	static boolean isPalInNBase(int source) {
		int flag = 0;
		for(int i = 2; i<=10; i++) {
			if(palindromes(Integer.toString(source, i))) flag ++;
		}
		return (flag >= 2);
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
