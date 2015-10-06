import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Tron implements ActionListener, KeyListener{
	
	public static Tron tron;
	public OptionPanel optionpanel;
	public JFrame jframe;
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
	public ArrayList<Point> tronParts = new ArrayList<Point>();
	public int ticks = 0, direction = RIGHT, direction2 = LEFT, PlayerLength = 1, time;
	public Point Player;
	public Point Player2;
	public Dimension dim;
	public Timer timer = new Timer(50, this);
	public boolean over = false;
	
	public Tron()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Tron");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(optionpanel = new OptionPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}
	
	public void startGame(){
		time = 0;
		PlayerLength = 1;
		Player = new Point(0, 0);
		Player2 = new Point(79,66);
		
		timer.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tron = new Tron();
	}

	//POur toute touche presse
	
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_LEFT) && direction != RIGHT)
		{
			direction = LEFT;
		}

		if ((i == KeyEvent.VK_RIGHT) && direction != LEFT)
		{
			direction = RIGHT;
		}

		if ((i == KeyEvent.VK_UP) && direction != DOWN)
		{
			direction = UP;
		}

		if ((i == KeyEvent.VK_DOWN) && direction != UP)
		{
			direction = DOWN;
		}

		//==========================================
		
		if ((i == KeyEvent.VK_Q) && direction2 != RIGHT)
		{
			direction2 = LEFT;
		}

		if ((i == KeyEvent.VK_D) && direction2 != LEFT)
		{
			direction2 = RIGHT;
		}

		if ((i == KeyEvent.VK_Z) && direction2 != DOWN)
		{
			direction2 = UP;
		}

		if ((i == KeyEvent.VK_S) && direction2 != UP)
		{
			direction2 = DOWN;
		}
		
		//==========================================
		if (i == KeyEvent.VK_SPACE)
		{
			if (over)
			{
				startGame();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		optionpanel.repaint();
		ticks++;

		if (ticks % 2 == 0 && Player != null && !over)
		{
			time++;

			tronParts.add(new Point(Player.x, Player.y));

			if (direction == UP)
			{
				if (Player.y - 1 >= 0 && noWall(Player.x, Player.y - 1))
				{
					Player = new Point(Player.x, Player.y - 1);
				}
				else
				{
					over = true;

				}
			}

			if (direction == DOWN)
			{
				if (Player.y + 1 < 67 && noWall(Player.x, Player.y + 1))
				{
					Player = new Point(Player.x, Player.y + 1);
				}
				else
				{
					over = true;
				}
			}

			if (direction == LEFT)
			{
				if (Player.x - 1 >= 0 && noWall(Player.x - 1, Player.y))
				{
					Player = new Point(Player.x - 1, Player.y);
				}
				else
				{
					over = true;
				}
			}

			if (direction == RIGHT)
			{
				if (Player.x + 1 < 80 && noWall(Player.x + 1, Player.y))
				{
					Player = new Point(Player.x + 1, Player.y);
				}
				else
				{
					over = true;
				}
			}
			
			//=====================================
			if (ticks % 2 == 0 && Player2 != null && !over)
			{
				time++;

				tronParts.add(new Point(Player2.x, Player2.y));

				if (direction2 == UP)
				{
					if (Player2.y - 1 >= 0 && noWall(Player2.x, Player2.y - 1))
					{
						Player2 = new Point(Player2.x, Player2.y - 1);
					}
					else
					{
						over = true;

					}
				}

				if (direction2 == DOWN)
				{
					if (Player2.y + 1 < 67 && noWall(Player2.x, Player2.y + 1))
					{
						Player2 = new Point(Player2.x, Player2.y + 1);
					}
					else
					{
						over = true;
					}
				}

				if (direction2 == LEFT)
				{
					if (Player2.x - 1 >= 0 && noWall(Player2.x - 1, Player2.y))
					{
						Player2 = new Point(Player2.x - 1, Player2.y);
					}
					else
					{
						over = true;
					}
				}

				if (direction2 == RIGHT)
				{
					if (Player2.x + 1 < 80 && noWall(Player2.x + 1, Player2.y))
					{
						Player2 = new Point(Player2.x + 1, Player2.y);
					}
					else
					{
						over = true;
					}
				}
			}
				//===================================

		}
	}

	public boolean noWall(int x, int y)
	{
		for (Point point : tronParts)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
