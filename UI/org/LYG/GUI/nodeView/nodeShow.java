package org.LYG.GUI.nodeView;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.tree.*;
import org.LYG.GUI.OSGI.*;
import org.LYG.GUI.extOSGI.*;
import org.LYG.GUI.platForm.unicornTreeCellRenderer;
public class nodeShow extends JScrollPane implements MouseListener,ItemListener,ActionListener {
	private static final long serialVersionUID = 1L;
	public JTree tree;
	public nodeOSGI first;
	public linkOSGI link;
	DefaultTreeModel treeModel;
	DefaultMutableTreeNode root;
	ImageIcon test;
	public String labelname;
	public nodeShow() throws IOException{	
		link = new linkOSGI();
		first = new OSGI_rigester().Rigester(first,link);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Node");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		tree.setExpandsSelectedPaths(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.putClientProperty("JTree.lineStyle" , "Horizontal");  
		tree.setEditable(false);
		unicornTreeCellRenderer myCellRenderer = new unicornTreeCellRenderer();  
		myCellRenderer.setFont(new Font("Serif", Font.ITALIC, 12));
		tree.setCellRenderer(myCellRenderer);

		DefaultMutableTreeNode BI = new DefaultMutableTreeNode("BI");
		DefaultMutableTreeNode SOUND = new DefaultMutableTreeNode("SOUND");
		DefaultMutableTreeNode IMAGE = new DefaultMutableTreeNode("IMAGE");
		DefaultMutableTreeNode MOVIE = new DefaultMutableTreeNode("MOVIE");

		root.add(BI);
		root.add(SOUND);	
		root.add(IMAGE);	
		root.add(MOVIE);

		if(first!=null){
			if(first.currentFace.position == null){
				JLabel label;
				label = new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(label);
				root.add(node);
			}
			else if(first.currentFace.position.equals("BI")){
				JLabel label;
				label=new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
				BI.add(node);
			}
			else if(first.currentFace.position.equals("SOUND")){
				JLabel label;
				label=new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
				SOUND.add(node);
			}
			else if(first.currentFace.position.equals("IMAGE")){
				JLabel label;
				label=new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
				IMAGE.add(node);
			}
			else if(first.currentFace.position.equals("MOVIE")){
				JLabel label;
				label=new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
				MOVIE.add(node);
			}
			else{
				JLabel label;
				label=new JLabel();
				label.setIcon(first.thisicon);
				label.setText(first.thisname);
				DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
				root.add(node);
			}

			while(first.next!=null) {
				first=first.next;

				if(first.currentFace.position==null){
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					root.add(node);
				}
				else if(first.currentFace.position.equals("BI")){
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					BI.add(node);
				}
				else if(first.currentFace.position.equals("SOUND")){
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					SOUND.add(node);
				}
				else if(first.currentFace.position.equals("MOVIE")){
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					MOVIE.add(node);
				}
				else if(first.currentFace.position.equals("IMAGE")){
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					IMAGE.add(node);
				}
				else{
					JLabel label;
					label=new JLabel();
					label.setIcon(first.thisicon);
					label.setText(first.thisname);
					DefaultMutableTreeNode node=new DefaultMutableTreeNode(label);
					root.add(node);
				}
			}
		}	
		this.setViewportView(tree);
		//add(tree);	
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
