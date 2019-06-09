package org.LYG.GUI.platForm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**  
 *  作者对jdk 开源插件进行2次修改。不在个人著作申请范围内。
 * @author LYG refer JDK authors from SUN Tech，。
 */
public class UnicornSplitPaneUI extends BasicSplitPaneUI {   
	public UnicornSplitPaneUI() {   
		super();   
	}   

	public static ComponentUI createUI(JComponent c) {   
		return new UnicornSplitPaneUI();   
	}   

	@Override  
	public void paint(Graphics g, JComponent c) {   
		super.paint(g, c);   
		g.setColor(new Color(255,0,255));   
		int width = c.getWidth();   
		int height = c.getHeight();   
		g.drawRect(3, 3, width - 6, height - 6);   
	}   

	/**  
	 * Creates the default divider.  
	 */  
	@Override  
	public BasicSplitPaneDivider createDefaultDivider() {   
		return new MyBasicSplitPaneDivider(this);   
	}   

	private class MyBasicSplitPaneDivider extends BasicSplitPaneDivider {   

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int oneTouchSize,  oneTouchOffset;   
		boolean centerOneTouchButtons;   
		//center空白区域   
		private int x1,  y1;   
		public MyBasicSplitPaneDivider(UnicornSplitPaneUI ui) {   
			super(ui);   
			oneTouchSize = ONE_TOUCH_SIZE;   
			oneTouchOffset = ONE_TOUCH_OFFSET;   
			centerOneTouchButtons = true;   

			setLayout(new DividerLayout());   
			setBasicSplitPaneUI(ui);   
			orientation = splitPane.getOrientation();   
			setCursor((orientation == JSplitPane.HORIZONTAL_SPLIT) ? Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR) 
					: Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));   
			setBackground(UIManager.getColor("SplitPane.background"));   
		}   


		/**  
		 * Creates and return an instance of JButton that can be used to  
		 * collapse the right component in the split pane.  
		 */  
		@Override  
		protected JButton createRightOneTouchButton() {   
			JButton b = new JButton() {   
				private static final long serialVersionUID = 1L;

				public void setBorder(Border border) {   
				}   

				@Override  
				public void paint(Graphics g) {   
					if (splitPane != null) {   
						int[] xs = new int[3];   
						int[] ys = new int[3];   
						int blockSize;   

						// Fill the background first ...   
						g.setColor(new Color(255,0,255));   
						g.fillRect(0, 0, this.getWidth(),   
								this.getHeight());   

						// ... then draw the arrow.   
						if (orientation == JSplitPane.VERTICAL_SPLIT) {   
							blockSize = Math.min(getHeight(), oneTouchSize);   
							xs[0] = blockSize;   
							xs[1] = blockSize << 1;   
							xs[2] = 0;   
							ys[0] = blockSize;   
							ys[1] = ys[2] = 0;   
						} else {   
							blockSize = Math.min(getWidth(), oneTouchSize);   
							xs[0] = xs[2] = 0;   
							xs[1] = blockSize;   
							ys[0] = 0;   
							ys[1] = blockSize;   
							ys[2] = blockSize << 1;   
						}   
						g.setColor(new Color(255,0,255));     
						g.fillPolygon(xs, ys, 3);   
					}   
				}   
				// Don't want the button to participate in focus traversable.   

				public boolean isFocusTraversable() {   
					return false;   
				}   
			};   
			b.setMinimumSize(new Dimension(oneTouchSize, oneTouchSize));   
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
			b.setFocusPainted(false);   
			b.setBorderPainted(false);   
			b.setRequestFocusEnabled(false);   
			return b;   
		}   

		/**  
		 * Creates and return an instance of JButton that can be used to  
		 * collapse the left component in the split pane.  
		 */  
		protected JButton createLeftOneTouchButton() {   
			JButton b = new JButton() {   
				private static final long serialVersionUID = 1L;
				public void setBorder(Border b) {   
				}   

				public void paint(Graphics g) {   
					if (splitPane != null) {   
						int[] xs = new int[3];   
						int[] ys = new int[3];   
						int blockSize;   

						// Fill the background first ...   
						g.setColor(new Color(255,0,255));   
						g.fillRect(0, 0, this.getWidth(),   
								this.getHeight());   

						// ... then draw the arrow.   
						g.setColor(new Color(255,0,255));    
						if (orientation == JSplitPane.VERTICAL_SPLIT) {   
							blockSize = Math.min(getHeight(), oneTouchSize);   
							xs[0] = blockSize;   
							xs[1] = 0;   
							xs[2] = blockSize << 1;   
							ys[0] = 0;   
							ys[1] = ys[2] = blockSize;   
							g.drawPolygon(xs, ys, 3); // Little trick to make the   
							// arrows of equal size   
						} else {   
							blockSize = Math.min(getWidth(), oneTouchSize);   
							xs[0] = xs[2] = blockSize;   
							xs[1] = 0;   
							ys[0] = 0;   
							ys[1] = blockSize;   
							ys[2] = blockSize << 1;   
						}   
						g.fillPolygon(xs, ys, 3);   
					}   
				}   
				// Don't want the button to participate in focus traversable.   

				public boolean isFocusTraversable() {   
					return false;   
				}   
			};   
			b.setMinimumSize(new Dimension(oneTouchSize, oneTouchSize));   
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
			b.setFocusPainted(false);   
			b.setBorderPainted(false);   
			b.setRequestFocusEnabled(false);   
			return b;   
		}   

		@Override  
		public void paint(Graphics g) {   
			super.paint(g);   
			Dimension size = getSize();   
			g.setColor(Color.white);   
			g.fillRect(1, 1, size.width - 1, size.height - 1);   
			g.setColor(Color.white);     
			if (orientation == JSplitPane.VERTICAL_SPLIT) {   
				g.fillRect(x1, 1, 30, size.height - 1);   
			} else {   
				g.fillRect(1, y1, size.width - 1, 30);   
			}   
			if (leftButton != null) {   
				leftButton.repaint();   
			}   
			if (rightButton != null) {   
				rightButton.repaint();   
			}   
		}   

		/**  
		 * Used to layout a <code>BasicSplitPaneDivider</code>.  
		 * Layout for the divider  
		 * involves appropriately moving the left/right buttons around.  
		 * <p>  
		 */  
		protected class DividerLayout implements LayoutManager {   

			public void layoutContainer(Container c) {   
				if (leftButton != null && rightButton != null) {   
					if (splitPane.isOneTouchExpandable()) {   
						Insets insets = getInsets();   
						if (orientation == JSplitPane.VERTICAL_SPLIT) {   
							int extraX = (insets != null) ? insets.left : 0;   
							int blockSize = getHeight();   

							if (insets != null) {   
								blockSize -= (insets.top + insets.bottom);   
								blockSize = Math.max(blockSize, 0);   
							}   
							blockSize = Math.min(blockSize, oneTouchSize);   
							int y = (c.getSize().height - blockSize) / 2;   
							if (!centerOneTouchButtons) {   
								y = (insets != null) ? insets.top : 0;   
								extraX = 0;   
							}   
							int width = (int) MyBasicSplitPaneDivider.this.getSize().getWidth();   
							x1 = width / 2 - oneTouchSize;   
							leftButton.setBounds(extraX - oneTouchOffset + width / 2, y,   
									blockSize * 2, blockSize);   
							rightButton.setBounds(extraX - oneTouchOffset +   
									oneTouchSize * 2 + width / 2, y,   
									blockSize * 2, blockSize);   
						} else {   
							int extraY = (insets != null) ? insets.top : 0;   
							int blockSize = getWidth();   
							if (insets != null) {   
								blockSize -= (insets.left + insets.right);   
								blockSize = Math.max(blockSize, 0);   
							}   
							blockSize = Math.min(blockSize, oneTouchSize);   

							int x = (c.getSize().width - blockSize) / 2;   

							if (!centerOneTouchButtons) {   
								x = (insets != null) ? insets.left : 0;   
								extraY = 0;   
							}   
							int height = (int) MyBasicSplitPaneDivider.this.getSize().getHeight();   
							y1 = height / 2 - oneTouchSize;   
							leftButton.setBounds(x, extraY - oneTouchOffset + height / 2,   
									blockSize, blockSize * 2);   
							rightButton.setBounds(x, extraY - oneTouchOffset +   
									oneTouchSize * 2 + height / 2, blockSize,   
									blockSize * 2);   
						}   
					} else {   
						leftButton.setBounds(-5, -5, 1, 1);   
						rightButton.setBounds(-5, -5, 1, 1);   
					}   
				}   
			}   

			public Dimension minimumLayoutSize(Container c) {   
				// NOTE: This isn't really used, refer to   
				// BasicSplitPaneDivider.getPreferredSize for the reason.   
				// I leave it in hopes of having this used at some point.   
				if (splitPane == null) {   
					return new Dimension(0, 0);   
				}   
				Dimension buttonMinSize = null;   

				if (splitPane.isOneTouchExpandable() && leftButton != null) {   
					buttonMinSize = leftButton.getMinimumSize();   
				}   

				Insets insets = getInsets();   
				int width = getDividerSize();   
				int height = width;   

				if (orientation == JSplitPane.VERTICAL_SPLIT) {   
					if (buttonMinSize != null) {   
						int size = buttonMinSize.height;   
						if (insets != null) {   
							size += insets.top + insets.bottom;   
						}   
						height = Math.max(height, size);   
					}   
					width = 1;   
				} else {   
					if (buttonMinSize != null) {   
						int size = buttonMinSize.width;   
						if (insets != null) {   
							size += insets.left + insets.right;   
						}   
						width = Math.max(width, size);   
					}   
					height = 1;   
				}   
				return new Dimension(width, height);   
			}   

			public Dimension preferredLayoutSize(Container c) {   
				return minimumLayoutSize(c);   
			}   

			public void removeLayoutComponent(Component c) {   
			}   

			public void addLayoutComponent(String string, Component c) {   
			}   
		} // End of class BasicSplitPaneDivider.DividerLayout   
	}   
}  