import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {


	Timer FrameDraw;
	Font titleFont = new Font("Utopia", Font.PLAIN, 48);
	
	GamePanel(){

	FrameDraw = new Timer(1000/60, this);
	FrameDraw.start();
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

	
	final int MENU = 0;
	final int START = 1;
	final int RIGHT = 2;
	final int LEFT = 3;
	
	int currentState = MENU;
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 800, 500);
		g.setFont(titleFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("POUND ESCAPE", 240, 100);
		g.drawString("Press enter to start", 200, 400);
	}
	void drawStartState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 800, 500);
	}
	void drawRightState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 800, 500);
		g.drawString("RIGHT ROOM", 100, 100);
	}
	void drawLeftState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 500);
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
		repaint();
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER && currentState == MENU) {
			currentState = START;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == LEFT) {
			currentState = START;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == RIGHT) {
			System.out.println("e");
			currentState = START;
			}
		
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && currentState == START) {
			currentState = RIGHT;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && currentState == START) {
			currentState = LEFT;

		}
		
	}
		

	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
