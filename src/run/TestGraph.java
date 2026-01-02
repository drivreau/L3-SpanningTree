package run;

import model.UndirectedGraph;
import view.GraphView;

public class TestGraph {
	/**
	 * Main class
	 * @param args args
	 */
	public static void main(String args[]) {

		// On param�tre la vue gaphique du graphe
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
		// Cr�ation d'un graphe � 4 sommets
		UndirectedGraph g = new UndirectedGraph(4);
		
		// Ajout des ar�tes
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 6);
		g.addEdge(1, 3, 3);
		g.addEdge(2, 3, 4);
		
		// On cr�� une vue graphique du graphe
		new GraphView(g);
		
		// On teste les m�thodes
		System.out.println( "Liste des arêtes incidentes intérieurement à 1 : "+g.incidentEdges(1));
		System.out.println( "Première extrémité de l'arc 2 : "+g.firstEndPoint(2));
		System.out.println( "Extrémité terminale de l'arc 2 : "+g.secondEndPoint(2));
		System.out.println( "Capacité de l'arc 2 : "+g.weight(2));
		
	}

}
