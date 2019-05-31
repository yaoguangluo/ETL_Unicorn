package org.LYG.node.ai.arffTransfer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import org.LYG.GUI.OSGI.*;
public class arffTransferNodeInterface extends ObjectInterface{	
	public arffTransferNodeInterface() throws IOException{
		thisIcon=new ImageIcon(this.getClass().getResource("1.jpg"));
		thisName=new String("arffTransfer");
		position=new String("BI");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		thisView=new arffTransferNodeView();
		thisRun=new arffTransferNodeRun();
		thisPanel=new arffTransferNodePanel((arffTransferNodeRun) thisRun);
		thisPanel.config();
		showed=false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((arffTransferNodeRun) thisRun).run((arffTransferNodeView) thisView);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisView.view();
		showed=true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {
		thisInterface = new arffTransferNodeInterface();
		return thisInterface;  
	}
}
