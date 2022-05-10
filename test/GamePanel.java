import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	ImageLoader cell = new ImageLoader("cell with box.png");
	ImageLoader menu = new ImageLoader("HomePage.jpg");
	ImageLoader dog = new ImageLoader("DOG WITH BOWL.png");
	ImageLoader celldoor = new ImageLoader("PrisonDoor.jpg");
	ImageLoader steps = new ImageLoader("stepsDown.jpg");
	ImageLoader hall = new ImageLoader("hall.jpg");
	ImageLoader vent = new ImageLoader("InsideVent.png");

	Timer FrameDraw;
	Font titleFont = new Font("Utopia", Font.PLAIN, 48);

	GamePanel() {

		FrameDraw = new Timer(1000 / 60, this);
		FrameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		}
		if (currentState == START) {
			drawStartState(g);
		}
		if (currentState == RIGHT) {
			drawRightState(g);
		}
		if (currentState == LEFT) {
			drawLeftState(g);
		}
		if(currentState == STEPS) {
			drawStepState(g);
		}
		if (currentState == HALLWAY) {
			drawHallState(g);
		}
		if(currentState == VENT) {
			drawVentState(g);
		}
	}

	final int MENU = 0;
	final int START = 1;
	final int RIGHT = 2;
	final int LEFT = 3;
	final int STEPS = 4;
	final int HALLWAY = 5;
	final int VENT = 6;
	
	
	int currentState = MENU;

	void drawMenuState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 850, 550);
		if (menu.gotImage) {
			g.drawImage(menu.image, 0, 0, 850, 550, null);
		}
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("POUND ESCAPE", 260, 200);
		g.setColor(Color.GRAY);
		g.drawString("Press enter to start", 230, 500);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Press space for instructions", 140, 396);

		
	}
	

	void drawStartState(Graphics g) {
		if (cell.gotImage) {
			g.drawImage(cell.image, 0, 0, 850, 550, null);
		}

	}

	void drawRightState(Graphics g) {
		if (celldoor.gotImage) {
			g.drawImage(celldoor.image, 0, 0, 850, 550, null);
		}
	}

	void drawLeftState(Graphics g) {
		if(dog.gotImage)
			g.drawImage(dog.image,0, 0, 850, 550, null);
	}
	void drawStepState(Graphics g) {
		if(steps.gotImage) {
			g.drawImage(steps.image, 0,0, 850,550, null);
			g.setColor(Color.white);
			g.drawString("(down arrow)", 200, 500);
		}
		
	}
	void drawHallState(Graphics g) {
		if (hall.gotImage) {
			g.drawImage(hall.image, 0, 0, 850, 550, null);
		}
	}
	void drawVentState(Graphics g) {
		if(vent.gotImage) {
			g.drawImage(vent.image, 0, 0, 850, 550, null);
			g.setColor(Color.WHITE);
			g.drawString("(down arrow to get back)", 200, 200);
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(key ==1) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP && currentState == RIGHT) {
			currentState = STEPS;
			System.out.println("steps");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU) {
			JOptionPane.showMessageDialog(null, "Click around different rooms to find items"
					+ " \n Use the RIGHT and LEFT arrow keys to switch rooms.");
		}
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER && currentState == MENU) {
			currentState = START;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == START) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = RIGHT;

		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == LEFT) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = START;

		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == START) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = LEFT;

		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == RIGHT) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = START;
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && currentState == STEPS) {
			System.out.println("hall");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = HALLWAY;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN && currentState == VENT) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = LEFT;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		// TODO Auto-generated method stud

	}
	int hat = 0;
	int underBed = 0;
	int key = 0;
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getLocationOnScreen());
		int x = arg0.getX();
		int y = arg0.getY();
			if (currentState == START) {
				if(x>=55&&x<=168&&y>=441&&y<=504) {
					JOptionPane.showMessageDialog(null, "Inside the box you find a old dog toy.");
					int hat = 1;
				}
				if (x>=713&&x<=784&&y>=410&&y<=764) {
					System.out.println("s");
					if (underBed == 0) {
						underBed = 1;
						JOptionPane.showMessageDialog(null, "In the mousehole you find a mouse with a key. "
								+ "\n\"If you want my key, you'll have to answer my riddle!! \"");
						String input = JOptionPane.showInputDialog("JASON IS DEAD."
								+ "\nHE HAS AN IRON BAR ACROSS HIS BACK AND THERE IS SOME FOOD IN FRONT OF HIM."
								+ "\nWHAT DID THIS TO HIM?");
						
							if(input.equals("A mousetrap")|| input.equals("a mousetrap")||input.equals("Mousetrap")||input.equals("mousetrap")) {
								JOptionPane.showMessageDialog(null, "Correct! Here you go (the mouse gives you the key)");
								key = 1;
							}
							else {
								JOptionPane.showMessageDialog(null, "WRONG");
								underBed = 0;
							}
							
					}

			}
			
			}
			
			if(currentState == RIGHT) {
				if(x < 719 && x > 127 && y < 510 && y > 64) {
					if(key == 1) {
					JOptionPane.showMessageDialog(null, "The key unlocks the door (up arrow to go through");
					}
					if(key == 0) {
					JOptionPane.showMessageDialog(null, "The door is locked.. You need a key..");
					}
				}
			}
			if(currentState == LEFT) {
				if(x>=54&&x<=131&&y>=110&&y<=180) {
					System.out.println("J");
					currentState = VENT;
				}
				if(x>=12&&x<=197&&y>=327&&y<=573) {
					JOptionPane.showMessageDialog(null, "Psst... Can you do me a favor?"
							+ "\n");
				}
				
				
				
			}
			if(currentState == VENT) {
				if(x>=267&&x<=346&&y>=415&&y<=453) {
					JOptionPane.showMessageDialog(null, "A mouse caught in a mousetrap..."
							+ "\nA little sign says that its name is Jason.");
				}
			}
			
//Y IS ALWAYS -20
		
//Bottom left: 526, 341
//Bottom right: 687, 342
//Top right: 691, 300
//Top left: 526, 296

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {

		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}
}