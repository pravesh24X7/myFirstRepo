package files_of_java;

import java.util.Scanner;
import java.util.Arrays;

public class MaxWaterLevel {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] waterLevels = new int[input.nextInt()];

		for (int i=0; i<waterLevels.length; i++) waterLevels[i] = input.nextInt();
		func(waterLevels);
		input.close();
	}

	static void func(int[] wl) {
		System.out.print(solve(wl));
	}

	static int solve(int[] wl) {
		int[] la = new int[wl.length];
		int[] ra = new int[wl.length];

		la[0] = wl[0];
		ra[wl.length-1] = wl[wl.length-1];

		for (int i=1; i<wl.length; i++) {
			if (la[i-1] < wl[i]) {
				la[i] = wl[i];
			} else la[i] = la[i-1];
		}

		for (int i=wl.length-2; i>=0; i--) {
			if (ra[i+1] < wl[i]) {
				ra[i] = wl[i];
			} else ra[i] = ra[i+1];
		}

		int ans = Integer.MAX_VALUE;
		int check = Integer.MIN_VALUE;
		for (int i=0; i<wl.length; i++) {
			ans = Integer.min(la[i], ra[i]) - wl[i];
			check = Integer.max(la[i], ra[i]) - wl[i];
		}
	
		System.out.println(check);
		return ans;
	}

}
