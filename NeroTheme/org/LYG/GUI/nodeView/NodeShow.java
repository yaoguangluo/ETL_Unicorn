package org.LYG.GUI.nodeView;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.tree.*;
import org.LYG.GUI.OSGI.*;
import org.LYG.GUI.extOSGI.*;
import org.LYG.GUI.platForm.UnicornTreeCellRenderer;
public class NodeShow extends JScrollPane implements MouseListener, ItemListener, ActionListener {
	private static final long serialVersionUID= 1L;
	public JTree tree;
	public NodeOSGI first;
	public LinkOSGI link;
	DefaultTreeModel treeModel;
	DefaultMutableTreeNode root;
	ImageIcon test;
	public String labelname;
	JTextPane text;
	Object[][] tableData_old;
	public NodeShow(Object[][] tableData_old, JTextPane text) throws IOException{	
		this.text= text;
		this.tableData_old= tableData_old;
		link= new LinkOSGI();
		first= new OSGI_rigester(this.tableData_old, this.text).Rigester(first, link);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Node");
		treeModel= new DefaultTreeModel(root);
		tree= new JTree(treeModel);
		tree.setExpandsSelectedPaths(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.putClientProperty("JTree.lineStyle" , "Horizontal");  
		tree.setEditable(false);
		UnicornTreeCellRenderer myCellRenderer = new UnicornTreeCellRenderer();  
		myCellRenderer.setFont(new Font("Serif", Font.ITALIC, 12));
		tree.setCellRenderer(myCellRenderer);
		DefaultMutableTreeNode BI= new DefaultMutableTreeNode("BI");
		DefaultMutableTreeNode SOUND= new DefaultMutableTreeNode("SOUND");
		DefaultMutableTreeNode IMAGE= new DefaultMutableTreeNode("IMAGE");
		DefaultMutableTreeNode MOVIE= new DefaultMutableTreeNode("MOVIE");
		root.add(BI);
		root.add(SOUND);	
		root.add(IMAGE);	
		root.add(MOVIE);
		while(null!= first){
			if(null== first.currentFace.position){
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				root.add(node);
			}
			else if(first.currentFace.position.equals("BI")){
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				BI.add(node);
			}
			else if(first.currentFace.position.equals("SOUND")){
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				SOUND.add(node);
			}
			else if(first.currentFace.position.equals("IMAGE")){
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				IMAGE.add(node);
			}
			else if(first.currentFace.position.equals("MOVIE")){
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				MOVIE.add(node);
			}
			else{
				JLabel label;
				label= new JLabel();
				label.setIcon(first.thisIcon);
				label.setText(first.thisName);
				DefaultMutableTreeNode node= new DefaultMutableTreeNode(label);
				root.add(node);
			}
			if(null== first.next) {
				break;
			}
			first= first.next;
		}	
		this.setViewportView(tree);	
	}	
	public void actionPerformed(ActionEvent e) {
	}

	public void itemStateChanged(ItemEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
}
