package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Behandling;
import model.BehandlingDelbehandlingRelation;
import model.Delbehandling;
import model.Produkttype;
import model.Service;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class OpretProdukttypePanel extends JPanel implements OpretGemSletObserver {

	private static final long serialVersionUID = 1L;
	private ButtonPanel buttonPanel1 = null;
	private JComboBox vælgProdukttypeComboBox = null;
	private JComboBox tilknytBehandlingComboBox = null;
	private JLabel vælgProdukttypeLabel = null;
	private JLabel tilknytBehandlingLabel = null;
	private JLabel produkttypeInfoLabel = null;
	private JTextArea produkttypeInfoTextArea = null;
	private Produkttype aktuelProdukttype;
	private Behandling aktuelBehandling;
	private JLabel produkttypeNavnLabel = null;
	private JTextField produkttypeNavnTextField = null;
	private Service service = Service.getInstance();
	private JScrollPane infoScrollPane = null;
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
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.gridy = 7;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.weighty = 1.0;
		gridBagConstraints11.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
		gridBagConstraints51.fill = GridBagConstraints.BOTH;
		gridBagConstraints51.gridy = 3;
		gridBagConstraints51.weightx = 1.0;
		gridBagConstraints51.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints51.gridx = 0;
		GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
		gridBagConstraints41.gridx = 0;
		gridBagConstraints41.anchor = GridBagConstraints.WEST;
		gridBagConstraints41.insets = new Insets(0, 5, 1, 0);
		gridBagConstraints41.gridy = 2;
		produkttypeNavnLabel = new JLabel();
		produkttypeNavnLabel.setText("Produkttypenavn :");
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.anchor = GridBagConstraints.WEST;
		gridBagConstraints5.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints5.gridy = 6;
		produkttypeInfoLabel = new JLabel();
		produkttypeInfoLabel.setText("Info : ");
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.anchor = GridBagConstraints.WEST;
		gridBagConstraints4.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints4.fill = GridBagConstraints.NONE;
		gridBagConstraints4.gridy = 4;
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
		gridBagConstraints2.gridy = 5;
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
		gridBagConstraints.gridy = 9;
		this.setLayout(new GridBagLayout());
		this.setSize(297, 295);
		this.add(getButtonPanel1(), gridBagConstraints);
		this.add(getVælgProdukttypeComboBox(), gridBagConstraints1);
		this.add(getTilknytBehandlingComboBox(), gridBagConstraints2);
		this.add(vælgProdukttypeLabel, gridBagConstraints3);
		this.add(tilknytBehandlingLabel, gridBagConstraints4);
		this.add(produkttypeInfoLabel, gridBagConstraints5);
		this.add(getInfoScrollPane(), gridBagConstraints11);
		this.add(produkttypeNavnLabel, gridBagConstraints41);
		this.add(getProdukttypeNavnTextField(), gridBagConstraints51);
		getButtonPanel1().registerOpretGemSletObserver(this);
		getButtonPanel1().enableGemButton(false);
		getButtonPanel1().enableSletButton(false);
		getButtonPanel1().enableOpretButton(false);
		opdaterComboBox();
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
			vælgProdukttypeComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					aktuelProdukttype = (Produkttype) vælgProdukttypeComboBox.getSelectedItem();
					if(aktuelProdukttype != null)
					{
						getButtonPanel1().enableGemButton(true);
						getButtonPanel1().enableSletButton(true);
						getProdukttypeNavnTextField().setText(aktuelProdukttype.getNavn());
						getTilknytBehandlingComboBox().setSelectedItem(aktuelProdukttype.getBehandling());
						getProdukttypeInfoTextArea().setText("Produkttype: \t" + aktuelProdukttype.getNavn() + 
								"\r\n" + aktuelProdukttype.getBehandling().getNavn() + "\r\n");
					}
					else
					{
						getButtonPanel1().enableGemButton(false);
						getButtonPanel1().enableSletButton(false);
					}
				}
			});
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
			tilknytBehandlingComboBox.setRenderer(new BehandlingListCellRenderer());
			tilknytBehandlingComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					aktuelBehandling = (Behandling) tilknytBehandlingComboBox.getSelectedItem();
					if(aktuelBehandling != null)
					{
						if(aktuelProdukttype != null)
							getProdukttypeInfoTextArea().setText("Produkttype: \t" + aktuelProdukttype.getNavn() + 
									"\r\n" + aktuelProdukttype.getBehandling().getNavn() + "\r\n");
						else
							getProdukttypeInfoTextArea().setText("");
						getButtonPanel1().enableOpretButton(true);
						for(BehandlingDelbehandlingRelation bdr : aktuelBehandling.getBehandlingDelbehandlingRelation())
						{
							getProdukttypeInfoTextArea().append("Navn: \t" + bdr.getDelbehandling().getNavn() + "\n\r BehandlingsSted: \t" 
									+ bdr.getDelbehandling().getBehandlingsSted() + "\n\r Min. Tørringstid:\t" + bdr.getDelbehandling().getMinimumTørringsTid()
									+ "\n\r Opt. Tørringstid:\t" + bdr.getDelbehandling().getOptimalTørringsTid() + "\n\r " +
									"Maks. Tørringstid:\t" + bdr.getDelbehandling().getMaksimumTørringsTid() + "\n\n\r");
						}
					}
					else
						getButtonPanel1().enableOpretButton(false);
				}
			});
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

	@Override
	public void opret() {
		if(aktuelBehandling != null && !getProdukttypeNavnTextField().getText().isEmpty())
		{
			aktuelProdukttype = service.createProdukttype(aktuelBehandling);
			aktuelProdukttype.setNavn(getProdukttypeNavnTextField().getText());
			service.gemIDatabase(aktuelProdukttype);
		}
		opdaterComboBox();
	}

	@Override
	public void gem() {
		if(aktuelProdukttype != null)
		{
			aktuelProdukttype.setNavn(getProdukttypeNavnTextField().getText());
			aktuelProdukttype.setBehandling((Behandling)getTilknytBehandlingComboBox().getSelectedItem());
			service.gemIDatabase(aktuelProdukttype);
		}
		opdaterComboBox();
	}

	@Override
	public void slet() {
		if(aktuelProdukttype != null)
		{
			if(JOptionPane.showConfirmDialog(null,"Sikker på du vil slette denne produkttype? " +
					"ved at gøre dette sletter du også alle tilknyttede Mellemvare", "Sikker på du vil slette?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				service.fjernFraDatabase(aktuelProdukttype);
		}
		opdaterComboBox();
	}

	public void opdaterComboBox()
	{
		aktuelBehandling = null;
		aktuelProdukttype = null;
		getVælgProdukttypeComboBox().removeAllItems();
		getTilknytBehandlingComboBox().removeAllItems();
		for(Produkttype p : service.getProdukttyper())
			getVælgProdukttypeComboBox().addItem(p);
		for(Behandling b : service.getBehandlinger())
			getTilknytBehandlingComboBox().addItem(b);
		getProdukttypeNavnTextField().setText("");
		getProdukttypeInfoTextArea().setText("");

	}

	/**
	 * This method initializes produkttypeNavnTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getProdukttypeNavnTextField() {
		if (produkttypeNavnTextField == null) {
			produkttypeNavnTextField = new JTextField();
		}
		return produkttypeNavnTextField;
	}

	/**
	 * This method initializes infoScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getInfoScrollPane() {
		if (infoScrollPane == null) {
			infoScrollPane = new JScrollPane();
			infoScrollPane.setViewportView(getProdukttypeInfoTextArea());
		}
		return infoScrollPane;
	}

}  //  @jve:decl-index=0:visual-constraint="29,22"
