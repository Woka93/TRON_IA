package moteur;

import java.util.ArrayList;

public class JeuTron {
	
	public static void main(String[] args) {
		ArrayList<GameBoard> GMpossible = new ArrayList<GameBoard>();
		GameBoard Grille = new GameBoard();
		
		Player joueur1 = new Player('1',1,1,'b');
		
		//Grille.Play(joueur1, 'd');
		//Grille.Play(joueur1, 'd');
		
		//Affichage(Grille);
		
		GMpossible = Grille.next(joueur1);
		
		for (int i = 0; i < GMpossible.size(); i++) {
			System.out.println("===============================");
			Affichage(GMpossible.get(i));
		}
				
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
