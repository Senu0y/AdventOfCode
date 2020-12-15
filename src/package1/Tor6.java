package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Tor6 {
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("tor6input");
		Scanner scani = new Scanner(input);

		int counter = 0;
		while (scani.hasNextLine()) {

			String s = scani.nextLine();

			HashSet<Character> chars = new HashSet<Character>();

			for (int i = 0; i < s.length(); i++) {
				chars.add(s.charAt(i));
			}
			
			System.out.println(chars.toString());

			while (scani.hasNextLine()) {
				s = scani.nextLine();
				System.out.println(s);
				if (s.isBlank()) {
					break;
				}
				
				for(Iterator<Character> itr= chars.iterator(); itr.hasNext();) {
					char chr=  itr.next();
					if (s.contains(chr+"")) {
						continue;
					}
					itr.remove();
				}
				System.out.println(chars.toString());

			}

			counter += chars.size();
			System.out.println(counter);
			chars.clear();

		}
		System.out.println(counter);

	}
}
