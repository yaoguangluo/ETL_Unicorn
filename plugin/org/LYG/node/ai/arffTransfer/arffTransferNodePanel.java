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
public class arffTransferNodePanel extends ObjectPanel{
	private static final long serialVersionUID = 1L;
	private FileDialog filedialog;
	public arffTransferNodePanel(final arffTransferNodeRun thisRun){
		setLayout(null);
		scrollPane = new ScrollPane();
		add(scrollPane);
		panel= new Panel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JButton button= new JButton("Finish");
		button.setBounds(0, 0, 100, 30);
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	System.out.println(e.getSource());
                	close=true;
                	thisRun.value=1;
            }
        });   
		panel.add(button);
		JButton readfile= new JButton("Write File");
		readfile.setBounds(0, 35, 100, 65);
		readfile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				 filedialog=new FileDialog(new Frame(),"filechoose",FileDialog.LOAD);
				 filedialog.setVisible(true);
				 thisRun.filepath=filedialog.getDirectory()+filedialog.getFile();
			     System.out.println(thisRun.filepath);
				}
			});
		panel.add(readfile);
		scrollPane.add(panel);
		close=false;
 	}
	public void config(){    
		System.out.println("configued");      
	}
}
