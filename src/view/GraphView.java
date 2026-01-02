package view;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants.Units;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;


/**
 * 
 * Vue pour le solveur de flow max.
 * Bas� sur la biblioth�que http://graphstream-project.org
 *
 */
public class GraphView {

	// underlying graph view
	private final Graph graphView;


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
	 */
	public GraphView(model.UndirectedGraph g) {
		graphView = new SingleGraph("");
		
		graphView.setAttribute("ui.title", "Exemple de graphe");
		
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
			e.addAttribute("ui.label", "u = "+u+", w = " + g.weight(u));
		}

		graphView.addAttribute("ui.stylesheet", styleSheet);
		graphView.display();
		
	}


}
