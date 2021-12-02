package interfaz.interfazPOS;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import appInventario.Producto;
import appInventario.Referencia;

import java.awt.*;

public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
{
	@Override
	public Component getListCellRendererComponent(JList<?>list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		
		Referencia item = (Referencia) value;
		setText(item.getNombre());
		setIcon(new ImageIcon(item.getRutaImagen()));
		
		if(isSelected)
		{
			setBackground(list.getSelectionBackground());
		}
		else
		{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		setEnabled(true);
		setFont(list.getFont());
		
		return this;

	}
}
