package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tor13 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("tor13input");
		Scanner scani = new Scanner(file);

		int timestamp = scani.nextInt();
		scani.nextLine();
		String[] buslines = scani.nextLine().split(",");
		System.out.println(Arrays.toString(buslines));
		int counterstep = Integer.parseInt(buslines[0]);
		//int counterstep = buslines.length;
		long counter = 825305207525400l;
					//825305207525452
					// 923468884334109
					
		
		 

	//	int last=Integer.parseInt(buslines[buslines.length-1]);
		System.out.println(buslines[77]);
		while (true) {
				if((counter %523)!=-17%523) {//17
				counter +=counterstep;
				continue;
			}
			if((counter %787)!=-48%787) {//48
				counter +=counterstep;
				continue;
			}
			/*if((counter %13)!=35) {
				counter +=counterstep;
				continue;
			}*/
			System.out.println(counter);
			boolean istrue = true;
			for (int i = 0; i < buslines.length; i++) {
				if (buslines[i].equals("x")) {
					continue;
				} else {

					int busline = Integer.parseInt(buslines[i]);

					if (!drivesAt(counter + i, busline)) {
						istrue = false;
						break;
					}

				}

			}
			if (istrue) {
				System.out.println(counter);
				break;
			}
			counter ++;//= counterstep;
		}
		System.out.println("fertig");

	}

	static boolean drivesAt(long time, int bus) {
		if (time % bus == 0) {
			return true;
		} else
			return false;

	}
}
