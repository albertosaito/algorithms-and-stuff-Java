package com.alberto.tinkering.algorithms;

/**
 * LongestSubsequenceDP
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Nov 3, 2015
 *
 */
public class LongestSubsequenceDP {

    /**
     * Represents main
     *
     * @param args
     * @since Nov 3, 2015
     *
     */
    public static void main(final String args[]) {

	final int[] numbers = {16,3,5,19,10,14,12,0,15};
	System.out.println(longestSubsequenceSize(numbers));

    }

    /**
     * Represents longestSubsequenceSize
     *
     * @param seq
     * @return int
     * @since Nov 3, 2015
     *
     */
    public static int longestSubsequenceSize(final int[] seq) {
	final int[] states = new int[seq.length];
	states[0] = 1;
	for (int i = 1; i < states.length; i++) {
	    int maxn = 0;
	    for (int j = 0; j < i; j++) {
		if ((seq[j] < seq[i]) && (states[j] > maxn)) {
		    maxn = states[j];
		}
	    }
	    states[i] = maxn + 1;
	}
	return (states[seq.length-1]);
    }

}
