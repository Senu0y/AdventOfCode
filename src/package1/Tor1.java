package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tor1 {

	public static void main(String[] args) throws FileNotFoundException {

		File text = new File("tor1text");
		ArrayList<Integer> zahlen = new ArrayList<Integer>();

		Scanner scani = new Scanner(text);

		while (scani.hasNext()) {

			zahlen.add(scani.nextInt());
		}

		for (int i = 0; i < zahlen.size(); i++) {

			for (int j = 0; j < zahlen.size() - 1; j++) {
				for (int j2 = 0; j2 < zahlen.size()-2; j2++) {

					if ((zahlen.get(i) + zahlen.get(j) + zahlen.get(j2) == 2020)) {
						System.out.println(zahlen.get(i) * zahlen.get(j) * zahlen.get(j2));
					}
				}

			}
		}
		System.out.println("hää");
	}
}
