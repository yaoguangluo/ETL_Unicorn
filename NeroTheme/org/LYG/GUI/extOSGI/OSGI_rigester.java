package org.LYG.GUI.extOSGI;
import java.io.IOException;
import javax.swing.JTextPane;
import org.LYG.GUI.OSGI.*;
import org.LYG.node.ai.arffTransfer.arffTransferNodeInterface;
public class OSGI_rigester{
	JTextPane text;
	Object[][] tableData_old;
	public OSGI_rigester(Object[][] tableData_old, JTextPane text){
		this.text = text;
		this.tableData_old = tableData_old;
	}
	
	public NodeOSGI Rigester(NodeOSGI first, LinkOSGI link) throws IOException{
		ObjectInterface arffTransferNode = new arffTransferNodeInterface();
		first = link.addNode(first, arffTransferNode);
		return first;	
	}
}