package moteur;

import java.util.ArrayList;

public class GameBoard {
	
	int Longueur;
	int Hauteur;
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
		
		GameBoard GameBoard = new GameBoard();
		
		if(player.Oriente == move){
			return this;
		}
		
		GameBoard.Grille[player.PositionY][player.PositionX] = '+';
		
		switch(move){
		
			case 'h' :  
						GameBoard.Grille[player.PositionY-1][player.PositionX] = player.Id;
						player.PositionY--;
						player.Oriente = 'b';
						break; 
		
			case 'b' : 	
						GameBoard.Grille[player.PositionY+1][player.PositionX] = player.Id;
						player.PositionY++;
						player.Oriente = 'h';
						break;
			
			case 'g' :  
						GameBoard.Grille[player.PositionY][player.PositionX-1] = player.Id;
						player.PositionX--;
						player.Oriente = 'd';
						break;
			
			case 'd' :  
						GameBoard.Grille[player.PositionY][player.PositionX+1] = player.Id;
						player.PositionX++;
						player.Oriente = 'g';
						break;
		}
		return GameBoard;
	}
	
	public ArrayList<GameBoard> next (Player player) {
		
		ArrayList<GameBoard> GMPossible = new ArrayList<GameBoard>();
		Player joueur;
		GameBoard gm;
		
		gm = new GameBoard();
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if (joueur.PositionY <= this.Hauteur-1) {
			GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'h');
		}
		
		gm = new GameBoard();
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionY >= 0) {
			GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'b');
		}

		gm = new GameBoard();
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX >= 0) {
			GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'g');
		}

		gm = new GameBoard();
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX <= this.Longueur-1) {
			GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'd');
		}
		
		return GMPossible;
	}
	
	public static ArrayList<GameBoard> AjoutGameBoard (ArrayList<GameBoard> ListeGB, GameBoard GB, Player joueur, char move) {
		
		if (GB != (GB = GB.Play(joueur, move))) {
			ListeGB.add(GB);
		}
		return ListeGB;
	}
}
