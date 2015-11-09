package alberto.examples.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * KnapSackSolver
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version 1.0
 * @since Nov 6, 2015
 *
 */
public class KnapSackSolverDP {

    private ValueWeight[] items;
    private int totalWeight;
    private final int[][] dpMatrix;
    private final List<ValueWeight> results;

    /**
     * Represents main
     *
     * @param args
     * @since Nov 6, 2015
     *
     */
    public static void main(final String args[]) {
	final ValueWeight[] items = new ValueWeight[17];
	items[0] = new ValueWeight(20, 2);
	items[1] = new ValueWeight(30, 3);
	items[2] = new ValueWeight(40, 4);
	items[3] = new ValueWeight(50, 5);
	items[4] = new ValueWeight(60, 6);
	items[5] = new ValueWeight(70, 9);
	items[6] = new ValueWeight(75, 11);
	items[7] = new ValueWeight(85, 13);
	items[8] = new ValueWeight(90, 14);
	items[9] = new ValueWeight(100, 10);
	items[10] = new ValueWeight(110, 20);
	items[11] = new ValueWeight(130, 50);
	items[12] = new ValueWeight(132, 60);
	items[13] = new ValueWeight(140, 65);
	items[14] = new ValueWeight(180, 1);
	items[15] = new ValueWeight(185, 2);
	items[16] = new ValueWeight(189, 3);

	final int sackMaximumWeight = 190;

	final KnapSackSolverDP solver = new KnapSackSolverDP(items, sackMaximumWeight);

	System.out.printf("Total item weight is %d\n", solver.obtainTotalItemsWeight());
	System.out.printf("Maximum weight capacity %d\n", sackMaximumWeight);
	System.out.printf("Maximum possible profit is %d\n", solver.solve());
	System.out.printf("One optimal solution is to take items %s", solver.getSolution());
    }

    /**
     * Represents getResultsIndexes
     *
     * @return
     * @since Nov 7, 2015
     *
     */
    private String getSolution() {
	int itemCombinedWeight = 0;
	final StringBuilder result = new StringBuilder("");
	for (int i= 0; i<results.size(); i++) {
	    result.append(i+1).append(": (").append(results.get(i).getValue()).append(", ").append(results.get(i).getWeight()).append(") ");
	    itemCombinedWeight+=results.get(i).getWeight();
	}
	return result.append("=> ").append(itemCombinedWeight).toString();
    }

    /**
     * Represents obtainTotalItemsWeight
     *
     * @return int
     * @since Nov 7, 2015
     *
     */
    public int obtainTotalItemsWeight() {
	int total = 0;
	for (final ValueWeight vw : items) {
	    total += vw.getWeight();
	}
	return total;
    }

    /**
     * Constructs an instance of KnapSackSolver object.
     *
     * @param param
     * @param param2
     */
    public KnapSackSolverDP(final ValueWeight[] param, final int param2) {
	super();
	setItems(param);
	setTotalWeight(param2);
	dpMatrix = new int[items.length][totalWeight + 1];
	results = new ArrayList<>();

    }

    /**
     * Represents solve
     *
     * @return int
     * @since Nov 6, 2015
     *
     */
    public int solve() {

	// for each item
	for (int i = 0; i < items.length; i++) {

	    // for each possible total weight
	    for (int j = 0; j <= totalWeight; j++) {
		if (items[i].getWeight() <= j) {
		    dpMatrix[i][j] = Math.max(getNewBestSolution(i, j), getCurrentBestSolution(i, j));
		} else {
		    dpMatrix[i][j] = getCurrentBestSolution(i, j);
		}
	    }
	}
	setResultItems();

	return dpMatrix[items.length - 1][totalWeight];
    }

    /**
     * Represents setResultItems
     *
     * @since Nov 7, 2015
     *
     */
    private void setResultItems() {
	// Assume we finished our dpMatrix, start in the bottom-right corner
	int row = items.length - 1;
	int col = totalWeight;
	while (row > 0) {
	    if (dpMatrix[row][col] > dpMatrix[row - 1][col]) {
		results.add(items[row]);
		col -= items[row].getWeight();
	    }
	    row--;
	}
	if ((col-items[0].getWeight()) > 0) {
	    results.add(items[0]);
	}
    }

    /**
     * Represents getCurrentBestSolution
     *
     * @param i
     * @param j
     * @return
     * @since Nov 6, 2015
     *
     */
    private int getCurrentBestSolution(final int i, final int j) {
	int result = 0;

	if (((i - 1) >= 0) && (j >= 0)) {
	    result = dpMatrix[i - 1][j];
	}

	return result;

    }

    /**
     * Represents getNewBestSolution
     *
     * @param i
     * @param j
     * @return
     * @since Nov 6, 2015
     *
     */
    private int getNewBestSolution(final int i, final int j) {
	// if under the first row
	int result = items[i].getValue();
	if ((i - 1) >= 0) {
	    if ((j - items[i].getWeight()) >= 0) {
		result = items[i].getValue() + dpMatrix[i - 1][j - items[i].getWeight()];
	    } else {
		result = items[i].getValue();
	    }
	}
	return result;
    }

    /**
     * Represents printDpMatrix
     *
     * @since Nov 6, 2015
     *
     */
    public void printDpMatrix() {
	for (int i = 0; i < dpMatrix.length; i++) {
	    for (int j = 0; j < dpMatrix[i].length; j++) {
		System.out.print(dpMatrix[i][j] + "\t");
	    }
	    System.out.println();
	}
    }

    /**
     * @return the items
     */
    public ValueWeight[] getItems() {
	return items;
    }

    /**
     * @param param
     *            the items to set
     */
    public void setItems(final ValueWeight[] param) {
	this.items = param;
    }

    private static class ValueWeight {
	private int value;
	private int weight;

	/**
	 * Constructs an instance of ValueWeight object.
	 *
	 * @param v
	 * @param w
	 */
	public ValueWeight(final int v, final int w) {
	    super();
	    setValue(v);
	    setWeight(w);

	}

	public int getValue() {
	    return value;
	}

	/**
	 * @param param
	 *            the value to set
	 */
	public void setValue(final int param) {
	    this.value = param;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
	    return weight;
	}

	/**
	 * @param param
	 *            the weight to set
	 */
	public void setWeight(final int param) {
	    this.weight = param;
	}
    }

    /**
     * @return the totalWeight
     */
    public int getTotalWeight() {
	return totalWeight;
    }

    /**
     * @param param
     *            the totalWeight to set
     */
    public void setTotalWeight(final int param) {
	this.totalWeight = param;
    }

}
