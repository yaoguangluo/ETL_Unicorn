package org.LYG.GUI.nodeEdit;
import java.awt.Graphics2D;
import org.LYG.GUI.theme.neroCell.DrawArrowHead;
import org.LYG.GUI.theme.neroCell.DrawNeroCellMask31;
import org.LYG.GUI.theme.neroCell.DrawNeroCellMask32;
public class DrawSinLineVPS{
	public static void drawCosLine(int x0, int y0, Graphics2D graphics2D) {
		for(int y= 0; y< DrawNeroCellMask31.neroShape.length; y++) {
			for(int x= 0; x < DrawNeroCellMask31.neroShape[0].length; x++) {
				if(1== DrawNeroCellMask31.neroShape[y][x]) {
					graphics2D.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}

	public static void drawSinLine(int x0, int y0, Graphics2D graphics2D) {
		for(int y= 0; y < DrawNeroCellMask32.neroShape.length; y++) {
			for(int x= 0; x < DrawNeroCellMask32.neroShape[0].length; x++) {
				if(1== DrawNeroCellMask32.neroShape[y][x]) {
					graphics2D.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}

	public static void drawHead(int x0, int y0, Graphics2D graphics2D) {
		for(int y= 0; y < DrawArrowHead.neroShape.length; y++) {
			for(int x= 0; x < DrawArrowHead.neroShape[0].length; x++) {
				if(1== DrawArrowHead.neroShape[y][x]) {
					graphics2D.drawLine(x + x0, y + y0, x + x0, y + y0);
				}
			}
		}
	}
}