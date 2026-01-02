package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Weighted tree given by its edges.
 * @author DR
 */
public class WeightedTree {

	/**
	 * Edges.
	 */
	private List<Integer> edges;
	
	/**
	 * Tree weight.
	 */
	private int weight;
	

	/**
	 * Builds an empty weighted tree.
	 * @param m number of arcs
	 */
	public WeightedTree() {
		edges = new ArrayList<Integer>();
		weight = 0;
	}
	
 
	/**
	 * Returns edges.
	 * @return edges
	 */
	public List<Integer> getEdges() {
		return Collections.unmodifiableList(edges);
	}
		
	/**
	 * Get the tree weight.
	 * @return the value 
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Adds an edge with weight w.
	 * @param u edge
	 * @param w weight of edge u
	 */
	public void addEdge( int u, int w ) {
		edges.add(u);
		weight+=w;
	}


	/**
	 * Gives tree size.
	 * @return tree size
	 */
	public int size() {
		return edges.size();
	}
	
}
