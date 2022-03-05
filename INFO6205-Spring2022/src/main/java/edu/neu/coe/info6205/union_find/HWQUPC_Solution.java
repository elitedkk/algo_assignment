package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {
	public static void main(String[] args) throws Exception
    {
        if (args.length > 0) {
        	int sites = Integer.parseInt(args[0]);
        	if(sites < 0 ) {
        		throw new Exception("Negative number of sites");
        	}
        	System.out.println("NUMBER OF SITES = " + Integer.toString(sites));
        	int iter = 100;
        	double total = 0;
        	for (int i = 0; i < iter; i++) {
        		total = total + count(sites);
        	}
        	double avg = total/iter;
        	System.out.println("Average number of pairs = " + Double.toString(avg));
        }
        else
            System.out.println("Inadquate arguments");
    }
	
	private static double count(int n) {
		UF_HWQUPC sol = new UF_HWQUPC(n);
		int m = 0;
		while (sol.components() != 1) {
			//System.out.println("Number of components are = " + sol.components());
			int i1 = getRandomNumber(0,n);
			int i2 = getRandomNumber(0,n);
			//System.out.println("Connecting " + Integer.toString(i1) + " and " + Integer.toString(i2));
			sol.connect(i1, i2);
			m++;
		}
		//System.out.println("The number of pairs generated = " + Integer.toString(m));
		return m;
	}
	
	private static int getRandomNumber(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
}
