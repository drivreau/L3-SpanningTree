package sort;

import java.util.Arrays;

public class TutoSort {

	public static void main(String[] args) {

		// définition des tableaux initiaux
		String[] noms = {"Arthur", "Basile", "Charles", "Dominique", "Eric" };
		int[] poids = { 81, 62, 93, 75, 90 };  
		int[] tailles = {175,  164, 184, 181, 186 };

		// affichage
		System.out.println( "noms : " + Arrays.toString(noms) );
		System.out.println( "poids : " + Arrays.toString(poids) );
		System.out.println( "tailles : " + Arrays.toString(tailles) );

	}
}