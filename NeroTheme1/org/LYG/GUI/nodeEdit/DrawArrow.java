package org.LYG.GUI.nodeEdit;
import java.awt.*;
public class DrawArrow{
	public DrawArrow(Graphics2D g2, int x, int y, int connectx, int connecty) {
		x += 10;
		connectx -= 10;
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		drawCurve(g2, x, y, connectx, connecty, 6);
		DrawSinLine.drawHead(connectx-8, connecty-3, g2);
	}
	
	private void drawCurve(Graphics2D g2, int x, int y, int connectx, int connecty, double scale) {
			double distanceX = Math.abs(x - connectx);
			double distanceY = Math.abs(y - connecty);		
		    double signOfPointX = (x - connectx < 0)? 1: -1;
			double signOfPointY = (y - connecty < 0)? 1: -1;
			double averageOfDistanceY = (distanceX == 0)?0: distanceY/distanceX;		
			if(signOfPointX == 1) {
				for(int c = 0, i = x; i < connectx - 9; c++, i++) {
					double registerY = y + averageOfDistanceY * c * signOfPointY + scale * Math.sin(averageOfDistanceY * c / 6);
					g2.drawLine(i, (int)registerY , i, (int)registerY);
				}
			}	
			if(signOfPointX == -1) {
				for(int c = 0, i = x; i > connectx + 9; c++, i--) {
					double registerY = y + averageOfDistanceY * c * signOfPointY + scale * Math.sin(averageOfDistanceY * c / 6 );
					g2.drawLine(i, (int)registerY , i, (int)registerY);
				}
			}
	}
}