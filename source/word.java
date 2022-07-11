package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class word {
	public static void main(String args[]) throws IOException {
		
		Input input = new Input();
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		int max_len = input.nextInt(1, 2);
		int char_len = input.nextInt(1, 1);
		int sum = 0;
		boolean zuobide = false;
		
		for(int i=0; i<char_len; i++) {
			sum += input.nextString(2, i + 1).length();
			if(i <= max_len - 1) {
				if(sum < max_len - input.nextString(2, i + 2).length() + 1) {
					input.write(input.nextString(2, i + 1), false);
					input.write(" ", false);
				}
			}
			
			if(i > max_len - 1) {
				if(sum < max_len - input.nextString(2, i).length() + 1) {
					input.write(input.nextString(2, i + 1), false);
					if(!zuobide)input.write(" ", false);
				}
			}
			
			if(i == char_len-1) zuobide = true;
			
			if(sum > max_len) {
				i--;
				if(!zuobide) {
					String str = input.nextString(2, i + 1);
					input.write(str, true);
				}
				else {
					input.write("", true);
				}
				sum = 0;
			}
		}
	
	}
}
