package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Train.Input;

public class namenum2 {
	public static void main(String[] args) throws IOException {
		long start=System.currentTimeMillis();
		Input input = new Input();
		/*
		 * 2: A,B,C 5: J,K,L 8: T,U,V 
		 * 3: D,E,F 6: M,N,O 9: W,X,Y 
		 * 4: G,H,I 7: P,R,S
		 */
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";

		String num = input.nextString(1, 1);
		String[] name = new String[4617];
		
		Input dict = new Input();
		dict.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\dict.txt";
		BufferedReader r = new BufferedReader(new FileReader(dict.FilePath));
		
		for(int i=0; i<4617; i++) {
			String token = r.readLine();
			name[i] = token;
		}
		r.close();
		
		List<String> ans = new ArrayList<String>();
		String[] copy = name;
				
		for(int i=0; i<num.length(); i++) {

			String[] req = getCharNum(Integer.parseInt(String.valueOf(num.charAt(i))));
			copy = window(req, copy, i);
			System.out.println(Arrays.toString(getCharNum(Integer.parseInt(String.valueOf(num.charAt(i))))));
			System.out.println(Arrays.toString(copy));
			System.out.println("____________________");
		}
		
		for(int i=0; i<copy.length; i++) {
			if(copy[i].length() == num.length()) input.write(copy[i], true);
		}
		if(copy.length == 0) input.write("NONE", true);
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	static String[] window(String[] a, String[] b, int c) {
		int i = 0;
		List<String> res = new ArrayList<String>();
		while(i < b.length) {
			
			if(b[i].length() > c) {
				if(contains(String.valueOf(b[i].charAt(c)), a)) { 
					res.add(b[i]);
				}
			}
			i++;
		}

		return ObjToStr(res.toArray());
	}
	
	static String[] ObjToStr(Object[] objectArr) {
		String[] strArr = new String[objectArr.length];

		for(int i = 0 ; i < objectArr.length; i ++){  
			strArr[i] = objectArr[i].toString();
		}
		return strArr;
			      
	}
	
	static boolean contains(String a, String[] b) {
		for(int i=0; i<b.length; i++) {
			if(b[i].equals(a)) 
				return true;
		}
		return false;
	}
	
	static char StrToChar(String a) {
		return a.charAt(0);
	}
	
	static String[] getCharNum(int num) {
		if(num == 2) return new String[] {"A", "B", "C"};
		if(num == 3) return new String[] {"D", "E", "F"};
		if(num == 4) return new String[] {"G", "H", "I"};
		if(num == 5) return new String[] {"J", "K", "L"};
		if(num == 6) return new String[] {"M", "N", "O"};
		if(num == 7) return new String[] {"P", "R", "S"};
		if(num == 8) return new String[] {"T", "U", "V"};
		if(num == 9) return new String[] {"W", "X", "Y"};
		return null;
	}
	
}