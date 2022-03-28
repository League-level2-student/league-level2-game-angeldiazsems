import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;

public static BufferedImage image2;
public static boolean needImage2 = true;
public static boolean gotImage2 = false;
	Timer FrameDraw;
	Font titleFont = new Font("Utopia", Font.PLAIN, 48);
	
	
	GamePanel(){

	FrameDraw = new Timer(1000/60, this);
	FrameDraw.start();
	
	if (needImage) {
	    loadImage("PrisonCell.jpg");
	}
	if (needImage2) {
	    loadImage2("HomePage.jpg");
	}
	
	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU) {
			drawMenuState(g);
		}
		if(currentState == START) {
			drawStartState(g);
		}
		if(currentState == RIGHT) {
			drawRightState(g);
		}
		if(currentState == LEFT) {
			drawLeftState(g);
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

	
	final int MENU = 0;
	final int START = 1;
	final int RIGHT = 2;
	final int LEFT = 3;
	
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
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Press enter to start", 230, 500);
	}
	void drawStartState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, 850, 550, null);
		} 
		
	}
	void drawRightState(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 850, 550);
		
	}
	void drawLeftState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 850, 550);
		g.drawString("LEFT ROOM", 50, 100);
	}
	void updateLeftState() {		
	}
	 void updateRightState() {
	}
	 void updateStartState() {
	}
	 void updateMenuState() {
	}
	 
	
	 
	 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == START){
		    updateStartState();
		}else if(currentState == RIGHT){
		    updateRightState();
		}
		else if(currentState == LEFT){
		    updateLeftState();
		}
		 int mouseY = MouseInfo.getPointerInfo().getLocation().y; 
		 int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	//	System.out.println(mouseX+" , "+mouseY);
			repaint();
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER && currentState == MENU) {
			currentState = START;
		}
		
		
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == START) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = RIGHT;
			
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == LEFT) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = START;
			
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == START) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentState = LEFT;

		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == RIGHT) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("e");
			currentState = START;
		}
		
		if(arg0.getKeyCode() == MouseEvent.MOUSE_PRESSED) {
			System.out.println("TEST");
}
		
		
		
		
	}
	

	
	
	@Override
	public void keyReleased(KeyEvent arg0) {

		// TODO Auto-generated method stud		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

		// TODO Auto-generated method stub
	}

	
	
}