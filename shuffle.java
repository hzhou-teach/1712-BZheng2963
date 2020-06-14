
/*
Bill Zheng
 */

import java.io.*;
import java.util.*;

public class shuffle {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("shuffle.in"));
//-------------------------Reading input------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] swap = new int[N];
		int[] cows = new int[N];
		int[] cows2 = new int[N];
		for (int i = 0; i < N; i++) {
			swap[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			cows[i] = scan.nextInt();
			cows2[i] = cows[i];
		}
//--------------------------------------------------------------------------------------------------------------------------
		//reverse swap 3 times
		for (int j = 0; j < N; j++) {
			//whatever cow is at swap[j]-1 should be at j position
			cows2[j] = cows[swap[j]-1];
		}
		for (int j = 0; j < N; j++) {
			//whatever cow is at swap[j]-1 should be at j position
			cows[j] = cows2[swap[j]-1];
		}
		for (int j = 0; j < N; j++) {
			//whatever cow is at swap[j]-1 should be at j position
			cows2[j] = cows[swap[j]-1];
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		for (int i = 0; i < N; i++) {
			out.println(cows2[i]);
		}
		out.close();
		scan.close();
	}
}
