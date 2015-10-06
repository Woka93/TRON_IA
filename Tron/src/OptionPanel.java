import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class OptionPanel extends JPanel{

	public static final Color Black = new Color(0000000);
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Tron tron = Tron.tron;
		
		//Mettre couleur arrière plan
		g.setColor(Black);
		g.fillRect(0, 0, 800, 700);
		
		g.setColor(Color.BLUE);
		
		/*for (Point point : tron.tronParts)
		{
			g.fillRect(point.x * Tron.SCALE, point.y * Tron.SCALE, Tron.SCALE, Tron.SCALE);
		}*/
		
		
		g.fillRect(tron.Player.x * Tron.SCALE, tron.Player.y * Tron.SCALE, Tron.SCALE, Tron.SCALE);
		g.setColor(Color.RED);
		g.fillRect(tron.Player2.x * Tron.SCALE, tron.Player2.y * Tron.SCALE, Tron.SCALE, Tron.SCALE);
	
		g.setColor(Color.GREEN);
		for (Point point2 : tron.tronParts)
		{
			g.fillRect(point2.x * Tron.SCALE, point2.y * Tron.SCALE, Tron.SCALE, Tron.SCALE);
		}
		
		
		
		g.setColor(Color.WHITE);
		String string = "Game Over!";

		if (tron.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) tron.dim.getHeight() / 4);
		}
	}
}
