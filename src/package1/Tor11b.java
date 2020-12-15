package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor11b {
	public static void main(String[] args) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		File file = new File("tor11input");
		Scanner scani = new Scanner(file);
		String[] inputfirst = scani.useDelimiter("\\A").next().split("\n");
		scani.close();

		System.out.println(inputfirst[0].length());
		boolean changed = true;
		;
		int counter = 0;
		String[] input = inputfirst.clone();
		while (changed) {
			String[] current = input.clone();
		/*	for (int i = 0; i < input.length; i++) {
				System.out.println(input[i]);
			}
			System.out.println(counter);*/
			changed = false;
			counter++;
			for (int i = 0; i < input.length; i++) {

				for (int j = 0; j < input[0].length(); j++) {

					if (input[i].charAt(j) == 'L') {

						if (nextAdjacent(j, i, input) == 0) {
							current[i] = replacer(j, i, current);
							changed = true;
						}

						continue;

					} else if (input[i].charAt(j) == '#') {

						if (nextAdjacent(j, i, input) >= 5) {
							current[i] = replacertoL(j, i, current);
							changed = true;
						}

					}
				}

			}
			input = current.clone();
		}

		/*
		 * for (int i = 0; i < input.length; i++) { System.out.println(input[i]); }
		 */

		int counter2 = 0;
		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[0].length(); j++) {

				if (input[i].charAt(j) == '#') {
					counter2++;
				}
			}
		}

		System.out.println(counter2);
	//	System.out.println(input[0].length());

	}

	static int nextAdjacent(int index, int line, String[] input) {
		// System.out.println("adj");
		int counter = 0;

		int r = 0;
		do {
			r++;
			if (input[line].length() > index + r && input[line].charAt(index + r) == '#') { // rechts
				counter++;
				break;
			}
			
		} while (input[line].length() > index + r && input[line].charAt(index + r) == '.');

		int l = 0;
		do {
			l--;
			if (0 <= index + l && input[line].charAt(index + l) == '#') { // links
				counter++;
				break;
			}
			
		} while (0 <= index + l && input[line].charAt(index + l) == '.');

		int u = 0;
		do {
			u++;
			if (input.length > line + u && input[line + u].charAt(index) == '#') {// unten
				counter++;
				break;
			}
			
		} while (input.length > line + u && input[line + u].charAt(index) == '.');

		int o = 0;
		do {
			o--;
			if (0 <= line + o && input[line + o].charAt(index) == '#') {// oben
				counter++;
				break;
			}
			
		} while (0 <= line + o && input[line + o].charAt(index) == '.');

		int ur = 0;
		do {
			ur++;
			if (input[line].length() > index + ur
					&& (input.length > line + ur && input[line + ur].charAt(index + ur) == '#')) {// unten
				// rechts
				counter++;
				break;
			}
			
		} while ((input[line].length() > index + ur && (input.length > line + ur))
				&& input[line + ur].charAt(index + ur) == '.');

		int ul = 0;
		do {
			ul++;
			if (0 <= index - ul && (input.length > line + ul && input[line + ul].charAt(index - ul) == '#')) {// unten
																												// links
				counter++;
				break;
			}
			
		} while ((0 <= index - ul && input.length > line + ul) && input[line + ul].charAt(index - ul) == '.');

		int or = 0;
		do {
			or++;
			if (input[line].length() > index + or && (0 <= line - or && input[line - or].charAt(index + or) == '#')) {// oben
																														// rechts
				counter++;
				break;
			}
			
		} while ((input[line].length() > index + or && 0 <= line - or) && input[line - or].charAt(index + or) == '.');

		int ol = 0;
		do {
			ol++;
			if (0 <= index - ol && (0 <= line - ol && input[line - ol].charAt(index - ol) == '#')) {// oben links
				counter++;
				break;
			}
			
		} while ((0 <= index - ol && 0 <= line - ol) && input[line - ol].charAt(index - ol) == '.');
	//	System.out.print(counter + " ");
		return counter;
	}

	static String replacer(int index, int line, String[] input) {

		return input[line].substring(0, index) + input[line].substring(index, index + 1).replace('L', '#')
				+ input[line].substring(index + 1);

	}

	static String replacertoL(int index, int line, String[] input) {

		return input[line].substring(0, index) + input[line].substring(index, index + 1).replace('#', 'L')
				+ input[line].substring(index + 1);

	}
}
