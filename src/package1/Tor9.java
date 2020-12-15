package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Tor9 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("tor9input");
		Scanner scani = new Scanner(file);

		String[] inputfirst = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		ArrayList<Long> input = new ArrayList<Long>();
		for (int i = 0; i < inputfirst.length; i++) {
			input.add(i, Long.parseLong((inputfirst[i])));
		}

		LinkedList<Long> first25 = new LinkedList<Long>();
		for (int j = 0; j < 25; j++) {
			first25.addLast((input.get(j)));
		}

		for (int i = 25; i < inputfirst.length; i++) {
			// System.out.println(first25.toString());
			boolean hasSum = false;
			
			for (Long longi : first25) {
				for (Long longi2 : first25) {
					
					if(longi !=longi2) {
						if ((longi + longi2) == input.get(i)) {
							hasSum = true;
							System.out.println(longi +" "+longi2 +" = "+input.get(i));
						}
					}
					
				}
			}
			if (hasSum) {
				first25.removeFirst();
				first25.addLast(input.get(i));
			} else {
				System.out.println("hier " + input.get(i));
				break;
			}
		}
	}

}
