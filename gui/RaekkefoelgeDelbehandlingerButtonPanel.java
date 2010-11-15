package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;

public class RaekkefoelgeDelbehandlingerButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton rykOPButton = null;
	private JButton rykNedButton = null;

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
	 * This method initializes rykOPButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRykOPButton() {
		if (rykOPButton == null) {
			rykOPButton = new JButton();
			rykOPButton.setText("↑");
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
		}
		return rykNedButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
