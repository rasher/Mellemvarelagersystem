package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;

public class OpretBehandlingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel vælgBehandlingLabel = null;
	private JComboBox vælgBehandlingComboBox = null;
	private JLabel valgteDelbehandlingerLabel = null;
	private JList vlagteDelbehandlingerList = null;
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
			vælgBehandlingComboBox = new JComboBox();
		}
		return vælgBehandlingComboBox;
	}

	/**
	 * This method initializes vlagteDelbehandlingerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getVlagteDelbehandlingerList() {
		if (vlagteDelbehandlingerList == null) {
			vlagteDelbehandlingerList = new JList();
		}
		return vlagteDelbehandlingerList;
	}

	/**
	 * This method initializes muligeDelbehandlingerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getMuligeDelbehandlingerList() {
		if (muligeDelbehandlingerList == null) {
			muligeDelbehandlingerList = new JList();
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

}  //  @jve:decl-index=0:visual-constraint="10,10"
