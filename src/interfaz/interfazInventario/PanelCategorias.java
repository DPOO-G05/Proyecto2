package interfaz.interfazInventario;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import appInventario.Categoria;
import appInventario.Gondola;
import appInventario.Producto;
import appInventario.Referencia;
import interfaz.CoordinadorUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.tree.*;

public class PanelCategorias extends JPanel {
	
	private JTree jtCategorias;
	private	UIInventario principalInventario;

	public PanelCategorias(UIInventario principalInventario) {
		//Inicializar
		this.principalInventario = principalInventario;

		//Caracteristicas del Panel
		this.setPreferredSize(new Dimension(150, 600));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    setLayout(new GridLayout(1, 1, 0, 0));

		//Popular el JTree
	    popularCategorias();
	    JScrollPane scroller = new JScrollPane(this.jtCategorias);

	    //Agregar el listener para seleccionar las categorias. 
	    MouseListener ml = new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            int selRow = jtCategorias.getRowForLocation(e.getX(), e.getY());
	            TreePath selPath = jtCategorias.getPathForLocation(e.getX(), e.getY());
	            if(selRow != -1) {
	                if(e.getClickCount() == 2) {
	                	Object objeto = selPath.getLastPathComponent();
	                	String strObjeto = objeto.toString();
	                	setProductoCategoria(strObjeto);
	                	System.out.println(strObjeto);
	                }
	            }
	        }
	    };

	    this.jtCategorias.addMouseListener(ml);
	    
	    //Agregar el scroller al panel
	    add(scroller);
	}
	
	
	public void popularCategorias()
	{
		//Inicializar el JTree
		
		CoordinadorUI coordinador = this.principalInventario.getPrincipal().getCoordinador();
		HashMap<String,Categoria> categorias = coordinador.getSistemaInventario().getCategorias();
		
		Set<String> llavesCat = categorias.keySet();
	
		
		
		//Crear el nodo raiz
		
	    DefaultMutableTreeNode categoriasNodoRaiz = new DefaultMutableTreeNode("Categorias");  
		//Iterar sobre cada uno de de las categorias
		
		for(String llaveCat: llavesCat)
		{
			Categoria cat = categorias.get(llaveCat);
			
			//Crear el nodo

			DefaultMutableTreeNode nodoCat = new DefaultMutableTreeNode(cat.getNombre());  
			
			//Iterar sobre las gondolas
			HashMap<String,Gondola> gondolas = cat.getGondolas();
			
			Set<String> llavesGond = gondolas.keySet();

			for(String llaveGond: llavesGond)
			{
				Gondola gond = gondolas.get(llaveGond);
				DefaultMutableTreeNode nodoGond = new DefaultMutableTreeNode(gond.getNombre());  
				nodoCat.add(nodoGond);
				//Iterar sobre las referencias de la Gondola
				HashMap<String, Referencia> referencias = gond.getReferencias();
				
				Set<String> llavesRef = referencias.keySet();
				
				for(String llaveRef: llavesRef)
				{
					Referencia referencia = referencias.get(llaveRef);
					SortedMap<LocalDate, Producto> productos = referencia.getProductos();
					DefaultMutableTreeNode nodoRef;
					if (productos.isEmpty())
					{
						nodoRef = new DefaultMutableTreeNode()
					}
					LocalDate firstKey = productos.firstKey();
					Producto prod = productos.get(firstKey);
					DefaultMutableTreeNode nodoRef = new DefaultMutableTreeNode(prod.getNombre() + "-" + llaveRef);  
					nodoGond.add(nodoRef);
				}
				
			}
			//Agregar el nodo a las categorias
			categoriasNodoRaiz.add(nodoCat);

		}
		
		//Crear el JTree
		this.jtCategorias = new JTree(categoriasNodoRaiz);
		
		
	}

	
	private void setProductoCategoria(String texto)
	{
		String[] partes = texto.split("-");
		String SKU = partes[partes.length - 1];
		
		//1. Recuperar la referencia
		CoordinadorUI coordinador = principalInventario.getPrincipal().getCoordinador();
		
		HashMap<String, Referencia> referencias = coordinador.getSistemaInventario().getReferencias();
		
		Referencia referencia = referencias.get(SKU);
		
		//2. Determinar el producto a desplegar (por default es el primero en la liste de productos de la referencia)
		Producto producto = referencia.getProductos().get(referencia.getProductos().firstKey());
		
		//3. Asignar 
		
		principalInventario.actualizarReferencia(referencia, producto, "referencia");

		
		
	}
	
	
	
	
	
	
}
