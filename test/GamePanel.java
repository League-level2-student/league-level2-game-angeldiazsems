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

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public static BufferedImage image2;
	public static boolean needImage2 = true;
	public static boolean gotImage2 = false;
	
	public static BufferedImage image3;
	public static boolean needImage3 = true;
	public static boolean gotImage3 = false;
	
	public static BufferedImage image4;
	public static boolean needImage4 = true;
	public static boolean gotImage4 = false;

	public static BufferedImage image5;
	public static boolean needImage5 = true;
	public static boolean gotImage5 = false;
	Timer FrameDraw;
	Font titleFont = new Font("Utopia", Font.PLAIN, 48);

	GamePanel() {

		FrameDraw = new Timer(1000 / 60, this);
		FrameDraw.start();

		if (needImage) {
			loadImage("PrisonCell.jpg");
		}
		if (needImage2) {
			loadImage2("HomePage.jpg");
		}
		if (needImage3) {
			loadImage3("PrisonDoor2.jpg");
		}
		if (needImage4) {
			loadImage4("stepsDown.jpg");
		}
		if (needImage5) {
			loadImage5("hall3.jpg");
		}
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
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void loadImage2(String imageFile) {
		if (needImage2) {
			try {
				image2 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage2 = true;
			} catch (Exception e) {

			}
			needImage2 = false;
		}
	}
	void loadImage3(String imageFile) {
		if (needImage3) {
			try {
				image3 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage3 = true;
			} catch (Exception e) {

			}
			needImage3 = false;
		}
	}
	void loadImage4(String imageFile) {
		if (needImage4) {
			try {
				image4 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage4 = true;
			} catch (Exception e) {

			}
			needImage4 = false;
		}
	}
	void loadImage5(String imageFile) {
		if (needImage5) {
			try {
				image5 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage5 = true;
			} catch (Exception e) {

			}
			needImage5 = false;
		}
	}
	final int MENU = 0;
	final int START = 1;
	final int RIGHT = 2;
	final int LEFT = 3;
	final int STEPS = 4;
	final int HALLWAY = 5;
	
	
	
	
	int currentState = MENU;

	void drawMenuState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 850, 550);
		if (gotImage2) {
			g.drawImage(image2, 0, 0, 850, 550, null);
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
		if (gotImage) {
			g.drawImage(image, 0, 0, 850, 550, null);
		}

	}

	void drawRightState(Graphics g) {
		if (gotImage3) {
			g.drawImage(image3, 0, 0, 850, 550, null);
		}
	}

	void drawLeftState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 850, 550);
		g.drawString("LEFT ROOM", 50, 100);
	}
	void drawStepState(Graphics g) {
		if(gotImage4) {
			g.drawImage(image4, 0,0, 850,550, null);
			g.setColor(Color.white);
			g.drawString("(down arrow)", 200, 500);
		}
		
	}
	void drawHallState(Graphics g) {
		if (gotImage5) {
			g.drawImage(image5, 0, 0, 850, 550, null);
		}
	}

	void updateLeftState() {
	}

	void updateRightState() {
	}

	void updateStartState() {
	}

	void updateMenuState() {
	}
	void updateStepState() {
	}
	void updateHallState() {
	
}
		
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == START) {
			updateStartState();
		} else if (currentState == RIGHT) {
			updateRightState();
		} else if (currentState == LEFT) {
			updateLeftState();
		}
		else if (currentState == STEPS) {
			updateStepState();
		}
		else if(currentState == HALLWAY) {
			updateHallState();
		}
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
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		// TODO Auto-generated method stud

	}

	int underBed = 0;
	int key = 0;
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getLocationOnScreen());
		int x = arg0.getX();
		int y = arg0.getY();
			if (currentState == START) {
				if (x < 180 && x > 12 && y > 473 && y < 550|| x > 180 && x < 436 && y > 455 && y < 570) {
					System.out.println("s");
					if (underBed == 0) {
						underBed = 1;
						JOptionPane.showMessageDialog(null, "Under the bed you find a mouse with a key. "
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