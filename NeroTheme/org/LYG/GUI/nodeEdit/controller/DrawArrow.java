package org.LYG.GUI.nodeEdit.controller;
import java.awt.Graphics2D;
public interface DrawArrow{
	public void doDrawArrow(Graphics2D graphics2D, int x, int y, int connectX, int connectY);
	public void drawCurve(Graphics2D graphics2D, int x, int y, int connectX, int connectY, double scale);
}