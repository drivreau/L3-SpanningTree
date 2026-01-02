package alg;


import java.util.Observable;

import model.UndirectedGraph;
import model.WeightedTree;


/**
 * Abstract minimum spanning tree solver.
 * 
 * @author DR
 *
 */
public abstract class SpanTreeSolver extends Observable {



	/**
	 * Get minimum spanning tree on g.
	 * 
	 * @param g
	 *            underlying graph
	 * @return maximum flow on g
	 */
	public abstract WeightedTree getSolution(UndirectedGraph g);
	
}
