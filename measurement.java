
/*
Bill Zheng
 */

import java.io.*;
import java.util.*;

public class measurement {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("measurement.in"));
//------------------------------Inputs--------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[][] log = new int[N][3]; //creating log with day, name, and change
		for (int i = 0; i < N; i++) { //inputting all values
			log[i][0] = scan.nextInt(); //day
			String name = scan.next(); //name which corresponds to a number in the int array
			if (name.equals("Bessie")) log[i][1] = 1;
			if (name.equals("Elsie")) log[i][1] = 2;
			if (name.equals("Mildred")) log[i][1] = 3;
			log[i][2] = scan.nextInt(); //change
		}
//--------------------------------------------------------------------------------------------------------------------------
		ArrayList<String> display = new ArrayList<String>(); //a string display that can change fluidly
		display.add("B"); display.add("E"); display.add("M"); //at the start all cows are on display
		int b = 7; int e = 7; int m = 7;
//--------------------------------------------------------------------------------------------------------------------------
		int earliest = Integer.MAX_VALUE;
		int index = -1;
		int ret = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			earliest = Integer.MAX_VALUE; //starts from the max value and we're looking to become a min, or earliest day in log
			for (int j = 0; j < N; j++) {
				if (log[j][0] < earliest) {
					earliest = Math.min(earliest, log[j][0]);
					index = j; //keeps track of which input it is
				}
			}
			log[index][0] = Integer.MAX_VALUE; //sets day to not interfere with remaining days in log
			
			if (log[index][1] == 1) { //adjusts values for cows as necessary
				b += log[index][2];
			} else if (log[index][1] == 2) {
				e += log[index][2];
			} else {
				m += log[index][2];
			}
			
			int mostmilk = Math.max(b, Math.max(e, m)); //sees the highest value of milk
			count = 0; //this keeps track of IF the display changes
			
			//adjusting display and keeping track of if it changes
			if (b == mostmilk) {
				if (!display.contains("Bessie")) {
					display.add("Bessie");
					count++;
				}
			} else {
				if (display.contains("Bessie")) {
					display.remove("Bessie");
					count++;
				}
			}
			if (e == mostmilk) {
				if (!display.contains("Elsie")) {
					display.add("Elsie");
					count++;
				}
			} else {
				if (display.contains("Elsie")) {
					display.remove("Elsie");
					count++;
				}
			}
			if (m == mostmilk) {
				if (!display.contains("Mildred")) {
					display.add("Mildred");
					count++;
				}
			} else {
				if (display.contains("Mildred")) {
					display.remove("Mildred");
					count++;
				}
			}
			//if the display changed at least once, the return value (ret) will increase by 1
			if (count > 0) ret ++;
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		out.println(ret);

		out.close();
		scan.close();
	}
}
