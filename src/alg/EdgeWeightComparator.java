package alg;

import java.util.Comparator;

import model.UndirectedGraph;

public class EdgeWeightComparator implements Comparator<Integer> {

	/**
	 * Underlying graph.
	 */
	private UndirectedGraph g;
	
	/** 
	 * Creates a comparator for edges based on their weight. 
	 */ 
	public EdgeWeightComparator(UndirectedGraph g) { 
		this.g = g; 
	}

	@Override
	public int compare(Integer u, Integer v) {
		// TODO A compléter
		return 0;
	}

}