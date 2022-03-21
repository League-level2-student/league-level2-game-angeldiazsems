import java.awt.Rectangle;

public class Objects {

Rectangle collisionBox;
	
	
	Objects(){
		collisionBox = new Rectangle(100,100,100,100);
	}
	void update() {
		
		collisionBox.setBounds(100, 100, 100, 100);
	}
}
