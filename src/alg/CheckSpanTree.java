package alg;

import java.util.List;

import ds.UnionFind;
import model.UndirectedGraph;
import model.WeightedTree;

/**
 * Check if a weighted tree is a spanning tree on an undirected graph.
 * 
 * @author Rivreau
 *
 */
public class CheckSpanTree {

	/**
	 * Check if given input is a valid spanning tree for graph g.
	 * 
	 * @param tree
	 *            tree
	 * @return true if tree is a valid spanning tree for g
	 */
	public static boolean isValid(WeightedTree tree, UndirectedGraph g) {
		
		if (tree.size() != g.getNumberOfNodes() - 1)
			return false; 	// the tree must have (m-1) edges
		else {
			List<Integer> E = tree.getEdges();
			int w = 0;
			for (int u : E)
				w += g.weight(u);
			if (w!=tree.getWeight()) 
				return false;	// the weight should be right
			else {
				UnionFind uf = new UnionFind(g.getNumberOfNodes());
				for (int u : E) {
					uf.union(g.firstEndPoint(u), g.secondEndPoint(u));
				}
				int compo = uf.find(0);
				for (int i=1;i<g.getNumberOfNodes();i++)
					if (uf.find(i)!=compo)
						return false;	// the tree is not connected
			}
		}
		return true;	// all is ok : it's a valid spanning tree
	}

}
