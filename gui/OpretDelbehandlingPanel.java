package gui;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class OpretDelbehandlingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ButtonPanel buttonPanel1 = null;
	private DelbehandlingDelPanel delbehandlingDelPanel = null;
	/**
	 * This is the default constructor
	 */
	public OpretDelbehandlingPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setBounds(new Rectangle(0, 0, 211, 207));
		this.add(getDelbehandlingDelPanel(), BorderLayout.NORTH);
		this.add(getButtonPanel1(), BorderLayout.SOUTH);
	}

	/**
	 * This method initializes buttonPanel1	
	 * 	
	 * @return gui.ButtonPanel	
	 */
	private ButtonPanel getButtonPanel1() {
		if (buttonPanel1 == null) {
			buttonPanel1 = new ButtonPanel();
		}
		return buttonPanel1;
	}

	/**
	 * This method initializes delbehandlingDelPanel	
	 * 	
	 * @return gui.DelbehandlingDelPanel	
	 */
	private DelbehandlingDelPanel getDelbehandlingDelPanel() {
		if (delbehandlingDelPanel == null) {
			delbehandlingDelPanel = new DelbehandlingDelPanel();
		}
		return delbehandlingDelPanel;
	}


}  //  @jve:decl-index=0:visual-constraint="36,37"
