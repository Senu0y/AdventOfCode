package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Tor22 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Tor22input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("Player 2:");

		String[] player1 = input[0].split("\\n");
		String[] player2 = input[1].split("\\n");
		System.out.println(Arrays.toString(player1));
		LinkedList<Integer> p1 = new LinkedList<Integer>();
		LinkedList<Integer> p2 = new LinkedList<Integer>();
		for (int i = 1; i < player2.length; i++) {

			p1.add(Integer.parseInt(player1[i].strip()));
			p2.add(Integer.parseInt(player2[i].strip()));
		}

		System.out.println(p1.toString());
		System.out.println(p2.toString());

		while (!p1.isEmpty() && !p2.isEmpty()) {

			if (p1.getFirst() < p2.getFirst()) {

				p2.addLast(p2.removeFirst());
				p2.addLast(p1.removeFirst());
			} else {
				p1.add(p1.removeFirst());
				p1.add(p2.removeFirst());
			}
		}
		Long result = 0l;
		if (p1.isEmpty()) {

			for (int i = 1; i < p2.size()+1; i++) {
				System.out.println(p2.get(p2.size()-i) * i);
				result += p2.get(p2.size()-i) * i;
			}
		} else {
			System.out.println("hier");
			for (int i = 1; i < p1.size()+1; i++) {
				result += p1.get(p1.size()-i) * i;
			}
		}
		System.out.println(result);
		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}
}
