package org.LYG.GUI.Flash;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import org.LYG.GUI.nodeEdit.CheckRange;
import org.LYG.GUI.nodeEdit.ChooseCheck;
import org.LYG.GUI.nodeEdit.DrawArrow;
import org.LYG.GUI.nodeEdit.DrawFlashSide;
import org.LYG.GUI.nodeEdit.DynamicLineUpdater;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeInfo.NodeInfo;
import org.LYG.GUI.nodeProject.NodeProject;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.GUI.platForm.UnicornJSplitPane;
import org.LYG.sets.stable.StableData;

public class ThisCanvas extends JPanel implements MouseMotionListener, MouseListener, ItemListener
, ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	public Thread threadApplet;
	public String fileCurrentpath;
	public int w, h;
	public int flash= 0;
	public int count= 0;
	public String currentNodeName;
	public int currentNodeID;
	public String currentNodePrimaryKey;
	public LinkList first;
	public int currentx, currenty;
	public int choose= 0;
	public int oldx, oldy;
	public int newx, newy;
	public int isOperation= 0;
	public String treeNodeName;
	public NodeShow nodeView;
	public NodeProject nodeProject;
	public NodeInfo nodeInfo;
	public UnicornJSplitPane mainSplitPane;
	public UnicornJSplitPane leftSplitPane;
	public UnicornJSplitPane rightSplitPane;
	public UnicornJSplitPane righttopSplitPane;
	public JScrollPane righttopScrollPane;
	public JScrollPane rightdownScrollPane;
	public JScrollPane rightrightScrollPane;
	public JTextPane rightBotJTextPane;
	public PopupMenu popupMenu, nodeMenu, itemMenu, engineMenu;
	public MenuItem save, saveAs, delete, load;
	public MenuItem menuItem;
	public MenuItem configre, run, show, dnode, dline;

	public ThisCanvas(Thread threadApplet, LinkList first, NodeShow nodeView, PopupMenu nodeMenu, JTextPane rightBotJTextPane){
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.start();
		this.setOpaque(false);
		this.threadApplet= threadApplet;
		this.first= first;
		this.nodeView= nodeView;
		this.nodeMenu= nodeMenu;
		this.rightBotJTextPane= rightBotJTextPane;
	}  
	@SuppressWarnings(StableData.TAG_DEPRECATION)
	public void run() {
		while(true){   
			try{
				Thread.sleep(1000);
				this.updateUI();
			}catch (InterruptedException e) {
				threadApplet.destroy();
				e.printStackTrace();
			}
		}      
	}
	public void start(){
		if(null== threadApplet){
			threadApplet =  new Thread(this);
			threadApplet.start();
		}

	}
	@SuppressWarnings("deprecation")
	public void stop() {
		threadApplet.destroy();
	}

	public void actionPerformed(ActionEvent arg0) {}

	public void itemStateChanged(ItemEvent arg0) {}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {
		isOperation = 1;
		oldx = arg0.getX();
		oldy = arg0.getY();
		currentx = arg0.getX();
		currenty = arg0.getY();
		LinkNode node= new ChooseCheck().chooseCheckNode(first.first, arg0);
		currentNodeName = node.name;
		currentNodeID = node.ID;
		currentNodePrimaryKey = node.primaryKey;
		rightBotJTextPane.setText("×ø±êÎ»£º"+arg0.getX()+"|"+arg0.getY());
		rightBotJTextPane.validate();
	}


	public void mouseReleased(MouseEvent arg0){
		isOperation = 0;
		currentx = arg0.getX();
		currenty = arg0.getY();
		LinkNode node = first.first;
		while(node != null){
			if(node.rightChoose && !node.leftChoose){
				if(oldx == arg0.getX()&&oldy == arg0.getY()){
					nodeMenu.show(this, arg0.getX(), arg0.getY());
				}
				else{
					new CheckRange(first.first, node,arg0);
				}
			}
			node.setchoose(false);
			node.rightChoose = false;
			node = node.next;
		}
	}

	public void mouseDragged(MouseEvent e) {
		isOperation=1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		currentx= e.getX();
		currenty= e.getY();
		first.first= new Sort().sort(first.first);
		LinkNode node= first.first;
		Graphics g= getGraphics();
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.black);
		while(null!= node){
			if(node.leftChoose&& !node.rightChoose){
				node.setxy(e.getX(), e.getY());
				new DynamicLineUpdater().exec(first.first, node);
			}
			if(!node.leftChoose&&node.rightChoose){	 
				new DrawArrow(g2,oldx, oldy, e.getX(), e.getY());
			}	
			node= node.next;
			this.update(g);
			g.dispose();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void paint(Graphics g){
		nodeView.validate();
		Graphics2D g2= (Graphics2D)g;
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		first.first = new Sort().sort(first.first);
		LinkNode node= first.first;
		while(node!= null){
			if(node.x< 0){
				node.x= 10;
			}
			if(node.x> (this.getWidth()-100)){
				node.x= this.getWidth()-100; 	
			}
			if(node.y < 0){
				node.y = 10;
			}
			if(node.y > (this.getHeight()-100)){
				node.y = this.getHeight()-100; 	
			}
			g.drawImage(node.thisFace.thisImage, node.x+19, node.y+12, this);
			if(node.flash > 100){
				node.flash = 0;
			}
			if(0 == isOperation) {
				new DrawFlashSide(g2, node.x, node.y, node.flash++ % 3);
			}else {
				new DrawFlashSide(g2, node.x, node.y, node.flash);
			}
			g2.setColor(Color.black);
			g.drawString(node.name + "->" + node.ID,node.x - 5, node.y-20);
			g2.setColor(new	Color(25, 25, 112));
			if(node.beconnect){
				if(node.tBeconnect){
					new DrawArrow(g2, node.tBeconnectX+62, node.tBeconnectY+28, node.x+14, node.y-6);
					if(!node.leftChoose&&node.rightChoose){
						g2.setColor(Color.black);
						new DrawArrow(g2, oldx, oldy, currentx, currenty);
						g2.setColor(new	Color(25,25,112));	
					}
				}
				if(node.mBeconnect){
					new DrawArrow(g2, node.mBeconnectX+62, node.mBeconnectY+28, node.x-4, node.y+25);
					if(!node.leftChoose&& node.rightChoose){
						g2.setColor(Color.black);
						new DrawArrow(g2, oldx, oldy, currentx, currenty);
						g2.setColor(new	Color(25, 25, 112));	
					}
				}
				if(node.dBeconnect){
					new DrawArrow(g2, node.dBeconnectX+ 62, node.dBeconnectY+ 28, node.x+ 6, node.y+ 55);
					if(!node.leftChoose&& node.rightChoose)
					{
						g2.setColor(Color.black);
						new DrawArrow(g2, oldx, oldy, currentx, currenty);
						g2.setColor(new	Color(25, 25, 112));	
					}
				}
			}else if(!node.leftChoose&& node.rightChoose){
				g2.setColor(Color.black);
				new DrawArrow(g2, oldx, oldy, currentx, currenty);
				g2.setColor(new	Color(25, 25, 112));
			}
			node = node.next;
		}
	}	
}