package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tor12b {
	static int wpN = 1;
	static int wpE = 10;
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor12input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		
		int[] distance = new int[2];

		for (int i = 0; i < input.length; i++) {
			System.out.println(Arrays.toString(distance));
			int number = Integer.parseInt(input[i].substring(1));
			if (input[i].startsWith("F")) {

				distance[0] += wpN * number;
				distance[1] += wpE * number;
			}

			else if (input[i].startsWith("N")) {
				wpN += number;
			} else if (input[i].startsWith("S")) {
				wpN -= number;
			} else if (input[i].startsWith("E")) {
				wpE += number;
			} else if (input[i].startsWith("W")) {
				wpE -= number;
			}

			else if (input[i].startsWith("R")) {
				direction(number);
			} else if (input[i].startsWith("L")) {
				direction(360 - number);
			}

		}
		System.out.println(Arrays.toString(distance));
		System.out.println(Math.abs(distance[0]) + Math.abs(distance[1]));
	}

	public static void direction(int turn) {// N 0 //E 1		//106860
	//	System.out.println(wpN);
	//	System.out.println(wpE);
	//	System.out.println("turn "+turn);
		double turn1=turn%360;
		
		double rot= turn1/180*Math.PI;
		
		double x= wpE*Math.cos(rot) + wpN*Math.sin(rot);
		double y= -wpE*Math.sin(rot)+ wpN*Math.cos(rot);
	
		wpE=(int) (Math.round(x));
		wpN=(int) (Math.round(y));
	//	System.out.println(wpN);
		//System.out.println(wpE);

		
	}
}
