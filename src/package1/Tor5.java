package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor5 {

	public static void main(String[] args) throws FileNotFoundException {

		File input = new File("tor5input");
		Scanner scani = new Scanner(input);
		int maxID = 0;
		boolean[] maxIDbol= new boolean[980+1];
		while (scani.hasNextLine()) {
			
			int low = 0;
			int high = 127;
			
			int right = 7;
			int left = 0;
			
			String s = scani.nextLine();

			for (int i = 0; i < 7; i++) {

				int[] spec = helper(low, high, s.charAt(i));
				low = spec[0];
				high = spec[1];

			}
			// s System.out.println(low);

			for (int i = 7; i < 10; i++) {

				int[] spec = helper2(left, right, s.charAt(i));
				left = spec[0];
				right = spec[1];
			}
			// System.out.println(left);

			
				maxID = low * 8 + left;
			maxIDbol[maxID]=true;
		
			//System.out.println(maxID);
		}
		
		for (int i =200; i < maxIDbol.length-200; i++) {
			if((maxIDbol[i]==false)&&(maxIDbol[i-1]==true)&&(maxIDbol[i+1]==true)) {
				System.out.println(i);
			}
		}

	}

	public static int[] helper2(int left, int right, char direction) {
		int left1 = left;
		int right1 = right;

		if (direction == 'R') {
			left1 = left + (right - left) / 2 + 1;
		}
		if (direction == 'L') {
			right1 = left + (right - left) / 2;
		}

		return new int[] { left1, right1 };
	}

	public static int[] helper(int low, int high, char direction) {
		int high1 = high;
		int low1 = low;

		if (direction == 'B') {
			low1 = low + (high - low) / 2 + 1;
		}
		if (direction == 'F') {
			high1 = low + (high - low) / 2;
		}

		// System.out.println("h " + high1);
		// System.out.println("l " + low1);
		return new int[] { low1, high1 };
	}
}
