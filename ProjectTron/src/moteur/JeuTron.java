package moteur;

import java.util.ArrayList;

public class JeuTron {
	
	public static void main(String[] args) {
		ArrayList<GameBoard> GMpossible = new ArrayList<GameBoard>();
		
		Player joueur1 = new Player("1",0,0,'b');
		//Player joueur2 = new Player('2',3,3,'b');
		GameBoard Grille = new GameBoard();

		/*Grille.Grille[0][3] = "+";
		Affichage(Grille);
		Grille.Play(joueur1, 'd');
		Affichage(Grille);
		Grille.Play(joueur1, 'd');
		Affichage(Grille);
		
		GMpossible = Grille.next(joueur1);
		
		if (GMpossible.size() == 0) {
			System.out.println("Liste vide");
		}
		
		for (int i = 0; i < GMpossible.size(); i++) {
			System.out.println("===============================");
			Affichage(GMpossible.get(i));
		}*/
		
		//Affichage(Grille);
		
		/*Dijkstra algo = new Dijkstra(Grille, joueur1);
		GameBoard gm = algo.calculer();
		Affichage(gm);*/
		
	}

	
	public static void Affichage(GameBoard Grille){
		
		for(int i = 0; i < Grille.Hauteur; i++){
			for(int j = 0; j < Grille.Longueur; j++){
				System.out.print(Grille.Grille[i][j]);
			}
			System.out.print("\n");
		}
		
	}
}
