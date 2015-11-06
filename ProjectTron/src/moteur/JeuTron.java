package moteur;

import java.util.ArrayList;
import java.util.Collections;

public class JeuTron {
	
	public static void main(String[] args) {
		
		ArrayList<GameBoard> GMpossible = new ArrayList<GameBoard>();
		char move;
		Player joueur1 = new Player("1",0,0,'g');
		Player joueur2 = new Player("2",9,9,'h');
		GameBoard Grille = new GameBoard();
		boolean FinPartie = false;
		int Tour = 0;
		
		Grille.InitGrille(joueur1, joueur2);
		
		while(!FinPartie){
			if(Tour%2 == 0){
				System.out.println("Joueur 1 :");
				GMpossible = Grille.next(joueur1);
				if(!GMpossible.isEmpty()){
					move = Mouvement(GMpossible, joueur1, joueur2, Tour);
					Grille.Play(joueur1, move);
				}else{
					Grille.Grille[joueur1.PositionY][joueur1.PositionX] = "+";
					FinPartie = true;
				}
				Tour++;
				
			}else{
				System.out.println("Joueur 2 :");
				GMpossible = Grille.next(joueur2);
				if(!GMpossible.isEmpty()){
					move = Mouvement(GMpossible, joueur1, joueur2, Tour);
					Grille.Play(joueur2, move);
				}else{
					Grille.Grille[joueur2.PositionY][joueur2.PositionX] = "+";
					FinPartie = true;
				}
				
				Tour++;
				
			}
			
			Affichage(Grille);
			
		}
	}
	
	public static char Mouvement(ArrayList<GameBoard> GMpossible, Player joueur1, Player joueur2, int Tour){
		ArrayList<Integer> Territoire = new ArrayList<Integer>();
		int cpt = 0;
		char mouvement;
		
		for(int i = 0; i < GMpossible.size(); i++){	
			Dijkstra dijk1 = new Dijkstra(GMpossible.get(i), joueur1);
			Dijkstra dijk2 = new Dijkstra(GMpossible.get(i), joueur2);
			if(Tour%2 == 0){
				cpt = dijk1.value(dijk1.calculer(), dijk2.calculer());
			}else{
				cpt = dijk2.value(dijk1.calculer(), dijk2.calculer());
			}		
			Territoire.add(cpt);
		}
		
		mouvement = GMpossible.get(Territoire.indexOf(Collections.max(Territoire))).Coup;
		
		return mouvement;
	}
		
	public static void Affichage(GameBoard Grille){
		
		for(int i = 0; i < Grille.Hauteur; i++){
			for(int j = 0; j < Grille.Longueur; j++){
				System.out.print(Grille.Grille[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("=============================================");
	}
}
