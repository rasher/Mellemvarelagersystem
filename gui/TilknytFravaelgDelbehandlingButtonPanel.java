package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TilknytFravaelgDelbehandlingButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton tilknytButton = null;
	private JButton fravælgButton = null;
	private OpretBehandlingPanel opretBehandlingPanel;

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
			tilknytButton.setText("\u039B");
			tilknytButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					opretBehandlingPanel.tilknytValgtDelbehandling();
				}
			});
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
			fravælgButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					opretBehandlingPanel.fravælgValgtDelbehandling();

				}
			});
		}
		return fravælgButton;
	}

	/**
	 * @param opretBehandlingPanel
	 */
	public void setOpretBehandlingPanel(
			OpretBehandlingPanel opretBehandlingPanel) {
		this.opretBehandlingPanel = opretBehandlingPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
