package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.persistence.RollbackException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import model.Behandling;
import model.BehandlingDelbehandlingRelation;
import model.Delbehandling;
import model.Service;

public class OpretBehandlingPanel extends JPanel implements OpretGemSletObserver {

	private static final long serialVersionUID = 1L;
	private JLabel vælgBehandlingLabel = null;
	private JComboBox vælgBehandlingComboBox = null;
	private JLabel valgteDelbehandlingerLabel = null;
	private JList valgteDelbehandlingerList = null;
	private JLabel muligeDelbehandlingerLabel = null;
	private JList muligeDelbehandlingerList = null;
	private ButtonPanel behandlingButtonPanel = null;
	private TilknytFravaelgDelbehandlingButtonPanel tilknytFravælgDelbehandlingButtonPanel = null;
	private JLabel behandlingsNavnLabel = null;
	private JTextField behandlingsNavnTextField = null;
	private RaekkefoelgeDelbehandlingerButtonPanel raekkefoelgeDelbehandlingerButtonPanel = null;
	private Service service = Service.getInstance();  //  @jve:decl-index=0:
	private DefaultListModel valgteDelbehandlingerModel;
	private JScrollPane valgteDelbehandlingerScrollpane = null;
	private JScrollPane muligeDelbehandlingerScrollpane = null;
	private DefaultComboBoxModel vælgBehandlingModel;
	private OpretProdukttypePanel opretProdukttypePanel;
	/**
	 * This is the default constructor
	 */
	public OpretBehandlingPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
		gridBagConstraints22.fill = GridBagConstraints.BOTH;
		gridBagConstraints22.gridy = 11;
		gridBagConstraints22.weightx = 1.0;
		gridBagConstraints22.weighty = 1.0;
		gridBagConstraints22.gridwidth = 3;
		gridBagConstraints22.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints22.gridx = 0;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.gridy = 6;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.weighty = 1.0;
		gridBagConstraints11.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints11.gridwidth = 1;
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
		gridBagConstraints32.gridx = 2;
		gridBagConstraints32.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints32.gridy = 6;
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.fill = GridBagConstraints.BOTH;
		gridBagConstraints31.gridy = 3;
		gridBagConstraints31.weightx = 1.0;
		gridBagConstraints31.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints31.gridwidth = 3;
		gridBagConstraints31.gridx = 0;
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.gridx = 0;
		gridBagConstraints21.anchor = GridBagConstraints.WEST;
		gridBagConstraints21.insets = new Insets(0, 5, 1, 0);
		gridBagConstraints21.gridy = 2;
		behandlingsNavnLabel = new JLabel();
		behandlingsNavnLabel.setText("Behandlingsnavn :");
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 0;
		gridBagConstraints6.gridwidth = 3;
		gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints6.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints6.gridy = 12;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 0;
		gridBagConstraints7.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints7.gridwidth = 2;
		gridBagConstraints7.gridy = 9;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.anchor = GridBagConstraints.WEST;
		gridBagConstraints4.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints4.gridwidth = 1;
		gridBagConstraints4.gridy = 10;
		muligeDelbehandlingerLabel = new JLabel();
		muligeDelbehandlingerLabel.setText("Mulige delbehandlinger : ");
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints2.gridwidth = 1;
		gridBagConstraints2.gridy = 4;
		valgteDelbehandlingerLabel = new JLabel();
		valgteDelbehandlingerLabel.setText("Valgte delbehandlinger : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridwidth = 3;
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridy = 0;
		vælgBehandlingLabel = new JLabel();
		vælgBehandlingLabel.setText("Behandling : ");
		this.setSize(306, 300);
		this.setLayout(new GridBagLayout());
		this.add(vælgBehandlingLabel, gridBagConstraints);
		this.add(getVælgBehandlingComboBox(), gridBagConstraints1);
		this.add(valgteDelbehandlingerLabel, gridBagConstraints2);
		this.add(muligeDelbehandlingerLabel, gridBagConstraints4);
		this.add(getTilknytFravælgDelbehandlingButtonPanel(), gridBagConstraints7);
		this.add(getBehandlingButtonPanel(), gridBagConstraints6);
		this.add(behandlingsNavnLabel, gridBagConstraints21);
		this.add(getBehandlingsNavnTextField(), gridBagConstraints31);
		this.add(getRaekkefoelgeDelbehandlingerButtonPanel(), gridBagConstraints32);
		this.add(getValgteDelbehandlingerScrollpane(), gridBagConstraints11);
		this.add(getMuligeDelbehandlingerScrollpane(), gridBagConstraints22);
	}

	/**
	 * This method initializes vælgBehandlingComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getVælgBehandlingComboBox() {
		if (vælgBehandlingComboBox == null) {
			vælgBehandlingModel = new DefaultComboBoxModel();
			vælgBehandlingComboBox = new JComboBox(vælgBehandlingModel);
			for (Behandling behandling: service.getBehandlinger()) {
				vælgBehandlingModel.addElement(behandling);
			}
			vælgBehandlingComboBox.setRenderer(new BehandlingListCellRenderer());
			vælgBehandlingComboBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					opdaterFelter();
				}
			});
			opdaterFelter();
		}
		return vælgBehandlingComboBox;
	}

	private void opdaterFelter() {
		getValgteDelbehandlingerList(); // Sørg for at listen er oprettet før vi gør mere.
		Behandling valgtBehandling = (Behandling) vælgBehandlingComboBox.getSelectedItem();
		if (valgtBehandling != null) {
			valgteDelbehandlingerModel.removeAllElements();
			for (BehandlingDelbehandlingRelation bdr: valgtBehandling.getBehandlingDelbehandlingRelationer()) {
				valgteDelbehandlingerModel.addElement(bdr);			
			}
			getBehandlingsNavnTextField().setText(((Behandling) vælgBehandlingComboBox.getSelectedItem()).getNavn());
		}
		else {
			getBehandlingsNavnTextField().setText("");
			valgteDelbehandlingerModel.removeAllElements();
		}
	}
	
	public void opdaterMuligeDelbehandlinger() {
		getMuligeDelbehandlingerList().setListData(service.getDelbehandlinger().toArray());
	}

	/**
	 * This method initializes valgteDelbehandlingerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getValgteDelbehandlingerList() {
		if (valgteDelbehandlingerList == null) {
			valgteDelbehandlingerList = new JList();
			valgteDelbehandlingerList.setBorder(MainFrame.getBorder());
			valgteDelbehandlingerModel = new DefaultListModel();
			valgteDelbehandlingerList.setModel(valgteDelbehandlingerModel);
			valgteDelbehandlingerList.setCellRenderer(new BehandlingDelbehandlingRelationListCellRenderer());
		}
		return valgteDelbehandlingerList;
	}

	/**
	 * This method initializes muligeDelbehandlingerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getMuligeDelbehandlingerList() {
		if (muligeDelbehandlingerList == null) {
			muligeDelbehandlingerList = new JList();
			muligeDelbehandlingerList.setBorder(MainFrame.getBorder());
			muligeDelbehandlingerList.setCellRenderer(new DelbehandlingListCellRenderer());
			opdaterMuligeDelbehandlinger();
		}
		return muligeDelbehandlingerList;
	}

	/**
	 * This method initializes behandlingButtonPanel	
	 * 	
	 * @return gui.ButtonPanel	
	 */
	private ButtonPanel getBehandlingButtonPanel() {
		if (behandlingButtonPanel == null) {
			behandlingButtonPanel = new ButtonPanel();
			behandlingButtonPanel.registerOpretGemSletObserver(this);
		}
		return behandlingButtonPanel;
	}

	/**
	 * This method initializes tilknytFravælgDelbehandlingButtonPanel	
	 * 	
	 * @return gui.TilknytFravælgDelbehandlingButtonPanel	
	 */
	private TilknytFravaelgDelbehandlingButtonPanel getTilknytFravælgDelbehandlingButtonPanel() {
		if (tilknytFravælgDelbehandlingButtonPanel == null) {
			tilknytFravælgDelbehandlingButtonPanel = new TilknytFravaelgDelbehandlingButtonPanel();
			tilknytFravælgDelbehandlingButtonPanel.setOpretBehandlingPanel(this);
		}
		return tilknytFravælgDelbehandlingButtonPanel;
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#gem()
	 */
	@Override
	public void gem() {
		Behandling valgtBehandling = (Behandling) getVælgBehandlingComboBox().getSelectedItem();
		valgtBehandling.setNavn(getBehandlingsNavnTextField().getText());
		service.gemIDatabase(valgtBehandling);
		ListModel model = getValgteDelbehandlingerList().getModel();
		ArrayList<BehandlingDelbehandlingRelation> behandlingDelbehandlingRelationer = new ArrayList<BehandlingDelbehandlingRelation>();
		for (int i = 0; i < model.getSize(); i++) {
			BehandlingDelbehandlingRelation behandlingDelbehandlingRelation = (BehandlingDelbehandlingRelation) model.getElementAt(i);
			behandlingDelbehandlingRelation.setRækkefølge(i + 1);
			behandlingDelbehandlingRelation.setBehandling(valgtBehandling);
			behandlingDelbehandlingRelationer.add(behandlingDelbehandlingRelation);
			service.gemIDatabase(behandlingDelbehandlingRelation);
		}
		valgtBehandling.setBehandlingDelbehandlingRelationer(behandlingDelbehandlingRelationer);
		service.gemIDatabase(valgtBehandling);
		vælgBehandlingComboBox.repaint();
		opretProdukttypePanel.opdaterComboBox();
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#opret()
	 */
	@Override
	public void opret() {
		Behandling behandling = service.createBehandling();
		behandling.setNavn(getBehandlingsNavnTextField().getText());
		ListModel model = getValgteDelbehandlingerList().getModel();
		service.gemIDatabase(behandling);
		for (int i = 0; i < model.getSize(); i++) {
			BehandlingDelbehandlingRelation behandlingDelbehandlingRelation = (BehandlingDelbehandlingRelation) model.getElementAt(i);
			behandlingDelbehandlingRelation.setRækkefølge(i + 1);
			behandlingDelbehandlingRelation.setBehandling(behandling);
			behandling.addBehandlingDelbehandlingRelation(behandlingDelbehandlingRelation);
			service.gemIDatabase(behandlingDelbehandlingRelation);
		}
		service.gemIDatabase(behandling);
		vælgBehandlingModel.addElement(behandling);
		vælgBehandlingComboBox.setSelectedItem(behandling);
		opdaterFelter();
		opretProdukttypePanel.opdaterComboBox();
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#slet()
	 */
	@Override
	public void slet() {
		System.out.println("Slet");
		Behandling valgtBehandling = (Behandling) getVælgBehandlingComboBox().getSelectedItem();
		if (valgtBehandling != null) {
			try {
				service.fjernFraDatabase(valgtBehandling);
				vælgBehandlingModel.removeElement(valgtBehandling);
			} catch (RollbackException e) {
				JOptionPane.showMessageDialog(this, "Du kan ikke slette denne behandling mens der findes produkttyper der benytter den", "Behandling ikke slettet", JOptionPane.ERROR_MESSAGE);
			}
			opdaterFelter();
			opretProdukttypePanel.opdaterComboBox();
		}
	}

	/**
	 * This method initializes behandlingsNavnTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBehandlingsNavnTextField() {
		if (behandlingsNavnTextField == null) {
			behandlingsNavnTextField = new JTextField();
		}
		return behandlingsNavnTextField;
	}

	/**
	 * This method initializes raekkefoelgeDelbehandlingerButtonPanel	
	 * 	
	 * @return gui.RaekkefoelgeDelbehandlingerButtonPanel	
	 */
	private RaekkefoelgeDelbehandlingerButtonPanel getRaekkefoelgeDelbehandlingerButtonPanel() {
		if (raekkefoelgeDelbehandlingerButtonPanel == null) {
			raekkefoelgeDelbehandlingerButtonPanel = new RaekkefoelgeDelbehandlingerButtonPanel();
			raekkefoelgeDelbehandlingerButtonPanel.setOpretBehandlingPanel(this);
		}
		return raekkefoelgeDelbehandlingerButtonPanel;
	}

	/**
	 * 
	 */
	public void flytDelbehandlingOp() {
		DefaultListModel model = valgteDelbehandlingerModel;
		int valgtIndex = getValgteDelbehandlingerList().getSelectedIndex();
		if (valgtIndex > 0) {
			Object temp = model.get(valgtIndex);
			model.insertElementAt(temp, valgtIndex - 1); // Indsæt over
			model.remove(valgtIndex + 1); // Fjern den gamle
			valgteDelbehandlingerList.setSelectedIndex(valgtIndex - 1);
		}
	}

	/**
	 * 
	 */
	public void flytDelbehandlingNed() {
		DefaultListModel model = valgteDelbehandlingerModel;
		int valgtIndex = getValgteDelbehandlingerList().getSelectedIndex();
		if (valgtIndex > 0 && valgtIndex < model.getSize()-1) {
			Object temp = model.get(valgtIndex);
			model.insertElementAt(temp, valgtIndex + 2); // Indsæt under
			model.remove(valgtIndex); // Fjern den gamle
			valgteDelbehandlingerList.setSelectedIndex(valgtIndex + 1);
		}
	}

	/**
	 * 
	 */
	public void fravælgValgtDelbehandling() {
		BehandlingDelbehandlingRelation valgtDelbehandling = (BehandlingDelbehandlingRelation) getValgteDelbehandlingerList().getSelectedValue();
		System.out.println("Fravælg valgt delbehandling: " + valgtDelbehandling);
		int valgtIndex = getValgteDelbehandlingerList().getSelectedIndex();
		if (valgtIndex > -1) {
			valgteDelbehandlingerModel.remove(valgtIndex);
			getValgteDelbehandlingerList().setSelectedIndex(Math.max(valgtIndex, valgteDelbehandlingerModel.getSize()-1));
		}
	}

	/**
	 * 
	 */
	public void tilknytValgtDelbehandling() {
		Delbehandling valgtDelbehandling = (Delbehandling) getMuligeDelbehandlingerList().getSelectedValue();
		Behandling valgtBehandling = (Behandling) getVælgBehandlingComboBox().getSelectedItem();
		if (valgtDelbehandling != null && valgtBehandling != null) {
			BehandlingDelbehandlingRelation nyDelbehandlingRelation = service.createBehandlingDelbehandlingRelation();
			nyDelbehandlingRelation.setDelbehandling(valgtDelbehandling);
			valgteDelbehandlingerModel.addElement(nyDelbehandlingRelation);
		}
		System.out.println("Tilknyt valgt delbehandling: " + valgtDelbehandling);
	}

	/**
	 * This method initializes valgteDelbehandlingerScrollpane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getValgteDelbehandlingerScrollpane() {
		if (valgteDelbehandlingerScrollpane == null) {
			valgteDelbehandlingerScrollpane = new JScrollPane();
			valgteDelbehandlingerScrollpane.setViewportView(getValgteDelbehandlingerList());
		}
		return valgteDelbehandlingerScrollpane;
	}

	/**
	 * This method initializes muligeDelbehandlingerScrollpane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getMuligeDelbehandlingerScrollpane() {
		if (muligeDelbehandlingerScrollpane == null) {
			muligeDelbehandlingerScrollpane = new JScrollPane();
			muligeDelbehandlingerScrollpane.setViewportView(getMuligeDelbehandlingerList());
		}
		return muligeDelbehandlingerScrollpane;
	}

	/**
	 * @param opretProdukttypePanel
	 */
	public void setOpretProdukttypePanel(
			OpretProdukttypePanel opretProdukttypePanel) {
		this.opretProdukttypePanel = opretProdukttypePanel;
	}

}  //  @jve:decl-index=0:visual-constraint="151,143"
