package source;

import java.io.*;
import java.util.*;

import Train.Input;

/*
ID: wangq
LANG: JAVA
TASK: namenum
*/

public class namenum {
	public static void main(String args[]) throws IOException, InterruptedException {
		long start=System.currentTimeMillis();

		Input input = new Input();
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		Input dict = new Input();
		dict.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\dict.txt";
		
		/*
		 * for(int i=1; i<dict.getFileLineNum(); i++) {
		 * System.out.println(dict.nextString(i, 1)); }
		 */
		
		String ans = input.nextString(1, 1);
		
		char[][] letter_list = new char[ans.split("").length][3];
		
		for(int i=0; i<ans.split("").length; i++) {
			for(int j=0; j<3; j++) {
				char start_letter = (char) ((Integer.parseInt(ans.split("")[i]) - 1) * 3 - 2 + 64 + j);
				letter_list[i][j] = start_letter;
			}
		}
		
		for(int i=0; i<letter_list.length; i++) {
			System.out.println(Arrays.toString(letter_list[i]));
		}
		

		/* 2: A,B,C     5: J,K,L    8: T,U,V
         * 3: D,E,F     6: M,N,O    9: W,X,Y
         * 4: G,H,I     7: P,R,S
		 */
		
		char[] ans1 = new char[] {'a', 'b','c','d'};
		
		permutation(ans1, 0, 0);
				
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	static char[] permutation(char[] ans, int idx1, int idx2) throws InterruptedException{
		if(idx2 >= ans.length - 1) idx1++; idx2 = 0;
		Thread.sleep(1000);
		idx2 ++;
		System.out.println("idx 1: "+(idx1));
		System.out.println("idx 2: "+(idx2));
		if(idx1 != ans.length - 1) return permutation(ans, idx1, idx2);
		else return ans;
	}
	
}
