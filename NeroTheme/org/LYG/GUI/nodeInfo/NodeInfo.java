package org.LYG.GUI.nodeInfo;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import org.LYG.sets.stable.StableData;
@SuppressWarnings({StableData.TAG_UNCHECKED, StableData.TAG_RAW_TYPES})
public class NodeInfo extends JScrollPane {
	private static final long serialVersionUID= 866589699634559456L;
	String[] countryStrings= {"china", "ca", "denmark", "fr", "genmany"
			, "india", "norway", "uk", "us"};
	private ImageIcon[] images= { 
			new ImageIcon(this.getClass().getResource("china.gif")),
			new ImageIcon(this.getClass().getResource("us.gif")),
			new ImageIcon(this.getClass().getResource("denmark.gif")), 
			new ImageIcon(this.getClass().getResource("fr.gif")),
			new ImageIcon(this.getClass().getResource("germany.gif")),
			new ImageIcon(this.getClass().getResource("india.gif")),
			new ImageIcon(this.getClass().getResource("norway.gif")), 
			new ImageIcon(this.getClass().getResource("uk.gif")),
			new ImageIcon(this.getClass().getResource("ca.gif")) };

	public NodeInfo() {	
		Integer[] intArray= new Integer[countryStrings.length];
		JComboBox countryList= new JComboBox(intArray);
		countryList.setMaximumRowCount(5);
		for (int i= 0; i< countryStrings.length; i++) {
			intArray[i]= new Integer(i);
			if (images[i]!= null) {
				images[i].setImage(images[i].getImage().getScaledInstance
						(50, 50, Image.SCALE_DEFAULT));
				images[i].setDescription(countryStrings[i]);
			}
		}
		countryList.removeAllItems();
		for(int i=0; i<images.length; i++) {
			countryList.addItem(images[i]);
		}
		this.setViewportView(countryList);    
		this.validate();
	}
}