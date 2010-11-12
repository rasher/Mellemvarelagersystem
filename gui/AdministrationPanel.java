package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class AdministrationPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * This is the default constructor
	 */
	public AdministrationPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
	}

}  //  @jve:decl-index=0:visual-constraint="32,43"
