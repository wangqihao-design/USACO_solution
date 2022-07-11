/*
ID: wangq
LANG: JAVA
TASK: beads
*/

package source;

import Train.Input;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.*;

public class beads {
	public static void main(String args[]) throws IOException {
		Input input = new Input();
		input.FilePath ="beads.in";
		input.WritePath = "beads.out";
		
		String beads = input.nextString(2, 1);
		int bead_length = input.nextInt(1, 1);
		
		
		String[] cbeads = new String[beads.length() * 2];
		
		
		for(int i=0; i<beads.length();i++) {
			cbeads[i] = Character.toString(beads.charAt(i));
			cbeads[i + beads.length()] = Character.toString(beads.charAt(i));
		}
		String[] d1 = dye(Arrays.copyOfRange(cbeads, 0, bead_length), true);
		String[] d2 = dye(Arrays.copyOfRange(cbeads, bead_length, 2 * bead_length), false);
		
		String[] died = new String[bead_length * 2];
		
		for(int i=0; i<bead_length; i++) {
			died[i] = d1[i];
			died[i + bead_length] = d2[i];
		}

		
		if(died[0].equals("w") && (Arrays.toString(died).contains("b")||Arrays.toString(died).contains("r"))) {
			int j = 0;
			while(died[j].equals("w")) {
				j++;
			}
			died[0] = died[j];
		}
		System.out.println(Arrays.toString(died));
		
		if(!checkData(died)) input.write(died.length / 2, true);
		
		if(checkData(died)) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			String init = died[0];

			int left = 0;
			int right = 0;
			
			for(int i=0; i<died.length - 1; i++) {
				right ++;
				if(died[right].equals(other(init))) {
					init = other(init);
					int continuous = right - left;
					left = right;
					ans.add(continuous);
				}
			}
			
			System.out.println(ans.toString());
			
			int[] num = new int[ans.size() - 1];
			for(int i=0; i<ans.size() - 1; i++) {
				num[i] = ans.get(i) + ans.get(i + 1);
			}
			Arrays.sort(num);
			System.out.println(Arrays.toString(num));

			if(num[num.length-1] < bead_length) input.write(num[num.length-1], true);
			else input.write(bead_length, false);
		}
	}
	
	static String other(String a) {
		if(a == "r") return "b";
		else return "r";
	}
	
	static String[] dye(String[] bead, boolean mode) {
		if(mode) {
			for(int i=bead.length - 2; i>0 ;i--) {
				if(bead[i].equals("w")) {
					bead[i] = bead[i + 1];
				}
			}
			return bead;
		}
		else {
			for(int i=0; i>bead.length - 1 ;i++) {
				if(bead[i].equals("w")) {
					bead[i] = bead[i - 1];
				}
			}
			return bead;
		}
	}
	static boolean checkData(String[] source) {
		if(Arrays.toString(source).contains("r") && Arrays.toString(source).contains("b")) return true;
		else return false;
	}
}



