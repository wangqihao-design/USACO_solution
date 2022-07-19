package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class whereami {
	public static void main(String args[]) throws IOException {
		
		Input input = new Input();
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		int light_len = input.nextInt(1, 1);
		String lights = input.nextString(2, 1);
		
		ArrayList<CharSequence> sequenceList = new ArrayList<CharSequence>();
		
		int ans = 0;
		int max_window = 0;
		
		for(int i=0; i<light_len/2; i++) {
			for(int window = i+1; window<light_len/2 + 2; window ++) {
				sequenceList.add(lights.subSequence(i, window+i));
				System.out.println(lights.subSequence(i, window+i));
				
				String copy = lights.replaceFirst(lights.substring(i, window+i), "");
				System.out.println(copy);
				
				if(copy.contains(lights.subSequence(i, window+i))) {
					System.out.println(window+1);
					if(max_window < window) max_window = window;
					ans = max_window+1;
				}
			}
		}
		input.write(ans, true);
	}
	
	
	
	/* String a 
	 * for(int i=0; i<length; i++){
	 * 	String a = [0:i];
	 * 	for(int j=0; j<length; j++{
	 * 		if(list[s.length] == a) not 
	 * 		else yes
	 * }
	 */
}
