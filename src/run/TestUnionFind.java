package run;

import java.util.Scanner;

import ds.UnionFind;

public class TestUnionFind {

	public static void main(String[] args) {
		
		
		// Cr�ation des ensembles {0}, {1}, ... {9}
		UnionFind uf = new UnionFind(10);
		
		Scanner clavier = new Scanner(System.in);
		int rep, val1, val2;
		do {
			System.out.println( "Sélectionner une opération : ");
			System.out.println("  (0) Quitter");
			System.out.println("  (1) Réaliser une union de deux éléments");
			System.out.println("  (2) Tester l'appartenance de deux éléments au même ensemble");
			System.out.print( "Choix : ");
			rep = clavier.nextInt();
			if (rep==1 || rep==2) {
				System.out.print( "Donner la valeur 1 (entre 0 et 9) : ");
				val1 = clavier.nextInt();
				System.out.print( "Donner la valeur 2 (entre 0 et 9) : ");
				val2 = clavier.nextInt();
				if (rep==1)
					uf.union(val1,val2);
				else if (uf.find(val1)==uf.find(val2))
					System.out.println( val1+" et "+val2+" appartiennent au même ensemble");
				else
					System.out.println( val1+" et "+val2+" n'appartiennent pas au même ensemble");
			}
		} while (rep!=0);

	}

}
