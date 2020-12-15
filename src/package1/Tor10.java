package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Tor10 {

	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("tor10input");
		Scanner scani = new Scanner(file);

		String[] input = scani.useDelimiter("\\A").next().split("\n");

		HashSet<Integer> set= new HashSet<Integer>();
		
		for (int i = 0; i < input.length; i++) {
			set.add(Integer.parseInt(input[i]));
		}
		
		int counter1=0;
		int counter3=0;
		int lastindex=0;
		
		
		for (int i = 0; i < Collections.max(set)+1; i++) {
			
			if(set.contains(i)) {
				if(i-lastindex==1) {
					counter1++;
				}
				else if(i-lastindex==3) {
					counter3++;
				}
				else {
					System.out.println("fehler sollte n icht hier seijn");
				}
				
				lastindex=i;
				
			}
			
			
		}
		System.out.println( counter1);
		System.out.println(counter3);
		System.out.println(counter1*(counter3+1));
		
	}
}
