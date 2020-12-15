package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Tor10b {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("tor10input");
		Scanner scani = new Scanner(file);

		String[] input = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < input.length; i++) {
			set.add(Integer.parseInt(input[i]));
		}

		
		long[] dp=new long[Collections.max(set)+1];
		
		dp[0]=1;
		if(set.contains(1)) {
			dp[1]=1;
		}
		if(set.contains(2)) {
			dp[2]=dp[1]+1;
		}
		for (int i = 3; i < Collections.max(set) + 1; i++) {
			
			if(set.contains(i)) {
				dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
			}
			
			
		}
		
		System.out.println(dp[dp.length-1]);
		

	}
}
