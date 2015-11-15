package moteur;

import java.util.ArrayList;

public class Player {
	
	String Id;
	int PositionX;
	int PositionY;
	char Oriente;
	
	public Player (String Id, int PositionX, int PositionY, char Oriente) {
		
		this.Id = Id;
		this.PositionX = PositionX; //Hauteur
		this.PositionY = PositionY;	//Longueur
		this.Oriente = Oriente;
	}
	
	public GameBoard MinMax (int profondeur, GameBoard gm, Player joueur2) {
		
		if (profondeur == 0) {
			return max(gm.next(Integer.parseInt(this.Id)), joueur2);
		}
		
		if (profondeur%2 == 0) {
			return MinMax (profondeur - 1, max(gm.next(Integer.parseInt(this.Id)), joueur2), joueur2);
		} else {
			return MinMax (profondeur - 1, min(gm.next(Integer.parseInt(this.Id)), joueur2), joueur2);
		}
	}
	
	private GameBoard max (ArrayList<GameBoard> GMpossible, Player joueur2) {
		
		if (GMpossible.size() == 1) {
			return GMpossible.get(0);
		}
		
		Dijkstra[] DIJpossible = new Dijkstra[GMpossible.size()];
		
		for (int i = 0; i < GMpossible.size(); i++) {
			DIJpossible[i] = new Dijkstra (GMpossible.get(i));
		}
		
		if (GMpossible.size() == 2) {
			return DIJpossible[0].Evaluation(this, joueur2) >= DIJpossible[1].Evaluation(this, joueur2) ? 
					DIJpossible[0].plateau : DIJpossible[1].plateau;
		}
		return DIJpossible[0].Evaluation(this, joueur2) >= DIJpossible[1].Evaluation(this, joueur2) ? 
				DIJpossible[0].Evaluation(this, joueur2) >= DIJpossible[2].Evaluation(this, joueur2) ? 
						DIJpossible[0].plateau : DIJpossible[3].plateau : DIJpossible[1].plateau;
	}
	
	private GameBoard min (ArrayList<GameBoard> GMpossible, Player joueur2) {
		
		if (GMpossible.size() == 1) {
			return GMpossible.get(0);
		}
		
		Dijkstra[] DIJpossible = new Dijkstra[GMpossible.size()];
		
		for (int i = 0; i < GMpossible.size(); i++) {
			DIJpossible[i] = new Dijkstra (GMpossible.get(i));
		}
		
		if (GMpossible.size() == 2) {
			return DIJpossible[0].Evaluation(this, joueur2) <= DIJpossible[1].Evaluation(this, joueur2) ? 
					DIJpossible[0].plateau : DIJpossible[1].plateau;
		}
		return DIJpossible[0].Evaluation(this, joueur2) <= DIJpossible[1].Evaluation(this, joueur2) ? 
				DIJpossible[0].Evaluation(this, joueur2) <= DIJpossible[2].Evaluation(this, joueur2) ? 
						DIJpossible[0].plateau : DIJpossible[3].plateau : DIJpossible[1].plateau;
	}
}
