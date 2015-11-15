package moteur;

import java.util.ArrayList;

public class JeuTron {
	
	public static void main(String[] args) {
		ArrayList<GameBoard> GMpossible = new ArrayList<GameBoard>();
		
		Player player1 = new Player("1",0,0,'g');
		Player player2 = new Player("2",9,9,'d');
		GameBoard Grille = new GameBoard();

		Player[] players = {player1, player2};
		
		Grille.addPlayers(players);
		int joueur1 = 0;
		int joueur2 = 1;
		
		/*Affichage(Grille);
		Grille.Play(joueur1, 'd');
		Affichage(Grille);
		Grille.Play(joueur1, 'd');
		Affichage(Grille);
		
		GMpossible = Grille.next(joueur2);
		
		if (GMpossible.size() == 0) {
			System.out.println("Liste vide");
		}
		
		for (int i = 0; i < GMpossible.size(); i++) {
			System.out.println("===============================");
			Affichage(GMpossible.get(i));
		}*/
		
		/*GMpossible = Grille.next(joueur1);
		
		Dijkstra algo = new Dijkstra(GMpossible.get(1));
		int gm = algo.Evaluation(joueur1, joueur2);
		System.out.println(gm);*/
		
		GMpossible = Grille.next(joueur1);
		for (int i = 0; i < GMpossible.size(); i++) {
			System.out.println("===============================");
			Affichage(GMpossible.get(i));
		}
		

		/*GameBoard nouveuxGM = joueur1.MinMax(0, Grille, joueur2);
		Affichage(nouveuxGM);*/
		//Affichage(Grille);		
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
