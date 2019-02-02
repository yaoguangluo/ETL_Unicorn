package org.LYG.GUI.nodeEdit;
import java.awt.*;
public class DrawArrow{
	public DrawArrow(Graphics2D g2, int x, int y, int connectx, int connecty) {
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		g2.drawLine(x,y,connectx,connecty);
		g2.drawPolygon(getArrow(x, y, connectx, connecty, 18, 0,0.5)); 
		g2.fillPolygon(getArrow(x, y, connectx, connecty, 18, 0,0.5));	
	}
	public Polygon getArrow(int x1, int y1, int x2, int y2, int headsize, int difference, double factor){
		int[] crosslinebase = getArrowHeadLine(x1, y1, x2, y2, headsize);
		int[] headbase = getArrowHeadLine(x1, y1, x2, y2, headsize - difference);
		int[] crossline = getArrowHeadCrossLine(crosslinebase[0], crosslinebase[1], x2, y2, factor);
		Polygon head = new Polygon();
		head.addPoint(headbase[0], headbase[1]);
		head.addPoint(crossline[0], crossline[1]);
		head.addPoint(x2, y2);
		head.addPoint(crossline[2], crossline[3]);
		head.addPoint(headbase[0], headbase[1]);
		head.addPoint(x1, y1);
		return head;
	}
	private int[] getArrowHeadCrossLine(int x1, int x2, int b1, int b2, double factor){
		int [] crossline = new int[4];
		int xdest = (int) (((b1 - x1)*factor) + x1);
		int ydest = (int) (((b2 - x2)*factor) + x2);
		crossline[0] = (int) ((x1 + x2 - ydest));
		crossline[1] = (int) ((x2 + xdest - x1));
		crossline[2] = crossline[0] + (x1-crossline[0])*2;
		crossline[3] = crossline[1] + (x2-crossline[1])*2;
		return crossline;
	}
	private int[] getArrowHeadLine(int xsource,int ysource,int xdest,int ydest, int distance){
		int[] arrowhead = new int[2];
		int headsize = distance;
		double stretchfactor = 0;
		stretchfactor = 1-(headsize/(Math.sqrt(((xdest-xsource)*(xdest-xsource))+((ydest-ysource)*(ydest-ysource)))));
		arrowhead[0] = (int) (stretchfactor*(xdest-xsource))+xsource;
		arrowhead[1] = (int) (stretchfactor*(ydest-ysource))+ysource;
		return arrowhead;
	}
}