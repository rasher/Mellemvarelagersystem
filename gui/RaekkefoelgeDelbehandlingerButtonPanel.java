package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RaekkefoelgeDelbehandlingerButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton rykOPButton = null;
	private JButton rykNedButton = null;
	private OpretBehandlingPanel opretBehandlingPanel;

	/**
	 * This is the default constructor
	 */
	public RaekkefoelgeDelbehandlingerButtonPanel() {
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
		gridLayout.setRows(2);
		gridLayout.setVgap(5);
		this.setLayout(gridLayout);
		this.setSize(65, 100);
		this.add(getRykOPButton(), null);
		this.add(getRykNedButton(), null);
	}

	/**
	 * @param opretBehandlingPanel the opretBehandlingPanel to set
	 */
	public void setOpretBehandlingPanel(OpretBehandlingPanel opretBehandlingPanel) {
		this.opretBehandlingPanel = opretBehandlingPanel;
	}

	/**
	 * This method initializes rykOPButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRykOPButton() {
		if (rykOPButton == null) {
			rykOPButton = new JButton();
			rykOPButton.setText("↑");
			rykOPButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					opretBehandlingPanel.flytDelbehandlingOp();
				}
			});
		}
		return rykOPButton;
	}

	/**
	 * This method initializes rykNedButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRykNedButton() {
		if (rykNedButton == null) {
			rykNedButton = new JButton();
			rykNedButton.setText("↓");
			rykNedButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					opretBehandlingPanel.flytDelbehandlingNed();
				}
			});		}
		return rykNedButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
