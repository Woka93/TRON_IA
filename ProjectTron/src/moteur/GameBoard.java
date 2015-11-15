package moteur;

import java.util.ArrayList;

public class GameBoard {
	
	int Longueur; 	//PositionX
	int Hauteur;	//PositionY
	Player[] joueurs;
	String[][] Grille;
	
	public GameBoard () {
		
		this.Longueur = 10;
		this.Hauteur = 10;
		this.Grille = new String [this.Hauteur][this.Longueur];
		
		InitGrille();
	}
	
	public void InitGrille(){
		for(int i = 0; i < Hauteur; i++){
			for(int j = 0; j < Longueur; j++){
				Grille[i][j] = ".";
			}
		}
	}
	
	public void addPlayers (Player[] players) {
		joueurs = new Player[players.length];
		for (int i = 0; i < players.length; i++) {
			joueurs[i] = players[i];
		}
	}
	
	// Renvoie le GameBoard modifié si pas de problème d'orientation, sinon le GameBoard initial

	public GameBoard Play(int player, char move){
		
		if(joueurs[player].Oriente == move){
			return this;
		}
		
		this.Grille[joueurs[player].PositionY][joueurs[player].PositionX] = "+";
		
		switch(move){
		
			case 'h' :  
						this.Grille[joueurs[player].PositionY-1][joueurs[player].PositionX] = joueurs[player].Id;
						joueurs[player].PositionY--;
						joueurs[player].Oriente = 'b';
						break; 
		
			case 'b' : 	
						this.Grille[joueurs[player].PositionY+1][joueurs[player].PositionX] = joueurs[player].Id;
						joueurs[player].PositionY++;
						joueurs[player].Oriente = 'h';
						break;
			
			case 'g' :  
						this.Grille[joueurs[player].PositionY][joueurs[player].PositionX-1] = joueurs[player].Id;
						joueurs[player].PositionX--;
						joueurs[player].Oriente = 'd';
						break;
			
			case 'd' :  
						this.Grille[joueurs[player].PositionY][joueurs[player].PositionX+1] = joueurs[player].Id;
						joueurs[player].PositionX++;
						joueurs[player].Oriente = 'g';
						break;
		}
		return this;
	}
	
	public ArrayList<GameBoard> next (int player) {
		
		ArrayList<GameBoard> GMPossible = new ArrayList<GameBoard>();
		GameBoard gbCopy;
		
		gbCopy = CopyGameBoard(this);
		if (joueurs[player].PositionY > 0 && joueurs[player].Oriente != 'h') {
			if (gbCopy.Grille[joueurs[player].PositionY-1][joueurs[player].PositionX] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gbCopy, player, 'h');
			}
		}
		
		gbCopy = CopyGameBoard(this);
		if(joueurs[player].PositionY < this.Hauteur-1 && joueurs[player].Oriente != 'b') {
			if (gbCopy.Grille[joueurs[player].PositionY+1][joueurs[player].PositionX] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gbCopy, player, 'b');
			}
		}

		gbCopy = CopyGameBoard(this);
		if(joueurs[player].PositionX > 0 && joueurs[player].Oriente != 'g') {
			if (gbCopy.Grille[joueurs[player].PositionY][joueurs[player].PositionX-1] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gbCopy, player, 'g');
			}
		}

		gbCopy = CopyGameBoard(this);
		if(joueurs[player].PositionX < this.Longueur-1 && joueurs[player].Oriente != 'd') {
			if (gbCopy.Grille[joueurs[player].PositionY][joueurs[player].PositionX+1] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gbCopy, player, 'd');
			}
		}
		
		return GMPossible;
	}
	
	public static ArrayList<GameBoard> AjoutGameBoard (ArrayList<GameBoard> ListeGB, GameBoard GB, int joueur, char move) {

		GB.Play(joueur, move);
		ListeGB.add(GB);
		return ListeGB;
	}
	
	public static GameBoard CopyGameBoard (GameBoard gbToCopy) {
		
		GameBoard gbCopy = new GameBoard();
		
		for(int i = 0; i < gbToCopy.Hauteur; i++){
			for(int j = 0; j < gbToCopy.Longueur; j++){
				gbCopy.Grille[i][j] = gbToCopy.Grille[i][j];
			}
		}
		gbCopy.joueurs = gbToCopy.joueurs;


		for(int i = 0; i < gbToCopy.joueurs.length; i++){
			System.out.println(gbToCopy.joueurs[i].PositionX + " " + gbToCopy.joueurs[i].PositionY);
		}
		System.out.println("-----------------------------------");
		for(int i = 0; i < gbCopy.joueurs.length; i++){
			System.out.println(gbCopy.joueurs[i].PositionX + " " + gbCopy.joueurs[i].PositionY);
		}
		System.out.println("===================================");
		
		return gbCopy;
	}
	
	public String lireCase(int x, int y) {
		return Grille[x][y];
	}
}
