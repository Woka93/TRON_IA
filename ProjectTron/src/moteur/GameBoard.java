package moteur;

import java.util.ArrayList;

public class GameBoard {
	
	int Longueur; 	//PositionX
	int Hauteur;	//PositionY
	char[][] Grille;
	
	public GameBoard () {
		
		this.Longueur = 10;
		this.Hauteur = 10;
		this.Grille = new char [this.Hauteur][this.Longueur];
		
		InitGrille();
	}
	
	public void InitGrille(){
		for(int i = 0; i < Hauteur; i++){
			for(int j = 0; j < Longueur; j++){
				Grille[i][j] = '.';
			}
		}
	}
	
	// Renvoie le GameBoard modifié si pas de problème d'orientation, sinon le GameBoard initial

	public GameBoard Play(Player player, char move){
		
		if(player.Oriente == move){
			return this;
		}
		
		this.Grille[player.PositionY][player.PositionX] = '+';
		
		switch(move){
		
			case 'h' :  
						this.Grille[player.PositionY-1][player.PositionX] = player.Id;
						player.PositionY--;
						player.Oriente = 'b';
						break; 
		
			case 'b' : 	
						this.Grille[player.PositionY+1][player.PositionX] = player.Id;
						player.PositionY++;
						player.Oriente = 'h';
						break;
			
			case 'g' :  
						this.Grille[player.PositionY][player.PositionX-1] = player.Id;
						player.PositionX--;
						player.Oriente = 'd';
						break;
			
			case 'd' :  
						this.Grille[player.PositionY][player.PositionX+1] = player.Id;
						player.PositionX++;
						player.Oriente = 'g';
						break;
		}
		return this;
	}
	
	public ArrayList<GameBoard> next (Player player) {
		
		ArrayList<GameBoard> GMPossible = new ArrayList<GameBoard>();
		Player joueur;
		GameBoard gm;
		
		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if (joueur.PositionY > 0 && player.Oriente != 'h') {
			if (gm.Grille[joueur.PositionY-1][joueur.PositionX] == '.') {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'h');
			}
		}
		
		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionY < this.Hauteur-1 && player.Oriente != 'b') {
			if (gm.Grille[joueur.PositionY+1][joueur.PositionX] == '.') {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'b');
			}
		}

		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX > 0 && player.Oriente != 'g') {
			if (gm.Grille[joueur.PositionY][joueur.PositionX-1] == '.') {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'g');
			}
		}

		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX < this.Longueur-1 && player.Oriente != 'd') {
			if (gm.Grille[joueur.PositionY][joueur.PositionX+1] == '.') {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'd');
			}
		}
		
		return GMPossible;
	}
	
	public static ArrayList<GameBoard> AjoutGameBoard (ArrayList<GameBoard> ListeGB, GameBoard GB, Player joueur, char move) {

		GB.Play(joueur, move);
		ListeGB.add(GB);
		return ListeGB;
	}
	
	public static GameBoard CopyGameBoard (GameBoard gb) {
		
		GameBoard gm = new GameBoard();
		
		for(int i = 0; i < gb.Hauteur; i++){
			for(int j = 0; j < gb.Longueur; j++){
				gm.Grille[i][j] = gb.Grille[i][j];
			}
		}
		return gm;
	}
	
}
