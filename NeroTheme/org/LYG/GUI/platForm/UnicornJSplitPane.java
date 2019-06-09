package org.LYG.GUI.platForm;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
/**  
 *  作者对jdk 开源插件进行2次修改。不在个人著作申请范围内。
 * @author LYG refer JDK authors from SUN Tech，。
 */
public class UnicornJSplitPane extends JSplitPane {
	private static final long serialVersionUID = 1L;
	private int dividerDragSize = 3;
	private int dividerDragOffset = 3;
	public UnicornJSplitPane() {
		setDividerSize( 0 );
		setContinuousLayout( true );
	}
	@SuppressWarnings("deprecation")
	@Override
	public void layout() {
		super.layout();
		BasicSplitPaneDivider divider = ((BasicSplitPaneUI)getUI()).getDivider();
		Rectangle bounds = divider.getBounds();
		if( orientation == HORIZONTAL_SPLIT ) {
			bounds.x -= dividerDragOffset;
			bounds.width = dividerDragSize;
		} else {
			bounds.y -= dividerDragOffset;
			bounds.height = dividerDragSize;
		}
		divider.setBounds(bounds);
	}
}