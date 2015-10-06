package moteur;

public class Player {
	
	char Id;
	int PositionX;
	int PositionY;
	// de la d'ou tu VIENS
	char Oriente;
	
	public Player(char Id, int PositionX, int PositionY, char Oriente){
		
		this.Id = Id;
		this.PositionX = PositionX;
		this.PositionY = PositionY;
		this.Oriente = Oriente;
		
	}
	
}
