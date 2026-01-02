package model;

import java.util.List;

public class UndirectedGraph  {

	/**
	 * Weights on edges.
	 */
	private List<Integer> weight;
	
	/**
	 * Number of node.
	 */
	private int n;
	
	/**
	 * Number of edges.
	 */
	private int m;
	
	/**
	 * For each node, give a list of incident edges.
	 */
	private List<List<Integer>> incidentEdges;
	
	/**
	 * First endpoints of edges.
	 */
	private List<Integer> firstEndPoint;
	
	/**
	 * Second endpoints of edges.
	 */
	private List<Integer> secondEndPoint;

	/**
	 * Builds an empty graph.
	 */
	public UndirectedGraph() {
		// TODO A completer
	}
	
	/**
	 * Builds a graph with n nodes.
	 * @param n number of nodes
	 */
	public UndirectedGraph(int n) {
		// TODO A completer
	}
		
	/**
	 * Adds a node.
	 */
	public void addNode() {
		// TODO A completer
	}
	
	/**
	 * Adds a new edge (i, j) with weight w.
	 * @param i first endpoint of edge
	 * @param j second endpoint of edge
	 * @param w weight of edge
	 */
	public void addEdge( int i, int j, int w ) {
		// TODO A completer
	}

	/**
	 * Return incident edges to node i.
	 * @param i node
	 * @return incident edges to node i
	 */
	public List<Integer> incidentEdges(int i) {
		// TODO A completer
		return null;
	}

	/**
	 * Return first endpoint of edge u.
	 * @param u an edge
	 * @return first endpoint of edge u
	 */
	public int firstEndPoint(int u) {
		// TODO A completer
		return -1;
	}

	/**
	 * Return second endpoint of edge u.
	 * @param u an edge
	 * @return second endpoint of edge u
	 */
	public int secondEndPoint(int u) {
		// TODO A completer
		return -1;
	}

	/**
	 * Return opposite node of i in edge u.
	 * @param i an endpoint
	 * @param u an edge incident to i
	 * @return opposite endpoint of i through u
	 */
	public int oppositeNode(int i, int u) {
		// TODO A completer
		return -1;
	}

	/**
	 * Return weight of edge u.
	 * @param u an edge
	 * @return weight of edge u
	 */
	public int weight(int u) {
		// TODO A completer
		return -1;
	}

	
	/**
	 * Return number of nodes.
	 * @return number of nodes
	 */
	public int getNumberOfNodes() {
		// TODO A completer
		return -1;
	}

	/**
	 * Return number of edges.
	 * @return number of edges
	 */
	public int getNumberOfEdges() {
		// TODO A completer
		return -1;
	}

		
}
