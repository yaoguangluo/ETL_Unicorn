package org.LYG.GUI.nodeEdit;
import java.awt.Graphics2D;

import org.LYG.GUI.theme.neroCell.DrawNeroCellMask31;
import org.LYG.GUI.theme.neroCell.DrawNeroCellMask32;
public class DrawSinLine{
	public static void drawCosLine(int x0, int y0, Graphics2D g2) {
		DrawNeroCellMask31 drawMask = new DrawNeroCellMask31();
		for(int y = 0; y < drawMask.neroShape.length; y++) {
			for(int x = 0; x < drawMask.neroShape[0].length; x++) {
				if(1 == drawMask.neroShape[y][x]) {
					g2.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}

	public static void drawSinLine(int x0, int y0, Graphics2D g2) {
		DrawNeroCellMask32 drawMask = new DrawNeroCellMask32();
		for(int y = 0; y < drawMask.neroShape.length; y++) {
			for(int x = 0; x < drawMask.neroShape[0].length; x++) {
				if(1 == drawMask.neroShape[y][x]) {
					g2.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}
}