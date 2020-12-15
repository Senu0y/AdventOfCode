package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tor12 {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor12input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		int direction = 3;
		int[] distance = new int[2];

		for (int i = 0; i < input.length; i++) {
			System.out.println(Arrays.toString(distance));
			int number = Integer.parseInt(input[i].substring(1));
			if (input[i].startsWith("F")) {
				if (direction == 0) {
					distance[0] += number;
				} else if (direction == 1) {
					distance[1] += number;
				} else if (direction == 2) {
					distance[0] -= number;
				} else if (direction == 3) {
					distance[1] -= number;
				}

			} else if (input[i].startsWith("N")) {
				distance[0] -= number;
			} else if (input[i].startsWith("W")) {
				distance[1] -= number;
			} else if (input[i].startsWith("S")) {
				distance[0] += number;
			} else if (input[i].startsWith("E")) {
				distance[1] += number;
			} else if (input[i].startsWith("R")) {
				direction = direction(direction, number);
			} else if (input[i].startsWith("L")) {
				direction = direction(direction, 180 + number);
			}
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(Math.abs(distance[0]) + Math.abs(distance[1]));
	}

	static int direction(int dir, int turn) {// N 0 //E 1

		return (dir + (turn / 90)) % 4;
	}
}
