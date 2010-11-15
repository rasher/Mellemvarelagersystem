package gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.Border;

public class LagerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel registrerNyMellemvarePanel = null;
	private JPanel håndterMellemvarePanel = null;
	private JPanel visListerPanel = null;
	private JComboBox vælgProdukttypeComboBox = null;
	private JTextArea produkttypeInfoTextArea = null;
	private JButton registrerNyMellemvareButton = null;
	private JLabel klarListeLabel = null;
	private JList klarList = null;
	private JLabel næfOverskredetListeLabel = null;
	private JList næfOverskredetList = null;
	private JTextField batchnummerTextField = null;
	private JTextArea håndterMellemvareInfoTextArea = null;
	private JButton startTørringButton = null;
	private JButton SendTilDelbehandlingButton = null;
	private JButton SendTilPakningButton = null;
	private JLabel BatchnummerLabel = null;
	private Border border = BorderFactory.createLineBorder(Color.GRAY);
	private JLabel produkttypeLabel = null;
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
		gridLayout.setHgap(2);
		this.setSize(new Dimension(800, 500));
		this.setLayout(gridLayout);
		this.add(getRegistrerNyMellemvarePanel(), new GridBagConstraints());
		this.add(gethåndterMellemvarePanel(), null);
		this.add(getVisListerPanel(), new GridBagConstraints());
	}

	/**
	 * This method initializes registrerNyMellemvarePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getRegistrerNyMellemvarePanel() {
		if (registrerNyMellemvarePanel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = -1;
			gridBagConstraints21.gridy = -1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.anchor = GridBagConstraints.WEST;
			gridBagConstraints13.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints13.ipadx = 2;
			gridBagConstraints13.ipady = 2;
			gridBagConstraints13.gridy = 0;
			produkttypeLabel = new JLabel();
			produkttypeLabel.setText("Produkttype : ");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridy = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.ipadx = 2;
			gridBagConstraints1.ipady = 2;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints.ipadx = 2;
			gridBagConstraints.ipady = 2;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.weightx = 1.0;
			registrerNyMellemvarePanel = new JPanel();
			registrerNyMellemvarePanel.setLayout(new GridBagLayout());
			registrerNyMellemvarePanel.add(getVælgProdukttypeComboBox(), gridBagConstraints);
			registrerNyMellemvarePanel.add(getProdukttypeInfoTextArea(), gridBagConstraints1);
			registrerNyMellemvarePanel.add(getRegistrerNyMellemvareButton(), gridBagConstraints2);
			registrerNyMellemvarePanel.add(produkttypeLabel, gridBagConstraints13);
		}
		return registrerNyMellemvarePanel;
	}

	/**
	 * This method initializes håndterMellemvarePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel gethåndterMellemvarePanel() {
		if (håndterMellemvarePanel == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints12.ipadx = 2;
			gridBagConstraints12.ipady = 2;
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridy = 0;
			BatchnummerLabel = new JLabel();
			BatchnummerLabel.setText("Batchnummer : ");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints11.ipadx = 2;
			gridBagConstraints11.ipady = 2;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.gridy = 5;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints10.ipadx = 2;
			gridBagConstraints10.ipady = 2;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridy = 4;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints9.ipadx = 2;
			gridBagConstraints9.ipady = 2;
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.gridy = 3;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 2;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.weighty = 1.0;
			gridBagConstraints8.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints8.ipadx = 2;
			gridBagConstraints8.ipady = 2;
			gridBagConstraints8.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints6.ipadx = 2;
			gridBagConstraints6.ipady = 2;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.weightx = 1.0;
			håndterMellemvarePanel = new JPanel();
			håndterMellemvarePanel.setLayout(new GridBagLayout());
			håndterMellemvarePanel.add(getBatchnummerTextField(), gridBagConstraints6);
			håndterMellemvarePanel.add(gethåndterMellemvareInfoTextArea(), gridBagConstraints8);
			håndterMellemvarePanel.add(getStartTørringButton(), gridBagConstraints9);
			håndterMellemvarePanel.add(getSendTilDelbehandlingButton(), gridBagConstraints10);
			håndterMellemvarePanel.add(getSendTilPakningButton(), gridBagConstraints11);
			håndterMellemvarePanel.add(BatchnummerLabel, gridBagConstraints12);
		}
		return håndterMellemvarePanel;
	}

	/**
	 * This method initializes visListerPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getVisListerPanel() {
		if (visListerPanel == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints7.ipady = 2;
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.ipadx = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 3;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints5.ipadx = 2;
			gridBagConstraints5.ipady = 2;
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(5, 5, 1, 5);
			gridBagConstraints4.ipadx = 2;
			gridBagConstraints4.ipady = 2;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridy = 2;
			næfOverskredetListeLabel = new JLabel();
			næfOverskredetListeLabel.setText("næf maksimal tørretid : ");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.insets = new Insets(1, 5, 5, 5);
			gridBagConstraints3.ipadx = 2;
			gridBagConstraints3.ipady = 2;
			gridBagConstraints3.gridx = 0;
			klarListeLabel = new JLabel();
			klarListeLabel.setText("Klar til delbehandling : ");
			visListerPanel = new JPanel();
			visListerPanel.setLayout(new GridBagLayout());
			visListerPanel.add(klarListeLabel, gridBagConstraints7);
			visListerPanel.add(getKlarList(), gridBagConstraints3);
			visListerPanel.add(næfOverskredetListeLabel, gridBagConstraints4);
			visListerPanel.add(getnæfOverskredetList(), gridBagConstraints5);
		}
		return visListerPanel;
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
	 * This method initializes produkttypeInfoTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getProdukttypeInfoTextArea() {
		if (produkttypeInfoTextArea == null) {
			produkttypeInfoTextArea = new JTextArea();
			produkttypeInfoTextArea.setBorder(border);
		}
		return produkttypeInfoTextArea;
	}

	/**
	 * This method initializes registrerNyMellemvareButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrerNyMellemvareButton() {
		if (registrerNyMellemvareButton == null) {
			registrerNyMellemvareButton = new JButton();
			registrerNyMellemvareButton.setText("Registrer");
		}
		return registrerNyMellemvareButton;
	}

	/**
	 * This method initializes klarList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getKlarList() {
		if (klarList == null) {
			klarList = new JList();
			klarList.setBorder(border);
		}
		return klarList;
	}

	/**
	 * This method initializes næfOverskredetList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getnæfOverskredetList() {
		if (næfOverskredetList == null) {
			næfOverskredetList = new JList();
			næfOverskredetList.setBorder(border);
		}
		return næfOverskredetList;
	}

	/**
	 * This method initializes batchnummerTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBatchnummerTextField() {
		if (batchnummerTextField == null) {
			batchnummerTextField = new JTextField();
		}
		return batchnummerTextField;
	}

	/**
	 * This method initializes håndterMellemvareInfoTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea gethåndterMellemvareInfoTextArea() {
		if (håndterMellemvareInfoTextArea == null) {
			håndterMellemvareInfoTextArea = new JTextArea();
			håndterMellemvareInfoTextArea.setBorder(border);
		}
		return håndterMellemvareInfoTextArea;
	}

	/**
	 * This method initializes startTørringButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getStartTørringButton() {
		if (startTørringButton == null) {
			startTørringButton = new JButton();
			startTørringButton.setText("Start Tørring");
		}
		return startTørringButton;
	}

	/**
	 * This method initializes SendTilDelbehandlingButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSendTilDelbehandlingButton() {
		if (SendTilDelbehandlingButton == null) {
			SendTilDelbehandlingButton = new JButton();
			SendTilDelbehandlingButton.setText("Send Til Delbehandling");
		}
		return SendTilDelbehandlingButton;
	}

	/**
	 * This method initializes SendTilPakningButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSendTilPakningButton() {
		if (SendTilPakningButton == null) {
			SendTilPakningButton = new JButton();
			SendTilPakningButton.setText("Send Til Pakning");
		}
		return SendTilPakningButton;
	}


}
