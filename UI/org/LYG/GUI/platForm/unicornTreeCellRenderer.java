package org.LYG.GUI.platForm;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
public class unicornTreeCellRenderer extends DefaultTreeCellRenderer {
	private static final long serialVersionUID = 1L;
	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean selected, boolean expanded,boolean leaf, int row, boolean hasFocus) { 
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		Object obj = node.getUserObject();
		if(obj instanceof JLabel) {
			JLabel label = (JLabel)obj;
			DefaultTreeCellRenderer tempCellRenderer = new DefaultTreeCellRenderer();
			tempCellRenderer.setLeafIcon(label.getIcon());
			return  tempCellRenderer.getTreeCellRendererComponent(tree,label.getText(),selected,expanded,true,row,hasFocus);
		}
		return super.getTreeCellRendererComponent(tree,value,selected,expanded,leaf,row,hasFocus);
	}
}