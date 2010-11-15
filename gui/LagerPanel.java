package gui;


import javax.swing.JPanel;
import java.awt.GridLayout;


public class LagerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private RegistrerNyMellemvarePanel registrerNyMellemvarePanel = null;
	private H�ndterMellemvarePanel h�ndterMellemvarePanel = null;
	private VisListPanel visListPanel = null;

	/**
	 * This is the default constructor
	 */
	public LagerPanel() {
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
		this.setSize(457, 265);
		this.add(getRegistrerNyMellemvarePanel(), null);
		this.add(getH�ndterMellemvarePanel(), null);
		this.add(getVisListPanel(), null);
	}

	/**
	 * This method initializes registrerNyMellemvarePanel	
	 * 	
	 * @return gui.RegistrerNyMellemvarePanel	
	 */
	private RegistrerNyMellemvarePanel getRegistrerNyMellemvarePanel() {
		if (registrerNyMellemvarePanel == null) {
			registrerNyMellemvarePanel = new RegistrerNyMellemvarePanel();
			registrerNyMellemvarePanel.setBorder(MainFrame.getBorder());
		}
		return registrerNyMellemvarePanel;
	}

	/**
	 * This method initializes h�ndterMellemvarePanel	
	 * 	
	 * @return gui.H�ndterMellemvarePanel	
	 */
	private H�ndterMellemvarePanel getH�ndterMellemvarePanel() {
		if (h�ndterMellemvarePanel == null) {
			h�ndterMellemvarePanel = new H�ndterMellemvarePanel();
			h�ndterMellemvarePanel.setBorder(MainFrame.getBorder());
		}
		return h�ndterMellemvarePanel;
	}

	/**
	 * This method initializes visListPanel	
	 * 	
	 * @return gui.VisListPanel	
	 */
	private VisListPanel getVisListPanel() {
		if (visListPanel == null) {
			visListPanel = new VisListPanel();
			visListPanel.setBorder(MainFrame.getBorder());
		}
		return visListPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="9,20"
