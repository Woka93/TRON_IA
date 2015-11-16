package moteur;

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
}
