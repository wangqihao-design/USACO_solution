/*
ID: wangq
LANG: JAVA
TASK: transform
*/

package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class transform {

	public static void main(String args[]) throws IOException {
		long start=System.currentTimeMillis();

		Input input = new Input();
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		int N = input.nextInt(1, 1);
		
		String[][] pattern = new String[N][N];
		String[][] require = new String[N][N];
		
		for(int i=0; i<N; i++) {
			pattern[i] = input.next(i + 2).split("");
			require[i] = input.next(i + 2 + N).split("");
		}

		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(pattern[i]));
		}
		System.out.println("=====================");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(require[i]));
		}
						
		int type = 0;
		
		if(equals(Rotate90(pattern),require)) {System.out.println("transformation type : " + 1); type = 1;}
		else if(equals(Rotate180(pattern),require)) {System.out.println("transformation type : " + 2); type = 2;}
		else if(equals(Rotate270(pattern),require)) {System.out.println("transformation type : " + 3); type = 3;}
		else if(equals(reflect(pattern),require)) {System.out.println("transformation type : " + 4); type = 4;}
		else if((equals(combination(pattern, 0),require))||(equals(combination(pattern, 1),require))||(equals(combination(pattern, 2),require))) {System.out.println("transformation type : " + 5); type = 5;}
		else if(equals(pattern, require)) {System.out.println("transformation type : " + 6);  type = 6;}
		else {System.out.println("transformation type : " + 7); type = 7;}
		
		input.write(type, true);
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	static String[][] Rotate270(String[][] patterns) {
		String[][] copy = new String[patterns.length][patterns.length];
		for(int i=0; i<patterns.length; i++) {
			for(int j=0; j<patterns.length; j++) {
				copy[i][j] = patterns[j][patterns.length - i - 1];
			}
		}
		return copy;
	}
	static String[][] Rotate90(String[][] patterns) {
		String[][] copy = new String[patterns.length][patterns.length];
		for(int i=0; i<patterns.length; i++) {
			for(int j=0; j<patterns.length; j++) {
				copy[i][patterns.length - 1- j] = patterns[j][i];
			}
		}
		return copy;
	}
	static String[][] Rotate180(String[][] patterns) {
		patterns = Rotate90(patterns);
		patterns = Rotate90(patterns);		
		return patterns;
	}
	
	static String[][] reflect(String[][] patterns){
		String[][] copy = new String[patterns.length][patterns.length];
		for(int i = 0; i<patterns.length; i++) {
			int right = patterns.length - 1;
			for(int left = 0; left<patterns.length; left++) {
				if(left <= right) {
					copy[i][left] = patterns[i][right];
					copy[i][right] = patterns[i][left];
					right--;
				}
			}
		}
		return copy;
	}
	
	static String[][] combination(String[][] patterns, int type){
		patterns = reflect(patterns);
		if(type == 0){
			patterns = Rotate90(patterns);
			return patterns;
		}
		if(type == 1){
			patterns = Rotate180(patterns);
			return patterns;		
		}
		if(type == 2){
			patterns = Rotate270(patterns);
			return patterns;
		}
		return new String[0][0];
	}
	
	static boolean equals(String[][] arr1, String[][] arr2) {

		for (int i = 0; i < arr1.length; i++) {
			if (!Arrays.equals(arr1[i], arr2[i])) {
				return false;
			}
		}
		return true;
	}
	
}
