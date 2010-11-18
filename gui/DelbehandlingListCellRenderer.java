/**
 * 
 */
package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Delbehandling;

/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
@SuppressWarnings("serial")
public class DelbehandlingListCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 * 
	 */
	public DelbehandlingListCellRenderer() {
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Delbehandling delbehandling = (Delbehandling) value;
		if (delbehandling != null) {
			setText(delbehandling.getNavn() + " " + delbehandling.toString());
		}
		
		if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		return this;
	}

}
