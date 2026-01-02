package view;

import java.util.Observable;
import java.util.Observer;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants.Units;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.view.Viewer;

import model.WeightedTree;

/**
 * 
 * Vue pour le solveur de flow max.
 * Bas� sur la biblioth�que http://graphstream-project.org
 *
 */
public class SpanTreeView implements Observer {

	// underlying graph view
	private final Graph graphView;

	// underlying graph model
	private model.UndirectedGraph graphModel;

	// given flow
	private WeightedTree tree;

	// delay between update
	private int delay;

	// style size: 15px; fill-color: #D82; stroke-mode: plain; stroke-color: #999; shadow-mode: gradient-radial; shadow-width: 2px; shadow-color: #999, white; shadow-offset: 3px, -3px;
	protected String styleSheet = "node { text-alignment: center; size: 20px, 20px;   fill-color: white;  stroke-mode: plain; stroke-color: #999; shadow-mode: gradient-radial; shadow-width: 2px; shadow-color: #999, white; shadow-offset: 2px, -2px; text-size: 12;  }"
			+ "edge {text-size: 12;}"
			+ "edge.green {" + "	fill-color: green; size: 2px; shadow-mode: gradient-radial; shadow-width: 2px; shadow-color: green, blue; shadow-offset: 2px, -2px;" + "}" + "edge.red {" + "shadow-mode: gradient-radial; shadow-width: 1px; shadow-color: grey, red; shadow-offset: 2px, -2px;fill-color: red; size: 2px; " + "}"
			+ "edge.black {" + "fill-color: black; size: 2px;" + "}"
			+ "edge { text-background-mode: plain; } sprite {fill-mode: none; }"
			+ "node.white { fill-color: white; text-color: black; }"
			+ "node.red { fill-color: red; text-color: white; }";

	// sprite manager for styling graph view
	private SpriteManager sman;

	/**
	 * Creates a graph view from graph model g.
	 * @param g graph model
	 * @param delay delay between updates
	 */
	public SpanTreeView(model.UndirectedGraph g, int delay) {
		graphView = new SingleGraph("");
		this.delay = delay;
		tree = new WeightedTree();
		this.graphModel = g;
		
		graphView.setAttribute("ui.title", "Vue de l'arbre couvrant de poids minimum");
		
		sman = new SpriteManager(graphView);
		for (int i = 0; i < g.getNumberOfNodes(); i++) {
			Node n = graphView.addNode(i + "");
			n.addAttribute("ui.label", n.getId());
			Sprite s = sman.addSprite(i + "");
			s.attachToNode(n.getId());
			s.setPosition(Units.PX, 20, 0, 270);
		}
		for (int u = 0; u < g.getNumberOfEdges(); u++) {
			Edge e = graphView.addEdge(u + "", g.firstEndPoint(u), g.secondEndPoint(u), false);
			e.addAttribute("ui.label", "" + g.weight(u));
		}

		graphView.addAttribute("ui.stylesheet", styleSheet);
		Viewer viewer = graphView.display();

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		viewer.disableAutoLayout();

		
		
		
	}

	/**
	 * Changes tree with new tree. 
	 * @param tree new flow
	 */
	private void setTree(WeightedTree tree) {
		for (int u : tree.getEdges()) {
			Edge e = graphView.getEdge(u);
			if (this.tree.getEdges().contains(u))
				e.setAttribute("ui.class", "red");
			else {
				e.setAttribute("ui.class", "green");
				this.tree.addEdge(u, graphModel.weight(u));
			}
		}
		}

	/**
	 * Update current tree with new tree.
	 * @param tree new tree
	 */
	public void newTree(WeightedTree tree) {
		setTree(tree);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setTree(tree);
	}

	/**
	 * Changes node color.
	 * @param i node id
	 * @param color new color
	 */
	public void setNodeColor(int i, String color) {
		Node n = graphView.getNode(i);
		n.setAttribute("ui.class", color);
	}
	
	/* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable o, Object p) {
    	WeightedTree tree = (WeightedTree) p;
      	newTree(tree);
    }

}
