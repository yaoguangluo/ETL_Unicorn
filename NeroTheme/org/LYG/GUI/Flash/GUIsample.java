package org.LYG.GUI.Flash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.LYG.GUI.extOSGI.OSGI_chansfer;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeEdit.CheckRange;
import org.LYG.GUI.nodeEdit.ChooseCheck;
import org.LYG.GUI.nodeEdit.DrawArrow;
import org.LYG.GUI.nodeEdit.DrawFlashSide;
import org.LYG.GUI.nodeEdit.DynamicLineUpdater;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.GUI.nodeEdit.UpdateRelatedLine;
import org.LYG.GUI.nodeInfo.NodeInfo;
import org.LYG.GUI.nodeProject.NodeProject;
import org.LYG.GUI.nodeView.CacuString;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.GUI.platForm.UnicornJSplitPane;
public class GUIsample extends JApplet implements MouseMotionListener, MouseListener
, ItemListener, ActionListener, Runnable{	
	private static final long serialVersionUID = 5270675501794340912L;
	public GUIsample() {
		getContentPane().setBackground(new Color(255,255,255));
	}
	public int w, h;
	public int flash = 0;
	public int count = 0;
	public String currentNodeName;
	public int currentNodeID;
	public LinkList thislist;
	public LinkNode first;
	public int currentx, currenty;
	public int choose = 0;
	public int oldx, oldy;
	public int newx, newy;
	public int isOperation = 0;
	public String treeNodeName;
	public NodeShow nodeView;
	public NodeProject nodeProject;
	public NodeInfo nodeInfo;
	public UnicornJSplitPane mainsplitPane;
	public UnicornJSplitPane leftsplitPane;
	public UnicornJSplitPane rightsplitPane;
	public UnicornJSplitPane righttopsplitPane;
	public JScrollPane righttopscrollPane;
	public JScrollPane rightdownscrollPane;
	public JScrollPane rightrightscrollPane;
	public JTextPane rightBotJTextPane;
	public 	thisCanvas canvas;
	public 	PopupMenu popupMenu, nodeMenu, itemMenu, engineMenu;
	public 	MenuItem save, saveAs, delete, load;
	public 	MenuItem menuItem;
	public 	MenuItem configre, run, show, dnode, dline;
	public 	Thread thread, threadApplet; 
	private JTextPane text;
	private Object[][] tableData_old; 
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		nodeProject.setBounds(0, 0, leftsplitPane.getWidth(), leftsplitPane.getDividerLocation());
		nodeProject.jPanel.newimg = nodeProject.img.getScaledInstance(nodeProject.getWidth()
				, nodeProject.getHeight(), java.awt.Image.SCALE_SMOOTH);
		nodeProject.jPanel.update(getGraphics());
		nodeProject.validate();
		while(true){   
			try{
				Thread.sleep(1000);
				this.validate();
			}catch (InterruptedException e) {}
			//repaint();
		}      
	}
	public void start(){
		if(thread == null){
			thread =  new Thread(this);
			thread.start();
		}
	}

	public void stop() {
	}

	public void Registrar() {
		leftsplitPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {  
			public void propertyChange(java.beans.PropertyChangeEvent evt) {  
				if (evt.getPropertyName().equals(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {  
					//action code 
					nodeProject.setBounds(0, 0,leftsplitPane.getWidth(),leftsplitPane.getDividerLocation());
					nodeProject.jPanel.newimg = nodeProject.img.getScaledInstance(nodeProject.getWidth()
							, nodeProject.getHeight(),java.awt.Image.SCALE_SMOOTH );
					nodeProject.jPanel.repaint();
					nodeProject.validate();

				}  
			}  
		});  

		mainsplitPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {  
			public void propertyChange(java.beans.PropertyChangeEvent evt) {  
				if (evt.getPropertyName().equals(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {  
					//action code 
					nodeProject.setBounds(0, 0,mainsplitPane.getDividerLocation(),leftsplitPane.getDividerLocation());
					nodeProject.jPanel.newimg = nodeProject.img.getScaledInstance(nodeProject.getWidth()
							, nodeProject.getHeight(),java.awt.Image.SCALE_SMOOTH );
					nodeProject.jPanel.repaint();
					nodeProject.validate();
				}  
			}  
		});  

		righttopscrollPane.addComponentListener(new ComponentListener(){
			public void componentHidden(ComponentEvent arg0) {}
			public void componentMoved(ComponentEvent arg0) {}
			public void componentResized(ComponentEvent arg0) {
				righttopscrollPane.validate();
			}
			public void componentShown(ComponentEvent arg0) {}
		});

		getContentPane().addComponentListener(new ComponentListener(){
			public void componentHidden(ComponentEvent arg0) {}
			public void componentMoved(ComponentEvent arg0) {}
			public void componentResized(ComponentEvent arg0) {
				w=getContentPane().getWidth();
				h=getContentPane().getHeight();
				mainsplitPane.setBounds(10, 50, w-20, h-80);
				mainsplitPane.setDividerLocation(0.11);
				leftsplitPane.setDividerLocation(0.25);
				rightsplitPane.setDividerLocation(0.85);
				righttopsplitPane.setDividerLocation(0.9);
				nodeProject.setBounds(0, 0,mainsplitPane.getDividerLocation(),leftsplitPane.getDividerLocation());
				nodeProject.jPanel.newimg = nodeProject.img.getScaledInstance(nodeProject.getWidth()
						, nodeProject.getHeight(),java.awt.Image.SCALE_SMOOTH );
				nodeProject.jPanel.repaint();
				nodeProject.validate();

				mainsplitPane.validate();
				System.out.println(w + "<>" + h);
			}

			public void componentShown(ComponentEvent arg0) {
			}	
		});	
		addMouseListener(this);
		addMouseMotionListener(this);
		nodeProject.addMouseListener(this);
		nodeView.addMouseListener(this);
		nodeView.tree.addMouseListener(this);
		nodeView.tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent evt) {
				DefaultMutableTreeNode note=(DefaultMutableTreeNode) nodeView.tree.getLastSelectedPathComponent();
				String tr = null;
				if(note!=null){
					tr=new CacuString().cauString(note.toString());       
				}
				if(tr!=null){
					treeNodeName=new String(tr);
					rightBotJTextPane.setText("节点名："+treeNodeName);
					rightBotJTextPane.validate();
				}
			}
		});
		menuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(treeNodeName!=null){
					try {
						first=thislist.addNode(first,treeNodeName,100,50,nodeView.first);
						righttopscrollPane.validate();
					} catch (CloneNotSupportedException e1) {
						rightBotJTextPane.setText("节点添加失败~请重试。");
						rightBotJTextPane.validate();
					} catch (InstantiationException e1) {
						rightBotJTextPane.setText("节点添加失败~请重试。");
						rightBotJTextPane.validate();
					} catch (IllegalAccessException e1) {
						rightBotJTextPane.setText("节点添加失败~请重试。");
						rightBotJTextPane.validate();
					} catch (IOException e1) {
						rightBotJTextPane.setText("节点添加失败~请重试。");
						rightBotJTextPane.validate();
					}
					rightBotJTextPane.setText("节点名："+"treeNodeName");
					rightBotJTextPane.validate();
				}
			}
		});  
		configre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkNode node = new LinkNode();
				first = new Sort().sort(first);
				node = first;
				while(node != null){
					if(node.name.equals(currentNodeName)&&node.ID == currentNodeID){
						try {
							node.thisFace.config(rightBotJTextPane);
							node.thisFace.thisPanel.setLocation(node.x, node.y);
							node.thisFace.thisPanel.setSize(300, 300);//setBounds(0, 0, node.x+300,node.y+200);
							node.thisFace.thisPanel.setResizable(true);
							node.thisFace.thisPanel.jsp.setBounds(0, 0, node.thisFace.thisPanel.getWidth()-10, node.thisFace.thisPanel.getHeight()-45);
							node.thisFace.thisPanel.jp.setPreferredSize(new Dimension(800,600));
							node.thisFace.thisPanel.setBackground(Color.BLUE);
							node.thisFace.thisPanel.setVisible(true);
							node.thisFace.thisPanel.validate();
							new OSGI_chansfer(node,first);
						} catch (IOException e1) {
							rightBotJTextPane.setText("节点配置失败~请重试。");
							rightBotJTextPane.validate();
						} 
					}
					node = node.next;
				}	
				rightBotJTextPane.setText("配置成功~");
				rightBotJTextPane.validate();
			}
		}); 
		run.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkNode node=new LinkNode();
				first= new Sort().sort(first);
				node= first;
				while(node!= null){
					if(node.name.equals(currentNodeName)&&node.ID == currentNodeID){
						try {
							node.thisFace.execute(rightBotJTextPane);
						} catch (FileNotFoundException e1) {
							rightBotJTextPane.setText("节点运行失败~请重试。");
							rightBotJTextPane.validate();
						} catch (IOException e1) {
							rightBotJTextPane.setText("节点运行失败~请重试。");
							rightBotJTextPane.validate();
						} catch (UnsupportedAudioFileException e2) {
							rightBotJTextPane.setText("节点运行失败~请重试。");
							rightBotJTextPane.validate();
						} catch (InterruptedException e3) {
							rightBotJTextPane.setText("节点运行失败~请重试。");
							rightBotJTextPane.validate();
						}
					}
					node=node.next;
				}	
				rightBotJTextPane.setText("运行成功~");
				rightBotJTextPane.validate();
			}
		}); 
		show.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkNode node = new LinkNode();
				first=new Sort().sort(first);
				node=first;
				while(node!= null){
					if(node.name.equals(currentNodeName)&&node.ID==currentNodeID){
						if(!node.thisFace.showed){
							try {
								node.thisFace.view(rightBotJTextPane);
								node.thisFace.thisView.setLocation(node.x, node.y);
								node.thisFace.thisView.setSize(500, 500);//setBounds(0, 0, node.x+300,node.y+200);
								node.thisFace.thisView.setResizable(true);
								node.thisFace.thisView.jsp.setBounds(0, 0, node.thisFace.thisPanel.getWidth()-10, node.thisFace.thisPanel.getHeight()-45);
								node.thisFace.thisView.jp.setPreferredSize(new Dimension(800,600));
								node.thisFace.thisView.setVisible(true);
								node.thisFace.thisView.validate();
							} catch (Exception e1) {
								//e1.printStackTrace();
								rightBotJTextPane.setText("节点查看失败，请重试~");
								rightBotJTextPane.validate();
							}  
						}else{
							node.thisFace.thisView.setVisible(true);  
						}
					}
					node=node.next;
				}	
				rightBotJTextPane.setText("显示成功~");
				rightBotJTextPane.validate();
			}
		}); 
		dnode.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkNode node=new LinkNode();
				first=new Sort().sort(first);
				node=first;
				while(node!=null){
					if(node.name.equals(currentNodeName)&&node.ID==currentNodeID){
						first=thislist.deletNode(first, node.name,node.ID);
						new UpdateRelatedLine(first,currentNodeName,currentNodeID);
					}
					node=node.next;
				}	
				canvas.repaint();
			}
		}); 
		dline.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkNode node=new LinkNode();
				first=new Sort().sort(first);
				node=first;
				while(node!=null){
					if(node.beconnect&&node.name.equals(currentNodeName)&&node.ID==currentNodeID){
						node.beconnect=false;
						node.tBeconnect=false;
						node.mBeconnect=false;
						node.dBeconnect=false;
					}
					node=node.next;
				}
				canvas.repaint();
			}
		}); 
	}	
	public class thisCanvas extends JPanel implements MouseMotionListener, MouseListener,ItemListener,ActionListener,Runnable{
		private static final long serialVersionUID = 1L;
		public thisCanvas(){
			this.setLayout(null);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.start();
			this.setOpaque(false);
		}  
		@SuppressWarnings("deprecation")

		public void run() {
			while(true){   
				try{
					Thread.sleep(1000);
					this.updateUI();
				}catch (InterruptedException e) {
					threadApplet.destroy();
				}
			}      
		}
		public void start(){
			if(threadApplet == null){
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
			LinkNode node= new ChooseCheck().chooseCheckNode(first, arg0);
			currentNodeName = node.name;
			currentNodeID = node.ID;
			rightBotJTextPane.setText("坐标位："+arg0.getX()+"|"+arg0.getY());
			rightBotJTextPane.validate();
		}


		public void mouseReleased(MouseEvent arg0){
			isOperation = 0;
			currentx = arg0.getX();
			currenty = arg0.getY();
			LinkNode node = first;
			while(node != null){
				if(node.rightChoose && !node.leftChoose){
					if(oldx == arg0.getX()&&oldy == arg0.getY()){
						nodeMenu.show(this, arg0.getX(), arg0.getY());
					}
					else{
						new CheckRange(first, node,arg0);
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
			currentx=e.getX();
			currenty=e.getY();
			first=new Sort().sort(first);
			LinkNode node=first;
			Graphics g = getGraphics();
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.black);
			while(null != node){
				if(node.leftChoose&&!node.rightChoose){
					node.setxy(e.getX(),e.getY());
					new DynamicLineUpdater().exec(first,node);
				}
				if(!node.leftChoose&&node.rightChoose){	 
					new DrawArrow(g2,oldx, oldy, e.getX(), e.getY());
				}	
				node=node.next;
				this.update(g);
				g.dispose();
			}
		}

		public void mouseMoved(MouseEvent arg0) {
		}

		public void paint(Graphics g){
			nodeView.validate();
			Graphics2D g2 = (Graphics2D)g;
			g2.clearRect(0, 0, this.getWidth(), this.getHeight());
			first = new Sort().sort(first);
			LinkNode node = first;
			while(node != null){
				if(node.x < 0){
					node.x = 10;
				}
				if(node.x > (this.getWidth()-100)){
					node.x = this.getWidth()-100; 	
				}
				if(node.y < 0){
					node.y = 10;
				}
				if(node.y > (this.getHeight()-100)){
					node.y = this.getHeight()-100; 	
				}
				g.drawImage(node.thisFace.thisImage,node.x+19,node.y+12,this);
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
						if(!node.leftChoose&&node.rightChoose){
							g2.setColor(Color.black);
							new DrawArrow(g2, oldx, oldy, currentx, currenty);
							g2.setColor(new	Color(25,25,112));	
						}
					}
					if(node.dBeconnect){
						new DrawArrow(g2, node.dBeconnectX+62, node.dBeconnectY+28, node.x+6, node.y+55);
						if(!node.leftChoose&&node.rightChoose)
						{
							g2.setColor(Color.black);
							new DrawArrow(g2, oldx, oldy, currentx, currenty);
							g2.setColor(new	Color(25,25,112));	
						}
					}
				}else if(!node.leftChoose&&node.rightChoose){
					g2.setColor(Color.black);
					new DrawArrow(g2, oldx, oldy, currentx, currenty);
					g2.setColor(new	Color(25, 25, 112));
				}
				node = node.next;
			}
		}	
	}
	public void init(){
		try {
			CreatMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Registrar();
		this.resize(w,h);	
	}

	public void init(Object[][] tableData_old,JTextPane text){
		try {
			this.text = text;
			this.tableData_old = tableData_old;
			CreatMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Registrar();
		this.resize(w,h);	
	}

	private void CreatMap() throws IOException {
		w=1446-130;
		h=820-110;
		getContentPane().setLayout(null);
		UIManager.put("SplitPaneUI","org.LYG.GUI.platForm.UnicornSplitPaneUI");
		UIManager.put("ScrollBarUI", "org.LYG.GUI.platForm.UnicornScrollBarUI");
		UIManager.put("TreeUI", "org.LYG.GUI.platForm.UnicornTreeUI");
		currentNodeName=new String("");
		thislist=new LinkList();
		nodeInfo= new NodeInfo();
		nodeView= new NodeShow(this.tableData_old, this.text);
		nodeView.tree.setBackground(Color.white);
		nodeView.setBounds(10, 168, 137, 222);
		nodeProject=new NodeProject();
		nodeProject.setBounds(10, 38, 137, 124);	
		mainsplitPane = new UnicornJSplitPane();
		mainsplitPane.setAutoscrolls(true);
		//mainsplitPane.setEnabled(false);//
		mainsplitPane.setBounds(10, 50, w-20, h-80);
		mainsplitPane.setVisible(true);
		getContentPane().add(mainsplitPane);
		leftsplitPane = new UnicornJSplitPane();
		leftsplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainsplitPane.setLeftComponent(leftsplitPane);
		leftsplitPane.setLeftComponent(nodeProject);
		leftsplitPane.setRightComponent(nodeView);
		rightsplitPane = new UnicornJSplitPane();
		rightsplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainsplitPane.setRightComponent(rightsplitPane);
		righttopsplitPane = new UnicornJSplitPane();
		rightsplitPane.setLeftComponent(righttopsplitPane);
		righttopscrollPane = new JScrollPane();
		canvas = new thisCanvas();
		canvas.setPreferredSize(new Dimension(1500,1000));
		canvas.setEnabled(true);
		righttopscrollPane.setViewportView(canvas);
		righttopsplitPane.setLeftComponent(righttopscrollPane);
		rightrightscrollPane = new JScrollPane();
		righttopsplitPane.setRightComponent(nodeInfo);
		rightBotJTextPane = new JTextPane();
		rightBotJTextPane.setText("你好，亲~");
		rightdownscrollPane = new JScrollPane(rightBotJTextPane);
		rightsplitPane.setRightComponent(rightdownscrollPane);
		popupMenu = new PopupMenu();
		menuItem = new MenuItem();
		menuItem.setLabel("add");
		popupMenu.add(menuItem);
		nodeMenu = new PopupMenu();
		configre = new MenuItem();
		configre.setLabel("配置");
		run = new MenuItem();
		run.setLabel("运行");
		show = new MenuItem();
		show.setLabel("显示");
		dnode = new MenuItem();
		dnode.setLabel("删除该节");
		dline = new MenuItem();
		dline.setLabel("删除链接");
		nodeMenu.add(configre);
		nodeMenu.add(run);
		nodeMenu.add(show);
		nodeMenu.add(dnode);
		nodeMenu.add(dline);  
		getContentPane().add(popupMenu);
		getContentPane().add(nodeMenu);
		engineMenu= new PopupMenu();
		load= new MenuItem();
		load.setLabel("载入已有ETL");
		save= new MenuItem();
		save.setLabel("保存当先ETL");
		saveAs= new MenuItem();
		saveAs.setLabel("创建一个新的文档并保存");
		delete= new MenuItem();
		delete.setLabel("删除当前ETL");
		engineMenu.add(load);
		engineMenu.add(save);
		engineMenu.add(saveAs);
		engineMenu.add(delete);
		getContentPane().add(engineMenu);
		getContentPane().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {}
	public void itemStateChanged(ItemEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {
		TreePath path = nodeView.tree.getPathForLocation(arg0.getX(), arg0.getY());
		if (path != null){
			nodeView.tree.setSelectionPath(path);
			if (arg0.getButton() == 3){
				popupMenu.show(nodeView.tree, arg0.getX(), arg0.getY());
			}else {
				engineMenu.show(canvas, 0, 0);
			}
		}else {
			engineMenu.show(canvas, 0, 0);
		}	
	}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg0) {}
}
