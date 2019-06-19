package org.LYG.GUI.nodeEdit;
import java.awt.Color;
import java.awt.Graphics2D;
public class DrawFlashSide{
	public static void drawFlashSide(Graphics2D g2, int x, int y, int flash) {	
		if(0>= flash){
			g2.setColor(Color.blue);
			DrawSinLine.drawCosLine(x, y , g2);
			g2.setColor(Color.pink);
			DrawSinLine.drawSinLine(x, y , g2);
		}
		if(1== flash){
			g2.setColor(Color.ORANGE);
			DrawSinLine.drawCosLine(x, y , g2);
			g2.setColor(Color.blue);
			DrawSinLine.drawSinLine(x, y , g2);
		}
		if(2<= flash){
			g2.setColor(Color.ORANGE);
			DrawSinLine.drawCosLine(x, y , g2);
			g2.setColor(Color.RED);
			DrawSinLine.drawSinLine(x, y , g2);
		}	
		drawConnect(g2, x, y);	
	}
	//for cell postfix 
	private static void drawConnect(Graphics2D g2, int x, int y) {
		g2.drawOval(x + 10, y - 8, 4, 4);
		g2.drawOval(x - 8, y + 22, 4, 4);
		g2.drawOval(x + 2, y + 52, 4, 4);
		g2.drawOval(x + 62, y + 26, 4, 4);	
	}
}