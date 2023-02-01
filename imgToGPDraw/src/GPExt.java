


import java.awt.Color;
import java.util.Arrays;
import gpdraw.*;



public class GPExt {
	SketchPad frame;
	DrawingTool pen;
	double[][] frameEnum;
	double[][] blank;

	double[] offset = new double[2];

	GPExt(int x , int y){
		frame = new SketchPad(x,y,0);
		pen = new DrawingTool(frame);



		frameEnum  = new double[y][x];
		blank = frameEnum.clone();
		// Iteration (R.4)
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				blank[i][j] -= 1;
			}
		}



		offset[0] = x / 2;
		offset[1] = y / 2;
	}

	// Mutator Method (R.2.2)
	void setPixel(int x, int y,double bit) {
		frameEnum[y][x] = bit;
	}

	// Mutator Method (R.2.2)
	void setFrame(double[][] frame) {
		frameEnum = frame;
	}


	void setOffset(double x, double y) {
		offset[0] = x;
		offset[1] = y;
	}

	void pushChange(IMGExt ImageHandler) {
		// Iteration (R.4)
		for(int y = 0; y < frameEnum.length; y++) {
			for(int x = 0; x < frameEnum[0].length; x++) {
				pen.up();
				pen.move(x + offset[0],y + offset[1]);
				pen.down();
				if(frameEnum[y][x] >= 0) {
					pen.setColor(new Color(ImageHandler.image.getRGB(x, ImageHandler.image.getHeight()-1 - y)));
				} else {
					pen.setColor(new Color(255,255,255));
				}
				pen.drawRect(1,1);
			}
		}
	}
	void clearSection(int x , int y ) {
		pen.move(x,y);
		pen.down();
		pen.setColor(Color.GREEN);

		pen.fillRect(100, 100);
		pen.up();
	}

	
	
	void printFrame() {
		System.out.println(Arrays.deepToString(frameEnum));
	}

}