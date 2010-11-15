package gui;


import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JPanel;


public class LagerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private RegistrerNyMellemvarePanel registrerNyMellemvarePanel = null;
	private HaandterMellemvarePanel håndterMellemvarePanel = null;
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
		this.setPreferredSize(new Dimension(800, 500));
		this.add(getRegistrerNyMellemvarePanel(), null);
		this.add(getHåndterMellemvarePanel(), null);
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
	 * This method initializes håndterMellemvarePanel	
	 * 	
	 * @return gui.HåndterMellemvarePanel	
	 */
	private HaandterMellemvarePanel getHåndterMellemvarePanel() {
		if (håndterMellemvarePanel == null) {
			håndterMellemvarePanel = new HaandterMellemvarePanel();
			håndterMellemvarePanel.setBorder(MainFrame.getBorder());
		}
		return håndterMellemvarePanel;
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
