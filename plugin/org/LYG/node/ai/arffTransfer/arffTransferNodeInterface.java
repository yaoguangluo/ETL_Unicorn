package org.LYG.node.ai.arffTransfer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import org.LYG.GUI.OSGI.*;
public class arffTransferNodeInterface extends objectInterface{	
	public arffTransferNodeInterface() throws IOException{
		thisicon=new ImageIcon(this.getClass().getResource("1.jpg"));
		thisname=new String("arffTransfer");
		position=new String("BI");
		Image img = ((ImageIcon) thisicon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisimage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisicon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		thisview=new arffTransferNodeView();
		thisrun=new arffTransferNodeRun();
		thispanel=new arffTransferNodePanel((arffTransferNodeRun) thisrun);
		thispanel.config();
		showed=false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((arffTransferNodeRun) thisrun).run((arffTransferNodeView) thisview);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisview.view();
		showed=true;
	}
	public objectInterface luoyaoguang() throws CloneNotSupportedException, IOException {
		stu = new arffTransferNodeInterface();
		return stu;  
	}
}
