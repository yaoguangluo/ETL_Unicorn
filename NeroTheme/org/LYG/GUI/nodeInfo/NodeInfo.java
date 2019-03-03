package org.LYG.GUI.nodeInfo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings({"unchecked","rawtypes"})
public class NodeInfo extends JScrollPane {
	private static final long serialVersionUID = 866589699634559456L;
	String[] petStrings = {"china", "ca", "denmark", "fr", "genmany","india","norway","uk","us"};
	private ImageIcon[] images = { 
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
		Integer[] intArray = new Integer[petStrings.length];
		for (int i = 0; i < petStrings.length; i++) {
			intArray[i] = new Integer(i);
			if (images[i] != null) {
				images[i].setImage(images[i].getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
				images[i].setDescription(petStrings[i]);
			}
		}

		//Create the combo box.
		JComboBox petList = new JComboBox(intArray);
		ComboBoxRenderer renderer= new ComboBoxRenderer();
		renderer.setPreferredSize(new Dimension(50, 130));
		petList.setRenderer(renderer);
		petList.setMaximumRowCount(5);
		this.setViewportView(petList);    
	}
	protected  ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = NodeInfo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Font uhOhFont;

		public ComboBoxRenderer() {
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}
		public Component getListCellRendererComponent(
				JList list,
				Object value,
				int index,
				boolean isSelected,
				boolean cellHasFocus)
		{
			int selectedIndex = ((Integer)value).intValue();
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			ImageIcon icon = images[selectedIndex];
			String pet = petStrings[selectedIndex];
			setIcon(icon);
			if (icon != null) {
				//setText(pet);
				//setFont(list.getFont());
			} else {
				setUhOhText(pet + " (no image available)",
						list.getFont());
			}
			return this;
		}

		protected void setUhOhText(String uhOhText, Font normalFont){
			if (uhOhFont == null) {  
				uhOhFont = normalFont.deriveFont(Font.ITALIC);
			}
			setFont(uhOhFont);
			setText(uhOhText);
		}
	}
}