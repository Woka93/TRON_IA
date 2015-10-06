package moteur;

import java.util.List;

public class GameBoard {
	
	int Longueur;
	int Hauteur;
	char[][] Grille; 
	
	public GameBoard(){
		
		this.Longueur = 10;
		this.Hauteur = 10;
		this.Grille = new char[this.Hauteur][this.Longueur];
		
	}
	
	public void InitGrille(){
		for(int i = 0; i < Hauteur; i++){
			for(int j = 0; j < Longueur; j++){
				Grille[i][j] = '.';
			}
		}
	}
	
	public char[][] Play(Player player, char move){
		
		if(player.Oriente == move){
			return null;
		}
		
		this.Grille[player.PositionX][player.PositionY] = '+';
		
		switch(move){
		
			case 'h' :  
						Grille[player.PositionY-1][player.PositionX] = player.Id;
						break; 
		
			case 'b' : 	
						Grille[player.PositionY+1][player.PositionX-1] = player.Id;
						break;
			
			case 'g' :  
						Grille[player.PositionY][player.PositionX-1] = player.Id;
						break;
			
			case 'd' :  
						Grille[player.PositionY][player.PositionX+1] = player.Id;
						break;
		}
		
		return Grille;
	}
	
}
