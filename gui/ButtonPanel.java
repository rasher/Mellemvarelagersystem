package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton opretButton = null;
	private JButton gemButton = null;
	private JButton sletButton = null;

	/**
	 * This is the default constructor
	 */
	public ButtonPanel() {
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
		this.setLayout(gridLayout);
		this.setSize(366, 39);
		this.add(getOpretButton(), null);
		this.add(getGemButton(), null);
		this.add(getSletButton(), null);
	}

	/**
	 * This method initializes opretButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOpretButton() {
		if (opretButton == null) {
			opretButton = new JButton();
			opretButton.setText("Opret");
		}
		return opretButton;
	}

	/**
	 * This method initializes gemButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getGemButton() {
		if (gemButton == null) {
			gemButton = new JButton();
			gemButton.setText("Gem");
		}
		return gemButton;
	}

	/**
	 * This method initializes sletButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSletButton() {
		if (sletButton == null) {
			sletButton = new JButton();
			sletButton.setText("Slet");
		}
		return sletButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
