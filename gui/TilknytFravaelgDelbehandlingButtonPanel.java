package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;

public class TilknytFravaelgDelbehandlingButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton tilknytButton = null;
	private JButton fravælgButton = null;

	/**
	 * This is the default constructor
	 */
	public TilknytFravaelgDelbehandlingButtonPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setHgap(5);
		this.setLayout(gridLayout);
		this.setSize(300, 46);
		this.add(getTilknytButton(), null);
		this.add(getFravælgButton(), null);
	}

	/**
	 * This method initializes tilknytButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getTilknytButton() {
		if (tilknytButton == null) {
			tilknytButton = new JButton();
			tilknytButton.setText("Λ");
		}
		return tilknytButton;
	}

	/**
	 * This method initializes fravælgButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFravælgButton() {
		if (fravælgButton == null) {
			fravælgButton = new JButton();
			fravælgButton.setText("V");
		}
		return fravælgButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
