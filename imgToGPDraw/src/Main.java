import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		GPExt FrameHandler = new GPExt(750,500);
		IMGExt ImageHandler = new IMGExt("C:\\Users\\astellato\\Downloads\\test.png");
		
		FrameHandler.setOffset(-350,-250);
		FrameHandler.setFrame(ImageHandler.toArr());
		FrameHandler.pushChange(ImageHandler);
	}
}
