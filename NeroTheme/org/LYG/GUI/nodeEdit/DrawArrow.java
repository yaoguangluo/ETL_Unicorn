package org.LYG.GUI.nodeEdit;
import java.awt.*;
public class DrawArrow{
	public DrawArrow(Graphics2D g2, int x, int y, int connectX, int connectY) {
		x+= 10;
		connectX-= 10;
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		drawCurve(g2, x, y, connectX, connectY, 6);
		DrawSinLine.drawHead(connectX- 8, connectY- 3, g2);
	}

	private void drawCurve(Graphics2D g2, int x, int y, int connectX, int connectY, double scale) {
		double distanceX= Math.abs(x- connectX);
		double distanceY= Math.abs(y- connectY);		
		double signOfPointX= (x - connectX < 0)? 1: -1;
		double signOfPointY= (y - connectY < 0)? 1: -1;
		double averageOfDistanceY= (distanceX== 0)? 0: distanceY/ distanceX;	
		double signOfPointYWithaverageOfDistanceY= averageOfDistanceY* signOfPointY;
		double oldRegisterY= 0;
		boolean firstTime= true;
		if(1== signOfPointX) {
			double registerY = y;
			int endX=x;
			for(int c = 0, i = x; i < connectX- 16; c+= 8, i+= 8) {
				registerY= y+ signOfPointYWithaverageOfDistanceY* c+ scale 
						* Math.sin(averageOfDistanceY* c/ 6);
				g2.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY
						, i+ 8, (int)registerY);
				oldRegisterY= registerY;
				endX= i+ 8;
				firstTime= false;
			}
			g2.drawLine(endX, (int)registerY, connectX-8, connectY);
			return;
		}	
		if(-1== signOfPointX) {
			for(int c= 0, i= x; i> connectX+ 2; c+= 8, i-= 8) {
				double registerY= y+ signOfPointYWithaverageOfDistanceY* c+ scale 
						* Math.sin(averageOfDistanceY* c/ 6 );
				g2.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY
						, i- 8, (int)registerY);
				oldRegisterY= registerY;
				firstTime= false;
			}
		}
	}
}