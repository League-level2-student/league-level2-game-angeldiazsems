import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {

	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	ImageLoader(String image){
		if (needImage) {
			loadImage(image);
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
	
}
	
	

