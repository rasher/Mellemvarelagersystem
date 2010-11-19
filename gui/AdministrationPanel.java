package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class AdministrationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private OpretProdukttypePanel opretProdukttypePanel = null;
	private OpretBehandlingPanel opretBehandlingPanel = null;
	private OpretDelbehandlingPanel opretDelbehandlingPanel = null;

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
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setHgap(5);
		this.setLayout(gridLayout);
		this.setSize(626, 366);
		this.add(getOpretProdukttypePanel(), null);
		this.add(getOpretBehandlingPanel(), null);
		this.add(getOpretDelbehandlingPanel(), null);
		getOpretBehandlingPanel().setOpretProdukttypePanel(getOpretProdukttypePanel());
		getOpretDelbehandlingPanel().setOpretBehandlingPanel(getOpretBehandlingPanel());
	}

	/**
	 * This method initializes opretProdukttypePanel	
	 * 	
	 * @return gui.OpretProdukttypePanel	
	 */
	private OpretProdukttypePanel getOpretProdukttypePanel() {
		if (opretProdukttypePanel == null) {
			opretProdukttypePanel = new OpretProdukttypePanel();
			opretProdukttypePanel.setBorder(MainFrame.getBorder());
		}
		return opretProdukttypePanel;
	}

	/**
	 * This method initializes opretBehandlingPanel	
	 * 	
	 * @return gui.OpretBehandlingPanel	
	 */
	private OpretBehandlingPanel getOpretBehandlingPanel() {
		if (opretBehandlingPanel == null) {
			opretBehandlingPanel = new OpretBehandlingPanel();
			opretBehandlingPanel.setBorder(MainFrame.getBorder());
		}
		return opretBehandlingPanel;
	}

	/**
	 * This method initializes opretDelbehandlingPanel	
	 * 	
	 * @return gui.OpretDelbehandlingPanel	
	 */
	private OpretDelbehandlingPanel getOpretDelbehandlingPanel() {
		if (opretDelbehandlingPanel == null) {
			opretDelbehandlingPanel = new OpretDelbehandlingPanel();
			opretDelbehandlingPanel.setBorder(MainFrame.getBorder());
		}
		return opretDelbehandlingPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
