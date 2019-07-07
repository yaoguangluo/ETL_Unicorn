package org.LYG.GUI.nodeEdit;
import java.awt.*;
import org.LYG.GUI.nodeEdit.controller.DrawArrow;
public class DrawArrowVPS implements DrawArrow {
	public void doDrawArrow(Graphics2D graphics2D, int x, int y, int connectX, int connectY) {
		x+= 10;
		connectX-= 10;
		graphics2D.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		drawCurve(graphics2D, x, y, connectX, connectY, 6);
		DrawSinLineVPS.drawHead(connectX- 8, connectY- 3, graphics2D);
	}

	public void drawCurve(Graphics2D graphics2D, int x, int y, int connectX, int connectY, double scale) {
		double distanceX= Math.abs(x- connectX);
		double distanceY= Math.abs(y- connectY);		
		double signOfPointX= (x - connectX < 0)? 1: -1;
		double signOfPointY= (y - connectY < 0)? 1: -1;
		double averageOfDistanceY= (distanceX== 0)? 0: distanceY/ distanceX;	
		double signOfPointYWithaverageOfDistanceY= averageOfDistanceY* signOfPointY;
		double oldRegisterY= 0;
		boolean firstTime= true;
		double signOfPointYWithaverageOfDistanceYKernel= signOfPointYWithaverageOfDistanceY* 8;
		double averageOfDistanceYKernel= averageOfDistanceY* 8/ 6;
		double signOfPointYWithaverageOfDistanceYCount= signOfPointYWithaverageOfDistanceYKernel;
		double averageOfDistanceYCount= averageOfDistanceYKernel;
		if(1== signOfPointX) {
			double registerY = y;
			int endX= x;
			for(int i = x; i < connectX- 16; i+= 8) {
				registerY= y+ signOfPointYWithaverageOfDistanceYCount+ scale 
						* Math.sin(averageOfDistanceYCount);
				graphics2D.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY
						, i+ 8, (int)registerY);
				oldRegisterY= registerY;
				endX= i+ 8;
				firstTime= false;
				signOfPointYWithaverageOfDistanceYCount+= signOfPointYWithaverageOfDistanceYKernel;
				averageOfDistanceYCount+= averageOfDistanceYKernel;
			}
			graphics2D.drawLine(endX, (int)registerY, connectX-8, connectY);
			return;
		}	
		if(-1== signOfPointX) {
			for(int i= x; i> connectX+ 2; i-= 8) {
				double registerY= y+ signOfPointYWithaverageOfDistanceYCount+ scale 
						* Math.sin(averageOfDistanceYCount);
				graphics2D.drawLine(i, true== firstTime? (int)registerY: (int)oldRegisterY
						, i- 8, (int)registerY);
				oldRegisterY= registerY;
				firstTime= false;
				signOfPointYWithaverageOfDistanceYCount+= signOfPointYWithaverageOfDistanceYKernel;
				averageOfDistanceYCount+= averageOfDistanceYKernel;
			}
		}
	}
}