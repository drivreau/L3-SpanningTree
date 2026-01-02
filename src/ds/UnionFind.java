package ds;

/**
 * This class implements an efficient representation of sets of integer in
 * [0..N-1] with quick union and find operations.
 * 
 * @author David Rivreau
 * @version 0.1
 */
public class UnionFind {

	/**
	 * Father representative of each element.
	 */
	private int parent[];

	/**
	 * Ranks of subsets.
	 */
	private int rank[];
	

	/**
	 * Creates a new UnionFind data structures with at most card elements.
	 * 
	 * @param card
	 *            maximum total number of elements.
	 */
	public UnionFind(int card) {
		super();
		parent = new int[card];
		rank = new int[card];
		init(card);
	}

	/**
	 * Merges sets that contain element x and y.
	 * 
	 * @param x
	 *            first element.
	 * @param y
	 *            second element.
	 */
	public void union(int x, int y) {
		int r = find(x);
		int s = find(y);
		if (r == s)
			return;
		if (rank[r] > rank[s]) {
			parent[s] = r;
		} else {
			parent[r] = s;
			if (rank[r]==rank[s])
				rank[s]++;
		}
	}

	/**
	 * Returns unique representative of element x (elements in a same set shares
	 * a same representative).
	 * 
	 * @param x
	 *            the element x.
	 */
	public int find(int x) {
		int r, y;
		r = x;
		while (parent[r] != r)
			r = parent[r];
		while (x != r) {
			y = parent[x];
			parent[x] = r;
			x = y;
		}
		return r;
	}
	
	/**
	 * Initialize the data-structure.
	 * @param n
	 */
	public void init(int n) {
		for (int x = 0; x < n; x++) {
			parent[x] = x;
			rank[x] = 1;
		}
	}

}
