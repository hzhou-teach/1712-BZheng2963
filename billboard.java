
/*
Bill Zheng
 */

import java.io.*;
import java.util.*;

public class billboard {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("billboard.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int[] a = new int[4]; //first billboard
		int[] b = new int[4]; //second billboard
		int[] c = new int[4]; //truck
		for (int i = 0; i < 4; i++) {
			a[i] = scan.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			b[i] = scan.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			c[i] = scan.nextInt();
		}
//--------------------------------------------------------------------------------------------------------------------------
		int totalarea = Math.abs(a[2]-a[0])*Math.abs(a[3]-a[1]) + Math.abs(b[2]-b[0])*Math.abs(b[3]-b[1]);
//--------------------------------------------------------------------------------------------------------------------------
		int rightedge1 = Math.min(a[2], c[2]); //edges of intersected rectangle between billboard 1 and truck
		int leftedge1 = Math.max(a[0], c[0]);
		int topedge1 = Math.min(a[3], c[3]);
		int botedge1 = Math.max(a[1], c[1]);

		if (rightedge1 > leftedge1 && topedge1 > botedge1) { //checks to see if the rectangle is a valid rectangle
			totalarea -= Math.abs(rightedge1-leftedge1)*Math.abs(topedge1-botedge1);
		}
//--------------------------------------------------------------------------------------------------------------------------
		int rightedge2 = Math.min(b[2], c[2]); //edges of intersected rectangle between billboard 2 and truck
		int leftedge2 = Math.max(b[0], c[0]);
		int topedge2 = Math.min(b[3], c[3]);
		int botedge2 = Math.max(b[1], c[1]);
		
		if (rightedge2 > leftedge2 && topedge2 > botedge2) { //checks to see if the rectangle is a valid rectangle
			totalarea -= Math.abs(rightedge2-leftedge2)*Math.abs(topedge2-botedge2);
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		out.println(totalarea);
		out.close();
		scan.close();
	}
}
