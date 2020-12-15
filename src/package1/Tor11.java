package package1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Tor11 {

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
		String[] input=inputfirst.clone();
		while (changed) {
			String[] current=input.clone();
			
			for (int i = 0; i < input.length; i++) {
				System.out.println(input[i]);
			}
			System.out.println(counter);
			counter++;
			changed = false;
			System.out.println("loop");
			for (int i = 0; i < input.length; i++) {

				for (int j = 0; j < input[0].length(); j++) {

					if (input[i].charAt(j) == 'L') {

						if (nextAdjacent(j, i, input) == 0) {
							current[i] = replacer(j, i, current);
							changed = true;
						}

						continue;

					} else if (input[i].charAt(j) == '#') {

						if (nextAdjacent(j, i, input) >= 4) {
							current[i] = replacertoL(j, i, current);
							changed = true;
						}

					}
				}

			}
			input =current.clone();
		}

		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

		int counter2=0;
		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[0].length(); j++) {

				if (input[i].charAt(j) == '#') {
					counter2++;
				}
			}
		}
		System.out.println("c "+counter);
		System.out.println(counter2);
		System.out.println(input[0].length());

	}

	static int nextAdjacent(int index, int line, String[] input) {
		// System.out.println("adj");
		int counter = 0;

		if (input[line].length() > index + 1 && input[line].charAt(index + 1) == '#') { // rechts
			counter++;
		}
		if (0 <= index - 1 && input[line].charAt(index - 1) == '#') { // links
			counter++;
		}
		if (input.length > line + 1 && input[line + 1].charAt(index) == '#') {// unten
			counter++;
		}
		if (0 <= line - 1 && input[line - 1].charAt(index) == '#') {// oben
			counter++;
		}
		if (input[line].length() > index + 1 && (input.length > line + 1 && input[line + 1].charAt(index + 1) == '#')) {// unten
																														// rechts
			counter++;
		}
		if (0 <= index - 1 && (input.length > line + 1 && input[line + 1].charAt(index - 1) == '#')) {// unten links
			counter++;
		}
		if (input[line].length() > index + 1 && (0 <= line - 1 && input[line - 1].charAt(index + 1) == '#')) {// oben
																												// rechts
			counter++;
		}
		if (0 <= index - 1 && (0 <= line - 1 && input[line - 1].charAt(index - 1) == '#')) {// oben links
			counter++;
		}

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
