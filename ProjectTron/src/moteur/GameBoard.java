package moteur;

import java.util.ArrayList;

public class GameBoard {
	
	int Longueur; 	//PositionX
	int Hauteur;	//PositionY
	char Coup;
	String[][] Grille;
	Player joueur1;
	Player joueur2;
	
	public GameBoard () {
		
		this.Longueur = 10;
		this.Hauteur = 10;
		this.Grille = new String [this.Hauteur][this.Longueur];
	}
	
	public void InitGrille(Player joueur1, Player joueur2){
		for(int i = 0; i < Hauteur; i++){
			for(int j = 0; j < Longueur; j++){
				Grille[i][j] = ".";
			}
		}
		Grille[joueur1.PositionY][joueur1.PositionX] = "1";
		Grille[joueur2.PositionY][joueur2.PositionX] = "2";
	}
	
	// Renvoie le GameBoard modifié si pas de problème d'orientation, sinon le GameBoard initial

	public GameBoard Play(Player player, char move){
		
		if(player.Oriente == move){
			return this;
		}
		
		this.Grille[player.PositionY][player.PositionX] = "+";
		
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
	
	public ArrayList<GameBoard> next(Player player, Player passif) {
		
		ArrayList<GameBoard> GMPossible = new ArrayList<GameBoard>();
		Player joueur;
		GameBoard gm;
		
		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if (joueur.PositionY > 0 && player.Oriente != 'h') {
			if (gm.Grille[joueur.PositionY-1][joueur.PositionX] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'h', passif);
			}
		}
		
		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionY < this.Hauteur-1 && player.Oriente != 'b') {
			if (gm.Grille[joueur.PositionY+1][joueur.PositionX] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'b', passif);
			}
		}

		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX > 0 && player.Oriente != 'g') {
			if (gm.Grille[joueur.PositionY][joueur.PositionX-1] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'g', passif);
			}
		}

		gm = CopyGameBoard(this);
		joueur = new Player(player.Id, player.PositionX, player.PositionY, player.Oriente);
		if(joueur.PositionX < this.Longueur-1 && player.Oriente != 'd') {
			if (gm.Grille[joueur.PositionY][joueur.PositionX+1] == ".") {
				GMPossible = AjoutGameBoard(GMPossible, gm, joueur, 'd', passif);
			}
		}
		
		return GMPossible;
	}
	
	public static ArrayList<GameBoard> AjoutGameBoard (ArrayList<GameBoard> ListeGB, GameBoard GB, Player joueur, char move, Player passif) {

		GB.Play(joueur, move);
		GB.Coup = move;
		GB.joueur1 = joueur;
		GB.joueur2 = passif;
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
	
	public String lireCase(int x, int y) {
		return Grille[x][y];
	}
}
