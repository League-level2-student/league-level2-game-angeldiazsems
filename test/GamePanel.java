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
	// everything
	ImageLoader celldoor = new ImageLoader("NEWDOOR2.png");
	// no bone
	ImageLoader celldoor2 = new ImageLoader("NEWPRISONDOOR.png");
	// nothing
	ImageLoader celldoor3 = new ImageLoader("PrisonDoor.jpg");
	// bone
	ImageLoader celldoor4 = new ImageLoader("door2.png");
	ImageLoader steps = new ImageLoader("stepsDown.jpg");
	ImageLoader hall = new ImageLoader("BOARD DOOR.png");
	ImageLoader hall2 = new ImageLoader("keypadd.png");
	ImageLoader vent = new ImageLoader("Vent with paper.png");
	ImageLoader paradise = new ImageLoader("grass.jpg");

	Timer FrameDraw;
	Font titleFont = new Font("Utopia", Font.PLAIN, 48);
	Font small = new Font("Utopia", Font.PLAIN, 40);
	Font smallee = new Font("Utoptia", Font.PLAIN, 30);
	Font smaller = new Font("Utoptia", Font.PLAIN, 23);
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
		if (currentState == STEPS) {
			drawStepState(g);
		}
		if (currentState == HALLWAY) {
			drawHallState(g);
		}
		if (currentState == VENT) {
			drawVentState(g);
		}
		if (currentState == PARADISE) {
			drawParadiseState(g);
		}
	}

	final int MENU = 0;
	final int START = 1;
	final int RIGHT = 2;
	final int LEFT = 3;
	final int STEPS = 4;
	final int HALLWAY = 5;
	final int VENT = 6;
	final int PARADISE = 7;

	int currentState = MENU;

	void drawMenuState(Graphics g) {
		if (menu.gotImage) {
			g.drawImage(menu.image, 0, 0, 850, 515, null);
		}
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("POUND ESCAPE", 260, 200);
		g.setColor(Color.GRAY);
		g.drawString("Press enter to start", 230, 500);
		g.setFont(small);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Press space for instructions & backstory", 60, 371);

	}

	void drawStartState(Graphics g) {
		if (cell.gotImage) {
			g.drawImage(cell.image, 0, 0, 850, 515, null);
		}

	}

	void drawRightState(Graphics g) {
		if (bone == 0 && afterkey == 0) {
			if (celldoor.gotImage) {
				g.drawImage(celldoor.image, 0, 0, 850, 515, null);
			}
		}
		if (bone == 1 && afterkey == 0) {
			if (celldoor2.gotImage) {
				g.drawImage(celldoor2.image, 0, 0, 850, 515, null);
			}
		}
		if (bone == 0 && afterkey == 1) {
			if (celldoor4.gotImage) {
				g.drawImage(celldoor4.image, 0, 0, 850, 515, null);
			}
		}
		if (bone == 1 && afterkey == 1) {
			if (celldoor3.gotImage) {
				g.drawImage(celldoor3.image, 0, 0, 850, 515, null);
			}
		}
	}

	void drawLeftState(Graphics g) {
		if (dog.gotImage)
			g.drawImage(dog.image, 0, 0, 850, 515, null);
	}

	void drawStepState(Graphics g) {
		if (steps.gotImage) {
			g.drawImage(steps.image, 0, 0, 850, 515, null);
			g.setColor(Color.white);
			g.drawString("(up arrow to continue)", 200, 500);
		}

	}

	void drawHallState(Graphics g) {
		if (boards == 0) {
			if (hall.gotImage) {
				g.drawImage(hall.image, 0, 0, 850, 515, null);
				g.setColor(Color.white);
				g.drawString("(down arrow to go back)", 200, 500);

			}
		}
		if (boards == 1) {
			if (hall2.gotImage) {
				g.drawImage(hall2.image, 0, 0, 850, 515, null);
			}
		}

	}

	void drawVentState(Graphics g) {
		if (vent.gotImage) {
			g.drawImage(vent.image, 0, 0, 850, 515, null);
			g.setColor(Color.WHITE);
			g.drawString("(down arrow to get back)", 200, 200);
		}
	}
	void drawParadiseState(Graphics g) {
		if (paradise.gotImage) {
			g.drawImage(paradise.image, 0, 0, 850, 515, null);
			g.setFont(titleFont);
			g.setColor(Color.blue);
			g.drawString("You've escaped...", 260, 100);
			g.setFont(smaller);
			g.drawString("Once you left the pound, you quickly decided you want nothing to do",30 ,351 );
			g.drawString("with humans anymore. And after months of wandering, you finally ", 30, 391);
			g.drawString("found a paradise where you can live out the rest of your dog life in peace.", 5, 431);
			g.setColor(Color.white);
			g.setFont(smallee);
			g.drawString("THE END", 350, 500);
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

		if (arg0.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU) {

			JOptionPane.showMessageDialog(null,
					"You are a lonely dog who has been kidnapped and taken to the pound!"
							+ "\nYou get fed rarely and the cells are dirty, but the guards couldn't care less..",
					"BACKSTORY", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
					"However there is still hope..." + "\nThere are rumors that another dog has managed to escape,"
							+ "\nAnd if they can do it you can do it!" + "\nIt's time to get out of this place!",
					"BACKSTORY", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
					"Click around different rooms to find items"
							+ " \n Use the RIGHT and LEFT arrow keys to switch rooms.",
					"INSTRUCTIONS", JOptionPane.WARNING_MESSAGE);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER && currentState == MENU) {
			currentState = START;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_H && currentState == START) {
			JOptionPane.showMessageDialog(null, "Jason is a mouse", "HINT", JOptionPane.WARNING_MESSAGE);
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
		if (arg0.getKeyCode() == KeyEvent.VK_UP && currentState == STEPS) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = HALLWAY;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && currentState == STEPS) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = RIGHT;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && currentState == HALLWAY) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = STEPS;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && currentState == VENT) {
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

	int boards = 0;
	int KEYPADD = 0;
	int first = 0;
	int screw = 0;
	int bone = 0;
	int code = 0;
	int underBed = 0;
	int key = 0;
	int crowbar = 0;
	int afterkey = 0;

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getLocationOnScreen();
		int x = arg0.getX();
		int y = arg0.getY();
		if (currentState == START) {
			if (x >= 55 && x <= 168 && y >= 401 && y <= 464) {
				screw = 1;
				JOptionPane.showMessageDialog(null, "Inside the box you find a screwdriver.", "Item",
						JOptionPane.INFORMATION_MESSAGE);

			}
			if (x > 713 && x < 784 && y > 390 && y < 444) {
				if (underBed == 0) {
					JOptionPane.showMessageDialog(null,
							"In the mousehole you find a mouse with a key. "
									+ "\n\"If you want my key, you'll have to answer my riddle!! \""
									+ "\n(if you want a hint leave the question and press h)",
							"Mouse", JOptionPane.INFORMATION_MESSAGE);
					String input = JOptionPane.showInputDialog(null,
							"JASON IS DEAD."
									+ "\nHE HAS AN IRON BAR ACROSS HIS BACK AND THERE IS SOME FOOD IN FRONT OF HIM."
									+ "\nWHAT DID THIS TO HIM?",
							"Riddle", JOptionPane.QUESTION_MESSAGE);

					if (input.equals("A mousetrap") || input.equals("a mousetrap") || input.equals("Mousetrap")
							|| input.equals("mousetrap")) {
						JOptionPane.showMessageDialog(null, "Correct! Here you go (the mouse gives you the key)",
								"Mouse", JOptionPane.INFORMATION_MESSAGE);
						key = 1;
						underBed = 1;
					} else {
						JOptionPane.showMessageDialog(null, "WRONG", "Mouse", JOptionPane.ERROR_MESSAGE);
						underBed = 0;
					}

				}

			}

		}
		if (currentState == RIGHT) {
			if (x <= 718 && x >= 125 && y <= 482 && y >= 6) {
				if (afterkey == 1) {
					if (currentState == RIGHT) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						currentState = STEPS;
					}
				}

				if (key == 1 && afterkey == 0) {
					JOptionPane.showMessageDialog(null, "The key unlocks the door(click to go through)");
					afterkey = 1;
				}
				if (key == 0) {
					JOptionPane.showMessageDialog(null, "The door is locked.. You need a key..", "Door",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			if (x <= 810 && x >= 707 && y <= 534 && y >= 498) {
				bone = 1;
				JOptionPane.showMessageDialog(null, "You find a bone.", "Item", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		if (currentState == LEFT) {
			if (x >= 54 && x <= 131 && y >= 110 && y <= 180) {
				if (screw == 0) {
					JOptionPane.showMessageDialog(null, "You can't open the vent, you probably need a screwdriver.",
							"Vent", JOptionPane.ERROR_MESSAGE);

				}
				if (screw == 1) {
					JOptionPane.showMessageDialog(null, "The screwdriver opened the vent", "Vent",
							JOptionPane.INFORMATION_MESSAGE);
					currentState = VENT;

				}
			}
			if (x >= 12 && x <= 197 && y >= 327 && y <= 573) {

				if (first == 0) {
					String cherry = JOptionPane.showInputDialog(null,
							"Hey... What's black and white with a cherry on top?", "Mystery Dog",
							JOptionPane.QUESTION_MESSAGE);
					if (cherry.equals("A police car") || cherry.equals("a police car")) {
						JOptionPane.showMessageDialog(null, "Yeah... story of my life..", "Mystery Dog",
								JOptionPane.INFORMATION_MESSAGE);
						first = 1;
					} else {
						JOptionPane.showMessageDialog(null, "No.. a police car...", "Mystery Dog",
								JOptionPane.ERROR_MESSAGE);
						first = 1;
					}
				}
				JOptionPane.showMessageDialog(null,
						"Hey I know... can you do me a favor?"
								+ "\nI'm looking for a bone.. If you find it let me know",
						"Mystery Dog", JOptionPane.QUESTION_MESSAGE);
				if (bone == 1) {
					JOptionPane.showMessageDialog(null,
							"Oh you have it! Here take this crowbar that I happen to have :)", "Mystery Dog",
							JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "You recived a crowbar from the dog.", "Mystery Dog",
							JOptionPane.WARNING_MESSAGE);
					crowbar = 1;
				}

			}

		}
		if (currentState == VENT) {
			if (x >= 529 && x <= 579 && y >= 307 && y <= 340) {
				JOptionPane.showMessageDialog(null, "A paper note that says:" + "\n7362");

			}
		}
		if (currentState == HALLWAY) {
			if (x > 163 && x < 696 && y > 110 && y < 500) {
				if (crowbar == 1 && boards == 0) {
					JOptionPane.showMessageDialog(null, "The crowbar broke the boards!", "Door",
							JOptionPane.INFORMATION_MESSAGE);
					boards = 1;
				}
				if (crowbar == 0) {
					JOptionPane.showMessageDialog(null, "You need something to break the boards", "Door",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if (KEYPADD == 1 && boards == 1) {
					currentState = PARADISE;
				}
			}

			if (x > 714 && x < 827 && y > 291 && y < 339) {
				if(KEYPADD == 0) {
				String keypad = JOptionPane.showInputDialog(null, "ENTER 4 DIGIT KEY CODE: ", "Keypad",
						JOptionPane.WARNING_MESSAGE);
				if (keypad.equals("7362")) {
					JOptionPane.showMessageDialog(null, "CORRECT", "Keypad",
							JOptionPane.INFORMATION_MESSAGE);
					KEYPADD = 1;
				} else {
					JOptionPane.showMessageDialog(null, "INCORRECT", "Keypad", JOptionPane.ERROR_MESSAGE);
				}
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