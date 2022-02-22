import javax.swing.JFrame;


public class EscapeGame {
	public static void main(String[] args) {
		EscapeGame escape = new EscapeGame();
		escape.setup();
	}

	EscapeGame() {
		JFrame frame = new JFrame();
		GamePanel panel = new GamePanel();
		frame.add(panel);
	}

	public void setup() {
		frame.setVisible(true);
	}
}
