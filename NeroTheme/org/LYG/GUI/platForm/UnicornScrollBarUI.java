package org.LYG.GUI.platForm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI ;
/**  
 *  作者对jdk 开源插件进行2次修改。不在个人著作申请范围内。
 * @author LYG refer JDK authors from SUN Tech，。
 */
public final class UnicornScrollBarUI extends BasicScrollBarUI {
		public Dimension getPreferredSize(JComponent c) {
			return (scrollbar.getOrientation() == JScrollBar.VERTICAL)
					? new Dimension(10, 40)
							: new Dimension(40,10);
		}
		public static ComponentUI  createUI(JComponent  c){
			return new UnicornScrollBarUI();
		}
	
		protected void paintThumb(Graphics  g, JComponent  c, Rectangle  thumbBounds){ 
			if (thumbBounds.isEmpty() || !scrollbar.isEnabled())
				return;
			int w =thumbBounds.width ;
			int h = thumbBounds.height;
			g.translate(thumbBounds.x, thumbBounds.y);
			g.setColor(Color.ORANGE);//thumbHighlightColor
			g.drawLine(0, 0, 0, h - 2); // Left side.
			g.drawLine(0, 0, w - 2, 0); // Top.
			g.setColor(Color.BLUE);//thumbDarkShadowColor
			g.drawLine(w - 1, 0, w - 1, h - 1); // Right side.
			g.drawLine(0, h - 1, w - 1, h - 1); // Bottom.
			g.setColor(Color.green);//thumbLightShadowColor
			g.drawLine(w - 2, 1, w - 2, h - 2); // Right side.
			g.drawLine(1, h - 2, w - 2, h - 2); // Bottom.
			// Fill in the middle.
			g.setColor(Color.gray);//thumbColor
			g.fillRect(3, 3, w - 6, h - 6);
			//.fillRect(6, 6, w - 12, h - 12);
			// Done.
			g.translate(-thumbBounds.x, -thumbBounds.y);
		}
	
		protected JButton  createDecreaseButton(int orientation) {
			return new ArrowButton(orientation);
		}
	
		protected JButton  createIncreaseButton(int orientation) {
			return new ArrowButton(orientation);
		}
	
		private static class ArrowButton extends JButton  {
			private static final long serialVersionUID = 1L;
			private final int direction;
			private final int h;
			private final int w;
			private final Color  thumb;
			private final Color  shadow;
			private final Color  darkShadow;
			private final Color  highlight;
	
			public ArrowButton(int direction) {
				this.direction = direction;
				h = w =10;
				thumb = Color.darkGray;
				shadow = Color.red;
				darkShadow = Color.orange;
				highlight = Color.blue;
				setRequestFocusEnabled(false);
			}
	
			public void paint(Graphics  g) {
				final Color  origColor = g.getColor();
				final boolean isPressed = getModel().isPressed();
				if (isPressed) {
					g.setColor(shadow);
					g.drawRect(0, 0, w - 1, h - 1);
				} else {
					g.setColor(highlight);
					g.drawLine(0, 0, 0, h - 1);
					g.drawLine(1, 0, w - 2, 0);
					g.setColor(shadow);
					g.drawLine(1, h - 2, w - 2, h - 2);
					g.drawLine(w - 2, 1, w - 2, h - 3);
					g.setColor(darkShadow);
					g.drawLine(0, h - 1, w - 1, h - 1);
					g.drawLine(w - 1, 0, w - 1, h - 1);
				}
				g.setColor(thumb);
				g.fillRect(1, 1, w - 3, h - 3);
				if (isPressed)
					g.translate(1, 1);
				paintTriangle(g);
				if (isPressed)
					g.translate(-1, -1);
				g.setColor(origColor);
			}
	
			public Dimension  getPreferredSize() {
				return new Dimension (w, h);
			}
	
			public Dimension  getMinimumSize() {
				return new Dimension (w, h);
			}
	
			public Dimension  getMaximumSize() {
				return new Dimension (w, h);
			}
	
			public boolean isFocusTraversable() {
				return false;
			}
	
			private void paintTriangle(Graphics  g) {
				final int size = 4;
				int x = (w - size) / 2;
				int y = (h - size) / 2;
				if (direction == NORTH)
					--y;
				else if (direction == WEST)
					--x;
				g.translate(x, y);
				g.setColor(isEnabled() ? darkShadow : shadow);
				final int mid = (size / 2) - 1;
				switch (direction) {
				case NORTH:
					for (int i = 0; i < size; i++)
						g.drawLine(mid - i, i, mid + i, i);
					break;
				case SOUTH:
					for (int i = size, j = 0; i-- > 0;) {
						g.drawLine(mid - i, j, mid + i, j);
						j++;
					}
					break;
				case WEST:
					for (int i = 0; i < size; i++)
						g.drawLine(i, mid - i, i, mid + i);
					break;
				case EAST:
					for (int i = size, j = 0; i-- > 0;) {
						g.drawLine(j, mid - i, j, mid + i);
						j++;
					}
					break;
				}
				g.translate(-x, -y);
			}
		}
}

