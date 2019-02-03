package org.LYG.GUI.nodeEdit;
import java.awt.Color;
import java.awt.Graphics2D;
public class DrawFlashSide{
	public DrawFlashSide(Graphics2D g2, int x, int y, int flash) {
		if(flash<=0){
			g2.setColor(Color.blue);
			drawFlashInside(g2,x,y);
			g2.setColor(Color.RED);
			drawFlashMidside(g2,x,y); 
			g2.setColor(Color.orange);
			drawFlashOutside(g2,x,y);	
		}
		if(flash==1){
			g2.setColor(Color.RED);
			drawFlashInside(g2,x,y);
			g2.setColor(Color.ORANGE);
			drawFlashMidside(g2,x,y); 
			g2.setColor(Color.BLUE);
			drawFlashOutside(g2,x,y);		
		}
		if(flash>=2){
			g2.setColor(Color.ORANGE);
			drawFlashInside(g2,x,y);
			g2.setColor(Color.BLUE);
			drawFlashMidside(g2,x,y); 
			g2.setColor(Color.RED);
			drawFlashOutside(g2,x,y);		
		}	
		drawConnect(g2,x,y);	
	}
	private void drawConnect(Graphics2D g2, int x, int y) {
		//top
		g2.drawLine(x-10, y+8, x, y+8);
		g2.drawOval(x-12, y+6, 4, 4);
		//mid
		g2.drawLine(x-10, y+25, x, y+25);
		g2.drawOval(x-12, y+23, 4, 4);
		//bot
		g2.drawLine(x-10, y+40, x, y+40);
		g2.drawOval(x-12, y+38, 4, 4);
		//out
		g2.drawLine(x+50, y+25, x+60, y+25);
		g2.drawOval(x+58, y+23, 4, 4);
		
	}
	public void drawFlashInside(Graphics2D g2, int x, int y){
		g2.drawLine(x-1, y-1, x+51, y-1);
		g2.drawLine(x-1, y+51, x+51, y+51);
		g2.drawLine(x-1, y-1, x-1, y+51);
		g2.drawLine(x+51, y-1, x+51, y+51);
	}
	public void drawFlashMidside(Graphics2D g2, int x, int y){
		g2.drawLine(x-3, y-3, x+53, y-3);
		g2.drawLine(x-3, y+53, x+53, y+53);
		g2.drawLine(x-3, y-3, x-3, y+53);
		g2.drawLine(x+53, y-3, x+53, y+53);
	}
	public void drawFlashOutside(Graphics2D g2, int x, int y){
		g2.drawLine(x-5, y-5, x+55, y-5);
		g2.drawLine(x-5, y+55, x+55, y+55);
		g2.drawLine(x-5, y-5, x-5, y+55);
		g2.drawLine(x+55, y-5, x+55, y+55);
	}
}