import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		 *  Makes a new GPExt object which handles all GPDraw extended methods
		 *  of size 750 x 500
		 */
		GPExt FrameHandler = new GPExt(750,500);
		
		/*
		 *  Creates a new image object using IMGExt which handles all image
		 *  to pixel and position conversion. Also setting the file location of the img
		 */
		IMGExt ImageHandler = new IMGExt("C:\\Users\\astellato\\Downloads\\test.png");
		
		// Example of pushing changes to GPDraw
		FrameHandler.setOffset(-350,-250); // Offsets the image position
		FrameHandler.setFrame(ImageHandler.toArr()); // Sets the frame to the image chosen
		FrameHandler.pushChange(ImageHandler); // Pushing the changes
	}
}
