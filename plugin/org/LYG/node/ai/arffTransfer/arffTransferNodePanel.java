package org.LYG.node.ai.arffTransfer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import org.LYG.GUI.OSGI.*;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Color;
public class arffTransferNodePanel extends objectPanel
{
	private static final long serialVersionUID = 1L;
	private FileDialog filedialog;
	public arffTransferNodePanel(final arffTransferNodeRun thisrun)
	{
		setLayout(null);
		jsp = new ScrollPane();
		add(jsp);
		jp=new Panel();
		jp.setLayout(null);
		
		
		jp.setBackground(Color.white);
		JButton button = new JButton("Finish");
		button.setBounds(0, 0, 100, 30);
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(e.getSource());
                	close=true;
                	thisrun.value=1;
            }
        });   
		jp.add(button);
		JButton readfile= new JButton("Write File");
		readfile.setBounds(0, 35, 100, 65);
		readfile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				 filedialog=new FileDialog(new Frame(),"filechoose",FileDialog.LOAD);
				 filedialog.setVisible(true);
				 thisrun.filepath=filedialog.getDirectory()+filedialog.getFile();
			     System.out.println(thisrun.filepath);
				}
			});
		jp.add(readfile);
		jsp.add(jp);
		close=false;
		this.setClosable(true);
 	}
	public void config()
	{    
		System.out.println("configued");      
	}
}
