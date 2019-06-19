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
import org.LYG.GUI.nodeEdit.CheckRangeVPS;
import org.LYG.GUI.nodeEdit.ChooseCheckVPS;
import org.LYG.GUI.nodeEdit.DrawArrowVPS;
import org.LYG.GUI.nodeEdit.DrawFlashSide;
import org.LYG.GUI.nodeEdit.DynamicLineUpdaterVPS;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeInfo.NodeInfo;
import org.LYG.GUI.nodeProject.NodeProject;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.GUI.platForm.UnicornJSplitPane;
import org.LYG.sets.stable.StableData;

public class ThisCanvas extends JPanel implements MouseMotionListener
, MouseListener, ItemListener, ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	public Thread threadApplet;
	public String fileCurrentpath;
	public int w, h;
	public int flash= 0;
	public int count= 0;
	public int mouseDirection= 0;
	public String currentNodeName;
	public int currentNodeID;
	public String currentNodePrimaryKey;
	public LinkList first;
	public int currentX, currentY;
	public int choose= 0;
	public int oldX, oldY;
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
	public MenuItem configre, run, show, dNode, dLine;
	public ChooseCheckVPS chooseCheck;
	public DynamicLineUpdaterVPS dynamicLineUpdater;
	public DrawArrowVPS drawArrow;
	public CheckRangeVPS checkRange;
	public ThisCanvas(Thread threadApplet, LinkList first, NodeShow nodeView
			, PopupMenu nodeMenu, JTextPane rightBotJTextPane){
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
		chooseCheck= new ChooseCheckVPS();
		dynamicLineUpdater= new DynamicLineUpdaterVPS();
		drawArrow= new DrawArrowVPS();
		checkRange= new CheckRangeVPS();
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
	@SuppressWarnings(StableData.TAG_DEPRECATION)
	public void stop() {
		threadApplet.destroy();
	}

	public void actionPerformed(ActionEvent arg0) {}

	public void itemStateChanged(ItemEvent arg0) {}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {
		isOperation= 1;
		oldX= arg0.getX();
		oldY= arg0.getY();
		currentX= arg0.getX();
		currentY= arg0.getY();
		Object[] node= chooseCheck.chooseCheckNode(first.first, arg0);
		currentNodeName= (String) node[0];
		currentNodeID= (int) node[1];
		currentNodePrimaryKey= (String) node[2];
		rightBotJTextPane.setText("×ø±êÎ»£º"+ arg0.getX()+ "|"+ arg0.getY());
		rightBotJTextPane.validate();
	}


	public void mouseReleased(MouseEvent arg0){
		isOperation= 0;
		currentX= arg0.getX();
		currentY= arg0.getY();
		LinkNode node= first.first;
		while(null!= node){
			if(node.rightChoose&& !node.leftChoose){
				if(oldX== arg0.getX()&&oldY == arg0.getY()){
					nodeMenu.show(this, arg0.getX(), arg0.getY());
				}
				else{
					checkRange.doCheckRange(first.first, node,arg0);
				}
			}
			node.setchoose(false);
			node.rightChoose= false;
			node= node.next;
		}
	}

	public void mouseDragged(MouseEvent e) {
		isOperation= 1;
		try {
			Thread.sleep(32);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		currentX= e.getX();
		currentY= e.getY();
		LinkNode node= first.first;
		Graphics g= getGraphics();
		Graphics2D graphics2D= (Graphics2D)g;
		graphics2D.setColor(Color.black);
		boolean needUpdate= false;
		while(null!= node){
			if(node.leftChoose|| node.rightChoose) {
				needUpdate= true;
			}
			if(node.leftChoose&& !node.rightChoose){
				node.setxy(e.getX(), e.getY());
				dynamicLineUpdater.exec(first.first, node);
			}
			node= node.next;
		}
		if(needUpdate) {
			this.update(g);
			g.dispose();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void paint(Graphics g){
		nodeView.validate();
		Graphics2D graphics2D= (Graphics2D)g;
		graphics2D.clearRect(0, 0, this.getWidth(), this.getHeight());
		first.first= Sort.sort(first.first);
		LinkNode node= first.first;
		while(node!= null){
			if(node.x< 0){
				node.x= 10;
			}
			if(node.x> (this.getWidth()-100)){
				node.x= this.getWidth()-100; 	
			}
			if(node.y< 0){
				node.y= 10;
			}
			if(node.y> (this.getHeight()- 100)){
				node.y= this.getHeight()- 100; 	
			}			
			g.drawImage(node.thisFace.thisImage, node.x+19, node.y+12, this);
			if(node.flash> 100){
				node.flash= 0;
			}
			if(0== isOperation) {
				DrawFlashSide.drawFlashSide(graphics2D, node.x, node.y, node.flash++ % 3);
			}else {
				DrawFlashSide.drawFlashSide(graphics2D, node.x, node.y, node.flash);
			}
			graphics2D.setColor(Color.black);
			g.drawString(node.name+ "->"+ node.ID, node.x- 5, node.y- 20);
			graphics2D.setColor(new	Color(25, 25, 112));
			if(node.beconnect){
				if(node.tBeconnect){
					drawArrow.doDrawArrow(graphics2D, node.tBeconnectX+ 62, node.tBeconnectY+ 28, node.x+ 14, node.y- 6);
					if(!node.leftChoose&& node.rightChoose){
						graphics2D.setColor(Color.black);
						drawArrow.doDrawArrow(graphics2D, oldX, oldY, currentX, currentY);
						graphics2D.setColor(new	Color(25, 25, 112));	
					}
				}
				if(node.mBeconnect){
					drawArrow.doDrawArrow(graphics2D, node.mBeconnectX+ 62, node.mBeconnectY+ 28, node.x- 4, node.y+ 25);
					if(!node.leftChoose&& node.rightChoose){
						graphics2D.setColor(Color.black);
						drawArrow.doDrawArrow(graphics2D, oldX, oldY, currentX, currentY);
						graphics2D.setColor(new	Color(25, 25, 112));	
					}
				}
				if(node.dBeconnect){
					drawArrow.doDrawArrow(graphics2D, node.dBeconnectX+ 62, node.dBeconnectY+ 28, node.x+ 6, node.y+ 55);
					if(!node.leftChoose&& node.rightChoose){
						graphics2D.setColor(Color.black);
						drawArrow.doDrawArrow(graphics2D, oldX, oldY, currentX, currentY);
						graphics2D.setColor(new	Color(25, 25, 112));	
					}
				}
			}else if(!node.leftChoose&& node.rightChoose){
				graphics2D.setColor(Color.black);
				drawArrow.doDrawArrow(graphics2D, oldX, oldY, currentX, currentY);
				graphics2D.setColor(new	Color(25, 25, 112));
			}
			node= node.next;
		}
	}	
}