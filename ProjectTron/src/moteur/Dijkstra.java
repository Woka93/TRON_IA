package last;

public class Dijkstra {
	
	GameBoard plateau;
	
	public Dijkstra (GameBoard plateau) {
		this.plateau = plateau;
	}
	
	public int Evaluation (Player joueur1, Player joueur2) {
		return value(joueur1, calculer(joueur1), calculer(joueur2));
	}
	
	public GameBoard calculer(Player joueur) {
		
		GameBoard gb = new GameBoard();
		
		for (int i = 0; i < plateau.Hauteur; i++) {
			for (int j = 0; j < plateau.Longueur; j++) {
				if (plateau.Grille[i][j] == "." ) {
					gb.Grille[i][j] = ".";
				}
				if (plateau.Grille[i][j] != "." ) {
					gb.Grille[i][j] = "+";
				}
				if (plateau.Grille[i][j] == joueur.Id) {
					gb.Grille[i][j] = "0";
				}
			}
		}
		
		int continuer = 0;
		
		while (continuer < 20) {
			for (int i = 0; i < gb.Hauteur; i++) {
				for (int j = 0; j < gb.Longueur; j++) {
					if (gb.lireCase(i, j) != "." && gb.lireCase(i, j) != "+") {
						if (i > 0 && gb.Grille[i-1][j] == ".") {
							gb.Grille[i-1][j] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						
						if (i < gb.Hauteur-1 && gb.Grille[i+1][j] == ".") {
							gb.Grille[i+1][j] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						
						if (j > 0 && gb.Grille[i][j-1] == ".") {
							gb.Grille[i][j-1] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
						
						if (j < gb.Hauteur-1 && gb.Grille[i][j+1] == ".") {
							gb.Grille[i][j+1] = String.valueOf(Integer.parseInt(gb.lireCase(i,j)) + 1);
						}
					}
				}
			}
			continuer++;
		}
		
		return gb;
	}
	
	public int value(Player joueur, GameBoard gmjoueur1, GameBoard gmjoueur2){
		String tab[][] = new String[gmjoueur1.Hauteur][gmjoueur1.Longueur];
		
		for (int i = 0; i < gmjoueur1.Hauteur; i++) {
			for (int j = 0; j < gmjoueur1.Longueur; j++) {
				if(gmjoueur1.lireCase(i, j) == "." || gmjoueur2.lireCase(i, j) == "."){
					tab[i][j] = ".";
				}else if(gmjoueur1.lireCase(i, j) != "+" && gmjoueur1.lireCase(i, j) != "0"){
					if(Integer.parseInt(gmjoueur1.Grille[i][j]) < Integer.parseInt(gmjoueur2.Grille[i][j])){
						tab[i][j] = "1";
					}else if(Integer.parseInt(gmjoueur1.Grille[i][j]) > Integer.parseInt(gmjoueur2.Grille[i][j])){
						tab[i][j] = "2";
					}else{
						tab[i][j] = "0";
					}
				}else{
					tab[i][j] = "+";
				}
			}
		}
		
		return compter(tab, joueur.Id);
	}
	
	private int compter(String[][] tab, String joueur){
		int cpt = 0;
		
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab.length; j++){
				if(tab[i][j] == joueur){
					cpt++;
				}
			}		
		}
		return cpt;
	}
}
