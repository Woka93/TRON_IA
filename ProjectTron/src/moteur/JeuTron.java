package moteur;

public class JeuTron {
	
	public static void main(String[] args) {
		GameBoard Grille = new GameBoard();
		Grille.InitGrille();
		
		Player joueur1 = new Player('1',1,1,'b');
		
		//System.out.println(joueur1.PositionX);
		joueur1 = Grille.Play(joueur1, 'd');
		//System.out.println(joueur1.PositionX);
		joueur1 = Grille.Play(joueur1, 'd');
		
		Affichage(Grille);
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
