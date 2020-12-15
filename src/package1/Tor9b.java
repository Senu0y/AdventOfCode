package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Tor9b {
	public static void main(String[] args) throws FileNotFoundException {

		// 85848519
		File file = new File("tor9input");
		Scanner scani = new Scanner(file);

		String[] inputfirst = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		ArrayList<Long> input = new ArrayList<Long>();
		for (int i = 0; i < inputfirst.length; i++) {
			input.add(i, Long.parseLong((inputfirst[i])));
		}

		for (int i = 0; i < input.size(); i++) {
			
			for (int j = 0; j < input.size(); j++) { // wie gross
				int sum=0;
				ArrayList<Long> sums= new ArrayList<Long>();
				for (int j2 = i; j2 < j; j2++) {
					
					sums.add(input.get(j2));
					sum+=input.get(j2);
					
				}
				//System.out.println(sum);
				if(sum== 85848519) {
					
					
					System.out.println(Collections.min(sums)+Collections.max(sums));
					break;
				}
			}
			
		}
		System.out.println("fertig");

	}
}
