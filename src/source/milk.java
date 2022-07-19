package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class milk {
	public static void main(String[] args) throws IOException {
		long start=System.currentTimeMillis();


		Input input = new Input();
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		int needed = input.nextInt(1, 1), farmer = input.nextInt(1, 2);
		
		int[][] milkFarm = new int[farmer][];
		
		BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in"));
		r.readLine();
		
		
		for(int i=0; i<farmer; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			int[] temp = new int[2];
			temp[0] = (Integer.valueOf(st.nextToken()));
			temp[1] = (Integer.valueOf(st.nextToken()));
			milkFarm[i] = temp;
		}
		r.close();
		
		milkFarm = sort(milkFarm);
		
		
		int milkPurchased = 0, moneyspent = 0, i = 0;
		
		while(milkPurchased < needed) {
			milkPurchased += milkFarm[i][1];
			moneyspent += milkFarm[i][0] * milkFarm[i][1];
			i++;
		}
		
		if(i == 0) input.write(0, true);
		else input.write(moneyspent - (milkPurchased - needed) * milkFarm[i - 1][0], true);

				
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	public static int[][] sort(int[][] arr) {
		int N = arr.length;
		int h = 1;
		while(h<N/3) h = h * 3 + 1;
		while(h>= 1) {
			for(int i=h; i<N;i++) {
				for(int j=i;j>=h;j-=h) {
					if(arr[j-1][0]>arr[j][0]) {
						int[] tmp = arr[j];
						arr[j] = arr[j-h];
						arr[j-h] = tmp;
					}
				}
			}
			h = h/3;
		}
		return arr;
	}

}
