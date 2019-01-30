package org.LYG.GUI.platForm;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
public class unicornJSplitPane extends JSplitPane {
	private static final long serialVersionUID = 1L;
	private int dividerDragSize = 3;
	private int dividerDragOffset = 3;
	public unicornJSplitPane() {
		setDividerSize( 0 );
		setContinuousLayout( true );
	}
	@SuppressWarnings("deprecation")
	@Override
	public void layout() {
		super.layout();
		// increase divider width or height
		BasicSplitPaneDivider divider = ((BasicSplitPaneUI)getUI()).getDivider();
		Rectangle bounds = divider.getBounds();
		if( orientation == HORIZONTAL_SPLIT ) {
			bounds.x -= dividerDragOffset;
			bounds.width = dividerDragSize;
		} else {
			bounds.y -= dividerDragOffset;
			bounds.height = dividerDragSize;
		}
		divider.setBounds( bounds );
	}
}