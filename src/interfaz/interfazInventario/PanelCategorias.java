package interfaz.interfazInventario;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class PanelCategorias extends JPanel {
	public PanelCategorias() {
		this.setPreferredSize(new Dimension(150, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    DefaultMutableTreeNode style=new DefaultMutableTreeNode("Style");  
	    DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");  
	    DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");  
	    style.add(color);  
	    style.add(font);  
	    DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");  
	    DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");  
	    DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");  
	    DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");  
	    color.add(red); color.add(blue); color.add(black); color.add(green);
	    setLayout(new GridLayout(1, 1, 0, 0));
	    JTree jt=new JTree(style);
	    JScrollPane qPane = new JScrollPane(jt);

	    add(qPane);
	    //add(jt);
		
	}
}
