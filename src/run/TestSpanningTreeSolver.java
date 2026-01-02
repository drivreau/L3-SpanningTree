package run;


import java.util.Scanner;

import alg.CheckSpanTree;
import alg.KruskalSpanTreeSolver;
import alg.PrimSpanTreeSolver;
import alg.SpanTreeSolver;
import model.UndirectedGraph;
import model.WeightedTree;
import view.SpanTreeView;

/**
 * This class test a basic instance for maximum flow solver.
 * @author DR
 *
 */
public class TestSpanningTreeSolver {

	/**
	 * Main class
	 * @param args args
	 */
	public static void main(String args[]) {
		
		// configuration de la vue graphique
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
		// création d'un graphe à 10 sommets
		UndirectedGraph g = new UndirectedGraph(10);
				
		// ajout des arêtes
		g.addEdge(0, 1, 22);
		g.addEdge(0, 2, 36);
		g.addEdge(0, 5, 54);
		
		g.addEdge(1, 2, 20);
		g.addEdge(1, 3, 14);
		g.addEdge(1, 4, 40);
		g.addEdge(1, 5, 42);
		
		g.addEdge(2, 3, 14);
		g.addEdge(2, 6, 41);
		g.addEdge(2, 7, 65);
		
		g.addEdge(3, 4, 32); 
		g.addEdge(3, 6, 36);
		
		g.addEdge(4, 5, 32);
		g.addEdge(4, 6, 30);
		g.addEdge(4, 8, 42);
		g.addEdge(4, 9, 53);
		
		g.addEdge(5, 9, 79);
		
		g.addEdge(6, 7, 25);
		g.addEdge(6, 8, 30);
		
		g.addEdge(7, 8, 18);
		g.addEdge(7, 9, 32);
		
		g.addEdge(8, 9, 15);
	
		// on crée une vue graphique
		SpanTreeView view = new SpanTreeView(g,1000);

		
		
		Scanner scan = new Scanner(System.in);
		int alg = 0;
		
		while (alg!=1 && alg!=2) {
			System.out.println( "Choisir algorithme : " );
			System.out.println( "(1) Prim " );
			System.out.println( "(2) Krukal " );
			System.out.print( "Choix : ");
			alg = scan.nextInt();
		}
		scan.close();
		
		
		// on créé le solveur
		SpanTreeSolver solver = null;
		if (alg==1) {
			solver = new PrimSpanTreeSolver();
		}
		else {
			solver = new KruskalSpanTreeSolver();
		}	
	
		// on ajoute l'observateur sur l'algorithme de résolution
		solver.addObserver(view);
		
		// on calcule l'arbre couvrant de poids minimum
		WeightedTree tree = solver.getSolution(g);
	
		// on affiche les résultat
		if (CheckSpanTree.isValid(tree, g)) {
			System.out.println( "L'arbre couvrant de poids minimum vaut : "+tree.getWeight() ) ;
		}
		else {
			System.out.println( "L'arbre n'est pas valide." );
		}
		
	}
}
