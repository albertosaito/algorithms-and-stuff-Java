package com.alberto.tinkering.algorithms;

/**
 * Swap2Ints
 *
 * @author <a href="mailto:nobuj_000@gmail.com">nobuj_000</a>
 * @version $Id$
 * @since Oct 3, 2015
 *
 */
public class Swap2Ints {

    /**
     * Swaps 2 ints without using auxiliar variables using bit XOR function
     *
     * @param args
     * @since Oct 3, 2015
     *
     */
    public static void main(final String args[]) {
	int a = 5;
	int b = 7;
	System.out.printf("A = %d; B = %d\n", a, b);
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	System.out.printf("A = %d; B = %d\n", a, b);
    }

}
