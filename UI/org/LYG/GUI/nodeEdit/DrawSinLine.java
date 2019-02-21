package org.LYG.GUI.nodeEdit;
import java.awt.Graphics2D;
public class DrawSinLine{
	public static void drawCosLine(int x0, int y0, Graphics2D g2) {
		DrawMask drawMask = new DrawMask();
		for(int y = 0; y < drawMask.neroShape.length; y++) {
			for(int x = 0; x < drawMask.neroShape[0].length; x++) {
				if(1 == drawMask.neroShape[y][x]) {
					g2.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}
}