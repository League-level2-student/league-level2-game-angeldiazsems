import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EscapeGame {
	
	public static void main(String[] args) {
		EscapeGame escape = new EscapeGame();
		escape.setup();
	}
	JFrame frame;
	GamePanel panel;
	
	EscapeGame() {
		this.frame = new JFrame();
		this.panel = new GamePanel();
		
	}

	public static final int WIDTH = 850;
	public static final int HEIGHT = 550;

	public void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(850,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);

	}
}
//615 = 642
//550 = 577