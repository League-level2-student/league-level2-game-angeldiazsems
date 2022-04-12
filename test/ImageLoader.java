import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader extends GamePanel{

	public static BufferedImage image5;
	public static boolean needImage5 = true;
	public static boolean gotImage5 = false;
	ImageLoader(){

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
}
	
	

