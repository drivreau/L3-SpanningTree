package sort;
import java.util.Arrays;

public class TutoSort2 {

	public static void main(String[] args) {

		// définition des tableaux initiaux
		String[] noms = {"Arthur", "Basile", "Charles", "Dominique", "Eric" };
		int[] poids = { 81, 62, 93, 75, 90 };  
		int[] tailles = {175,  164, 184, 181, 186 };

		// création des comparateurs selon les deux critères
		CritComparator pComparator = new CritComparator( poids );
		CritComparator tComparator = new CritComparator( tailles );

	    // initialisation des ordres
		Integer[] pOrdre = { 0, 1, 2, 3, 4 };
		Integer[] tOrdre = { 0, 1, 2, 3, 4 };

		// tri des tableaux pOrdre et tOrdre avec les comparateurs associés
		Arrays.sort(pOrdre, pComparator);
		Arrays.sort(tOrdre, tComparator);

		// affichage
		System.out.println( "tableau pOrdre : " + Arrays.toString( pOrdre ) );
		System.out.println( "tableau tOrdre : " + Arrays.toString( tOrdre ) );
		System.out.println();
		System.out.println( "Affichage des données en ordre de poids croissants :");

		for (int i : pOrdre) {
			System.out.print( "Nom : "+noms[i] );
			System.out.print( "\t Poids : "+poids[i] );
			System.out.println( "\t Taille : "+tailles[i] );
		}		
	}

}
