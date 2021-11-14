package interfaz.interfazInventario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import appInventario.Categoria;
import appInventario.Lote;
import interfaz.CoordinadorUI;

import javax.swing.tree.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Set; 



public class PanelLotes extends JPanel {
	
	private JTree jtLotes;
	
	private UIInventario principalInventario;
	
	
	public PanelLotes(UIInventario principalInventario) 
	{
		//Inicializar
		this.principalInventario = principalInventario;

		//Configuraciones ventana
		this.setPreferredSize(new Dimension(150, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setLayout(new GridLayout(1, 1, 0, 0));
		popularLotes();
	    JScrollPane scrollerLotes = new JScrollPane(this.jtLotes);

	    //Agregar listener para detectar click sobre un lote;
	    MouseListener ml = new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            int selRow = jtLotes.getRowForLocation(e.getX(), e.getY());
	            TreePath selPath = jtLotes.getPathForLocation(e.getX(), e.getY());
	            if(selRow != -1) {
	                if(e.getClickCount() == 2) {
	                	Object objeto = selPath.getLastPathComponent();
	                	String strObjeto = objeto.toString();
	                	System.out.println(strObjeto);
	                }
	            }
	        }
	    };

	    jtLotes.addMouseListener(ml);

	    //Agregar el scroller al Panel
	    add(scrollerLotes);
		
	}
	
	
	public void popularLotes()
	{
		//Inicializar el JTree
		
		CoordinadorUI coordinador = this.principalInventario.getPrincipal().getCoordinador();
		HashMap<String,Lote> lotes = coordinador.getSistemaInventario().getLotes();
		
		Set<String> llavesLot = lotes.keySet();
	
		//Crear el nodo raiz
		
	    DefaultMutableTreeNode lotesNodoRaiz = new DefaultMutableTreeNode("Lotes");  
		//Iterar sobre cada uno de de las categorias
		
		for(String llaveLot : llavesLot)
		{
			Lote lote = lotes.get(llaveLot);
			
			//Crear el nodo

			DefaultMutableTreeNode nodoLot = new DefaultMutableTreeNode(llaveLot);  
			//Agregar el nodo a las categorias
			lotesNodoRaiz.add(nodoLot);

		}
		
		this.jtLotes = new JTree(lotesNodoRaiz);
	
	}
	
}

