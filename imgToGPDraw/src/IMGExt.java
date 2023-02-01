


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


// Construct and initialize a student-made object (R.2.1)
public class IMGExt {
	BufferedImage image;
	IMGExt(String dir) throws IOException{
		image = ImageIO.read(new File(dir));
	}
	IMGExt() throws IOException{
		image = ImageIO.read(new File("C:\\Users\\astellato\\eclipse-workspace\\playground\\src\\playgrond\\MidTerm\\static-frames\\test\\test2.png"));
	}

	void setImage(String dir) throws IOException {
		image = ImageIO.read(new File(dir));
	}
	// non-void method (R.2.3)
	double[][] toArr(){
		double[][] res = new double[image.getHeight()][image.getWidth()];
		// Iteration (R.4)
		for(int y = image.getHeight()-1; y > -1 ; y--) {
			for(int x = image.getWidth()-1; x > -1 ; x--) {
				int pColor = image.getRGB(x,y);
				double[] vRGB = {
						((pColor & 0xff0000) >> 16) / 255.0,
						((pColor & 0xff00) >> 8) / 255.0,
						(pColor & 0xff) / 255.0};
				double luminance =  (0.2126 * sRGBtoLin(vRGB[0]) + 0.7152 * sRGBtoLin(vRGB[1]) + 0.0722 * sRGBtoLin(vRGB[2]));
				res[y][x] = YtoLstar(luminance) / 100.0;
			}
		}
		return res;
	}
	// non-void method (R.2.3)
	double sRGBtoLin(double colorChannel){
		// decision making breakdown (R.3)
		 if(colorChannel <= 0.04045){
			 return colorChannel / 12.92;
	        } else {
	            return Math.pow((( colorChannel + 0.055)/1.055),2.4);
	        }
	}
	double YtoLstar(double Luminance) {
		// decision making breakdown (R.3)
		 if ( Luminance <= (216/24389.0)) {
	            return Luminance * (24389/27.0);
	        } else {
	            return Math.pow(Luminance,(1/3.0)) * 116 - 16;
	        }
	}
}
