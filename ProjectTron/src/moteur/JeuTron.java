package last;

import java.util.ArrayList;
import java.util.Collections;

public class JeuTron {
	
	public static void main(String[] args) {
		
		ArrayList<GameBoard> GMpossible = new ArrayList<GameBoard>();
		char move;
		int max = 0;
		int min = 0;
		Player joueur1 = new Player("1",9,0,'h');
		Player joueur2 = new Player("2",0,9,'b');
		GameBoard Grille = new GameBoard();
		boolean FinPartie = false;
		int Tour = 0;
		
		Grille.InitGrille(joueur1, joueur2);
		
		while(!FinPartie){
			if(Tour%2 == 0){
				System.out.println("Joueur 1 :");
				GameBoard newGB1 = MinMax(20, Grille, max, min, joueur1, joueur2);
				if(newGB1.Coup != 'a'){
					move = newGB1.Coup;
					Grille.Play(joueur1, move);
				}else{
					Grille.Grille[joueur1.PositionY][joueur1.PositionX] = "+";
					FinPartie = true;
				}
				Tour++;
				
			}else{
				System.out.println("Joueur 2 :");
				GameBoard newGB2 = MinMax(20, Grille, max, min, joueur2, joueur1);
				if(newGB2.Coup != 'a'){
					move = newGB2.Coup;
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
	
	public static GameBoard MinMax (int profondeur, GameBoard init, int max, int min, Player joueur1, Player joueur2) {
		int tmp;
		GameBoard coup = new GameBoard();
		max = -200;
		ArrayList<GameBoard> possible = init.next(joueur1, joueur2);
		for (int i = 0; i < possible.size(); i++) {
			//Affichage(possible.get(i));
			tmp = Min(profondeur-1, possible.get(i), joueur1, joueur2, max, min);
			if (tmp > max) {
				max = tmp;
				coup = GameBoard.CopyGameBoard(possible.get(i));
			}
		}
		return coup;
	}
	
	public static int Min (int profondeur, GameBoard gb, Player joueur1, Player joueur2, int max, int min) {
		if (profondeur == 0) {
			Dijkstra dij = new Dijkstra(gb);
			//System.out.println(dij.Evaluation(gb.joueur1, gb.joueur2));
			return dij.Evaluation(gb.joueur1, gb.joueur2);
		} else {
			min = 200;
			ArrayList<GameBoard> possible = gb.next(gb.joueur2, gb.joueur1);
			for (int i = 0; i < possible.size(); i++) {
				//Affichage(possible.get(i));
				min = Math.min(min, Max(profondeur-1, possible.get(i), gb.joueur1, gb.joueur2, max, min));
			}
		}
		return min;
	}
	
	public static int Max (int profondeur, GameBoard gb, Player joueur1, Player joueur2, int max, int min) {
		if (profondeur == 0) {
			Dijkstra dij = new Dijkstra(gb);
			//System.out.println(dij.Evaluation(gb.joueur1, gb.joueur2));
			return dij.Evaluation(gb.joueur1, gb.joueur2);
		} else {
			max = -200;
			ArrayList<GameBoard> possible = gb.next(gb.joueur2, gb.joueur1);
			for (int i = 0; i < possible.size(); i++) {
				//Affichage(possible.get(i));
				max = Math.max(max, Min(profondeur-1, possible.get(i), gb.joueur1, gb.joueur2, max, min));
			}
		}
		return max;
	}
	
	/*public static char Mouvement(ArrayList<GameBoard> GMpossible, Player joueur1, Player joueur2, int Tour){
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
	}*/
	
	public static ArrayList<GameBoard> Profondeur(ArrayList<GameBoard> GB){
		
		for(int i = 0; i < GB.size(); i++){
			GB.get(i).next(GB.get(i).joueur1, GB.get(i).joueur2);
		}
		
		return GB;
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
