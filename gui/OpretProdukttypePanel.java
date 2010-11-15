package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OpretProdukttypePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ButtonPanel buttonPanel1 = null;
	private JComboBox vælgProdukttypeComboBox = null;
	private JComboBox tilknytBehandlingComboBox = null;
	private JLabel vælgProdukttypeLabel = null;
	private JLabel tilknytBehandlingLabel = null;
	private JLabel produkttypeInfoLabel = null;
	private JTextArea produkttypeInfoTextArea = null;
	/**
	 * This is the default constructor
	 */
	public OpretProdukttypePanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.fill = GridBagConstraints.BOTH;
		gridBagConstraints6.gridy = 5;
		gridBagConstraints6.weightx = 1.0;
		gridBagConstraints6.weighty = 1.0;
		gridBagConstraints6.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints6.gridx = 0;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.anchor = GridBagConstraints.WEST;
		gridBagConstraints5.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints5.gridy = 4;
		produkttypeInfoLabel = new JLabel();
		produkttypeInfoLabel.setText("Info : ");
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.anchor = GridBagConstraints.WEST;
		gridBagConstraints4.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints4.fill = GridBagConstraints.NONE;
		gridBagConstraints4.gridy = 2;
		tilknytBehandlingLabel = new JLabel();
		tilknytBehandlingLabel.setText("Behandling : ");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.anchor = GridBagConstraints.WEST;
		gridBagConstraints3.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints3.gridy = 0;
		vælgProdukttypeLabel = new JLabel();
		vælgProdukttypeLabel.setText("Produkttype : ");
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.gridy = 3;
		gridBagConstraints2.weightx = 1.0;
		gridBagConstraints2.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints2.gridx = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.anchor = GridBagConstraints.NORTH;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridy = 6;
		this.setLayout(new GridBagLayout());
		this.setSize(297, 295);
		this.add(getButtonPanel1(), gridBagConstraints);
		this.add(getVælgProdukttypeComboBox(), gridBagConstraints1);
		this.add(getTilknytBehandlingComboBox(), gridBagConstraints2);
		this.add(vælgProdukttypeLabel, gridBagConstraints3);
		this.add(tilknytBehandlingLabel, gridBagConstraints4);
		this.add(produkttypeInfoLabel, gridBagConstraints5);
		this.add(getProdukttypeInfoTextArea(), gridBagConstraints6);
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
	 * This method initializes vælgProdukttypeComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getVælgProdukttypeComboBox() {
		if (vælgProdukttypeComboBox == null) {
			vælgProdukttypeComboBox = new JComboBox();
		}
		return vælgProdukttypeComboBox;
	}

	/**
	 * This method initializes tilknytBehandlingComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTilknytBehandlingComboBox() {
		if (tilknytBehandlingComboBox == null) {
			tilknytBehandlingComboBox = new JComboBox();
		}
		return tilknytBehandlingComboBox;
	}

	/**
	 * This method initializes produkttypeInfoTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getProdukttypeInfoTextArea() {
		if (produkttypeInfoTextArea == null) {
			produkttypeInfoTextArea = new JTextArea();
			produkttypeInfoTextArea.setBorder(MainFrame.getBorder());
		}
		return produkttypeInfoTextArea;
	}

}  //  @jve:decl-index=0:visual-constraint="29,22"
