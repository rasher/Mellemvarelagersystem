package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import model.Behandling;
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
	private RaekkefoelgeDelbehandlingerButtonPanel rækkefølgeDelbehandlingerPanel = null;
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
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 0;
		gridBagConstraints6.gridwidth = 2;
		gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints6.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints6.gridy = 7;
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.gridx = 1;
		gridBagConstraints8.fill = GridBagConstraints.NONE;
		gridBagConstraints8.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints8.gridy = 3;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 0;
		gridBagConstraints7.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints7.gridwidth = 2;
		gridBagConstraints7.gridy = 4;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.gridy = 6;
		gridBagConstraints5.weightx = 1.0;
		gridBagConstraints5.weighty = 1.0;
		gridBagConstraints5.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints5.gridwidth = 2;
		gridBagConstraints5.gridheight = 1;
		gridBagConstraints5.gridx = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.anchor = GridBagConstraints.WEST;
		gridBagConstraints4.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints4.gridwidth = 1;
		gridBagConstraints4.gridy = 5;
		muligeDelbehandlingerLabel = new JLabel();
		muligeDelbehandlingerLabel.setText("Mulige delbehandlinger : ");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridy = 3;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.weighty = 1.0;
		gridBagConstraints3.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints3.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints2.gridwidth = 1;
		gridBagConstraints2.gridy = 2;
		valgteDelbehandlingerLabel = new JLabel();
		valgteDelbehandlingerLabel.setText("Valgte delbehandlinger : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridwidth = 2;
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
		this.add(getVlagteDelbehandlingerList(), gridBagConstraints3);
		this.add(muligeDelbehandlingerLabel, gridBagConstraints4);
		this.add(getMuligeDelbehandlingerList(), gridBagConstraints5);
		this.add(getTilknytFravælgDelbehandlingButtonPanel(), gridBagConstraints7);
		this.add(getRækkefølgeDelbehandlingerPanel(), gridBagConstraints8);
		this.add(getBehandlingButtonPanel(), gridBagConstraints6);
	}

	/**
	 * This method initializes vælgBehandlingComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getVælgBehandlingComboBox() {
		if (vælgBehandlingComboBox == null) {
			List<Behandling> behandlinger = Service.getInstance().getBehandlinger();
			vælgBehandlingComboBox = new JComboBox(behandlinger.toArray());
			vælgBehandlingComboBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JComboBox source = (JComboBox) e.getSource();
					Behandling valgtBehandling = (Behandling) source.getSelectedItem();
					getVlagteDelbehandlingerList().setListData(valgtBehandling.getDelbehandlinger().toArray());
				}
			});
		}
		return vælgBehandlingComboBox;
	}

	/**
	 * This method initializes valgteDelbehandlingerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getVlagteDelbehandlingerList() {
		if (valgteDelbehandlingerList == null) {
			valgteDelbehandlingerList = new JList();
			valgteDelbehandlingerList.setBorder(MainFrame.getBorder());
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
			List<Delbehandling> delbehandlinger = Service.getInstance().getDelbehandlinger();
			muligeDelbehandlingerList = new JList(delbehandlinger.toArray());
			muligeDelbehandlingerList.setBorder(MainFrame.getBorder());
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
		}
		return tilknytFravælgDelbehandlingButtonPanel;
	}

	/**
	 * This method initializes rækkefølgeDelbehandlingerPanel	
	 * 	
	 * @return gui.RækkefølgeDelbehandlingerPanel	
	 */
	private RaekkefoelgeDelbehandlingerButtonPanel getRækkefølgeDelbehandlingerPanel() {
		if (rækkefølgeDelbehandlingerPanel == null) {
			rækkefølgeDelbehandlingerPanel = new RaekkefoelgeDelbehandlingerButtonPanel();
		}
		return rækkefølgeDelbehandlingerPanel;
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#gem()
	 */
	@Override
	public void gem() {
		// TODO Auto-generated method stub
		System.out.println("Gem");
		Behandling valgtBehandling = (Behandling) getVælgBehandlingComboBox().getSelectedItem();
		ListModel delbehSelModel = getVlagteDelbehandlingerList().getModel();
		for (int i = 0; i < delbehSelModel.getSize(); i++) {
			valgtBehandling.addDelbehandling((Delbehandling) delbehSelModel.getElementAt(i));
		}
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#opret()
	 */
	@Override
	public void opret() {
		// TODO Auto-generated method stub
		System.out.println("Opret");
	}

	/* (non-Javadoc)
	 * @see gui.OpretGemSletObserver#slet()
	 */
	@Override
	public void slet() {
		// TODO Auto-generated method stub
		System.out.println("Slet");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
