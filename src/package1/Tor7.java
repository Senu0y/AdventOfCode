package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Tor7 {

	public static void main(String[] args) throws FileNotFoundException {

		HashSet<String> vorhanden = new HashSet<String>();
		int counter = 0;

		for (int i = 0; i < 15; i++) {
			
		
		File input = new File("tor7input");
		Scanner scani = new Scanner(input);

		Scanner scaniline;

		while (scani.hasNextLine()) {
			String s = scani.nextLine();
			// System.out.println(s);
			scaniline = new Scanner(s);
			String name = scaniline.next() + " " + scaniline.next();
			scaniline.next();
			scaniline.next();

			String restLine = scaniline.next();
			//System.out.println(restLine);

			while (scaniline.hasNext()) {
				restLine = restLine + " " + scaniline.next();
			}
			System.out.println(restLine);
			
			if (restLine.contains("shiny gold")) {
				vorhanden.add(name);
				counter++;
			}

			HashSet<String> tempo = new HashSet<String>();
			for (Iterator<String> itr = vorhanden.iterator(); itr.hasNext();) {
				String str = itr.next();
				if (restLine.contains(str)) {		
					tempo.add(name);
					counter++;
					
				}
			}
			vorhanden.addAll(tempo);
			tempo.clear();
			
		}

		}
		
		
		
		System.out.println(vorhanden.size());

	}

}
