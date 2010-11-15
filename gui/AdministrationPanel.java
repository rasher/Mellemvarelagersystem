package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

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
	}

	/**
	 * This method initializes opretProdukttypePanel	
	 * 	
	 * @return gui.OpretProdukttypePanel	
	 */
	private OpretProdukttypePanel getOpretProdukttypePanel() {
		if (opretProdukttypePanel == null) {
			opretProdukttypePanel = new OpretProdukttypePanel();
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
		}
		return opretDelbehandlingPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
