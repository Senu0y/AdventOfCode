package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor3 {

	public static void main(String[] args) throws FileNotFoundException {

		int slopey = 1;
		int slopex = 1;

		File input= new File("tor3input");
		
		Scanner scani = new Scanner(input);
		int counter=0;
		
		int curser=0;
		
		while(scani.hasNextLine()) {
			String s =scani.nextLine();
			if(s.charAt(curser)=='#') {
				counter++;
			}
			curser= (curser +slopex)% s.length();
			if(scani.hasNextLine()) {
			scani.nextLine();
			}
			
		}
		
		
		while(scani.hasNextLine()) {
			String s =scani.nextLine();
			if(s.charAt(curser)=='#') {
				counter++;
			}
			curser= (curser +slopex)% s.length();
			if(scani.hasNextLine()) {
			scani.nextLine();
			}
			
		}
		System.out.println(counter);
		
	}

}
