/**
 * 
 */
package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.BehandlingDelbehandlingRelation;
import model.Delbehandling;

/**
 * @author Jonas Häggqvist (10dm10v1)
 * 
 */
@SuppressWarnings("serial")
public class BehandlingDelbehandlingRelationListCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 * 
	 */
	public BehandlingDelbehandlingRelationListCellRenderer() {
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
		Delbehandling delbehandling = ((BehandlingDelbehandlingRelation) value).getDelbehandling();
		if (delbehandling != null) {
			setText(delbehandling.getNavn());
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
