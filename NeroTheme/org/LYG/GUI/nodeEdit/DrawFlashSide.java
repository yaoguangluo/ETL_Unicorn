package org.LYG.GUI.nodeEdit;
import java.awt.Color;
import java.awt.Graphics2D;
public class DrawFlashSide{
	public static void drawFlashSide(Graphics2D graphics2D, int x, int y, int flash) {	
		if(0>= flash){
			graphics2D.setColor(Color.blue);
			DrawSinLineVPS.drawCosLine(x, y , graphics2D);
			graphics2D.setColor(Color.pink);
			DrawSinLineVPS.drawSinLine(x, y , graphics2D);
		}
		if(1== flash){
			graphics2D.setColor(Color.ORANGE);
			DrawSinLineVPS.drawCosLine(x, y , graphics2D);
			graphics2D.setColor(Color.blue);
			DrawSinLineVPS.drawSinLine(x, y , graphics2D);
		}
		if(2<= flash){
			graphics2D.setColor(Color.ORANGE);
			DrawSinLineVPS.drawCosLine(x, y , graphics2D);
			graphics2D.setColor(Color.RED);
			DrawSinLineVPS.drawSinLine(x, y , graphics2D);
		}	
		drawConnect(graphics2D, x, y);	
	}
	//for cell postfix 
	private static void drawConnect(Graphics2D graphics2D, int x, int y) {
		graphics2D.drawOval(x + 10, y - 8, 4, 4);
		graphics2D.drawOval(x - 8, y + 22, 4, 4);
		graphics2D.drawOval(x + 2, y + 52, 4, 4);
		graphics2D.drawOval(x + 62, y + 26, 4, 4);	
	}
}