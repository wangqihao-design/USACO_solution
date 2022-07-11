package source;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import Train.Input;

public class gymnastics {
	public static void main(String args[]) throws IOException {
		
		Input input = new Input();
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		
		int k = input.nextInt(1, 2);
		int n = input.nextInt(1, 1);
		int ans = 0;
		int number = 0;
		int minus = 0;
		ArrayList<String> minusList = new ArrayList();
		
		ArrayList<String> betterArr = new ArrayList();
		
		for(int i =1; i<n+1; i++) {
			for(int l=1; l<k; l++) {
				for(int j=l; j<k; j++) {
					int[] betterInfo = new int[]{input.nextInt(i+1, l), input.nextInt(i+1, j+1)};
					if((!minusList.contains(Arrays.toString(reverse(betterInfo)))) && (!minusList.contains(Arrays.toString(betterInfo))) && betterArr.contains(Arrays.toString(reverse(betterInfo)))){
						minusList.add(Arrays.toString(betterInfo));
						System.out.println(Arrays.toString(betterInfo));
					}
					if(!betterArr.contains(Arrays.toString(betterInfo)) && !betterArr.contains(Arrays.toString(reverse(betterInfo)))) {
						betterArr.add(Arrays.toString(betterInfo));
					}
				}
			}
		}
		System.out.println((betterArr.toString()));
		input.write(betterArr.size() + minus, true);
	}
	static int[] reverse(int[] source){
		int tmp = source[0];
		source[0] = source[1];
		source[1] = tmp;
		return source;
	}
}
