/**
 * 
 */
package gui;

import java.awt.Component;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Mellemvare;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class MellemvareOvervaagningCellRenderer extends JLabel implements
		ListCellRenderer {

	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Mellemvare mellemvare = (Mellemvare) value;
		if (mellemvare != null) {
			String text = String.format("%s batch %d (%f timer til overskredet - %tR)",
					mellemvare.getProdukttype().getNavn(),
					mellemvare.getBatchNummer(),
					((float) mellemvare.getMaksimumTørringNået().getTimeInMillis() - new GregorianCalendar().getTimeInMillis())/(3600*1000),
					mellemvare.getMaksimumTørringNået()
			);
			setText(text);
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
