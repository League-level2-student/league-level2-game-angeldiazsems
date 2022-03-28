import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader extends GamePanel{

	public static BufferedImage image2;
	public static boolean needImage2 = true;
	public static boolean gotImage2 = false;
	ImageLoader(){
		if (needImage2) {
		    loadImage2("HomePage.jpg");
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
	
	void drawImage(Graphics g) {
	if (gotImage2) {
				g.drawImage(image2, 0, 0, 850, 550, null);
			} 
	}
	
	
	

}
