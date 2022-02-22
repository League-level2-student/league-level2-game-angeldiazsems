import javax.swing.JFrame;
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

	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	
	
	public void setup() {
		frame.setVisible(true);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}
}
