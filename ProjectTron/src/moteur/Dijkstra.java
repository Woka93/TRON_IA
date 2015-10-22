package moteur;

public class Dijkstra {
	
	GameBoard plateau;
	Player joueur;
	
	public Dijkstra (GameBoard plateau, Player joueur) {
		this.plateau = plateau;
		this.joueur = joueur;
	}
	
	public GameBoard calculer() {
		
		GameBoard gb = new GameBoard();
		
		for (int i = 0; i < plateau.Hauteur; i++) {
			for (int j = 0; j < plateau.Longueur; j++) {
				if (plateau.Grille[i][j] == "+") {
					gb.Grille[i][j] = "+";
				}
			}
		}
		gb.Grille[joueur.PositionY][joueur.PositionX] = "0";
		
		for(int i = 0; i < gb.Hauteur; i++){
			for(int j = 0; j < gb.Longueur; j++){
				System.out.print(gb.Grille[i][j]);
			}
			System.out.print("\n");
		}
		
		int continuer = 0;
		
		//while (continuer < 5) {
			for (int i = 0; i < gb.Hauteur; i++) {
				for (int j = 0; j < gb.Longueur; j++) {
					System.out.println("i : " + i);
					System.out.println("j : " + j);
					System.out.println("c : " + gb.lireCase(i, j));
					if (gb.lireCase(j, j) != ".") {
						System.out.println("coucou");
						if (i > 0) {
							gb.Grille[i-1][j] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						if (i < gb.Hauteur-1) {
							gb.Grille[i+1][j] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						if (j > 0) {
							gb.Grille[i][j-1] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						if (j < gb.Hauteur-1) {
							gb.Grille[i][j+1] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
					}
				}
			}
			continuer++;
		//}
		
		return gb;
	}
	
}
