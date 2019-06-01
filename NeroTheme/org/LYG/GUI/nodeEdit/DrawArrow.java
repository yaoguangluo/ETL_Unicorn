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
			double signOfPointYWithaverageOfDistanceY= averageOfDistanceY*signOfPointY;
			double oldRegisterY=0;
			boolean firstTime= true;
			if(signOfPointX == 1) {
				for(int c = 0, i = x; i < connectx - 16; c+= 8, i+= 8) {
					double registerY = y + signOfPointYWithaverageOfDistanceY * c  + scale * Math.sin(averageOfDistanceY * c / 6);
					g2.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY , i+8, (int)registerY);
					oldRegisterY= registerY;
					firstTime= false;
				}
			}	
			if(signOfPointX == -1) {
				for(int c = 0, i = x; i > connectx + 2; c+= 8, i-= 8) {
					double registerY = y + signOfPointYWithaverageOfDistanceY * c + scale * Math.sin(averageOfDistanceY * c / 6 );
					g2.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY , i-8, (int)registerY);
					oldRegisterY=registerY;
					firstTime= false;
				}
			}
	}
}