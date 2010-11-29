package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Mellemvare;
import model.Produkttype;
import model.Service;
import javax.swing.JScrollPane;

public class RegistrerNyMellemvarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel produkttypeLabel = null;
	private JComboBox produkttypeComboBox = null;
	private JLabel produkttypeInfoLabel = null;
	private JTextArea produkttypeInfoTextArea = null;
	private JButton registrerNyMellemvareButton = null;
	private HaandterMellemvarePanel haandterMellemvarePanel;
	private JScrollPane produkttypeInfoScrollPane = null;

	/**
	 * This is the default constructor
	 */
	public RegistrerNyMellemvarePanel() {
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
		gridBagConstraints11.gridy = 3;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.weighty = 1.0;
		gridBagConstraints11.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints4.gridy = 5;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.gridy = 2;
		produkttypeInfoLabel = new JLabel();
		produkttypeInfoLabel.setText("Produkt Info : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(5, 5, 1, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.gridy = 0;
		produkttypeLabel = new JLabel();
		produkttypeLabel.setText("Produkttype : ");
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		this.add(produkttypeLabel, gridBagConstraints);
		this.add(getProdukttypeComboBox(), gridBagConstraints1);
		this.add(produkttypeInfoLabel, gridBagConstraints2);
		this.add(getProdukttypeInfoScrollPane(), gridBagConstraints11);
		this.add(getRegistrerNyMellemvareButton(), gridBagConstraints4);
	}

	/**
	 * This method initializes produkttypeComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getProdukttypeComboBox() {
		if (produkttypeComboBox == null) {
			produkttypeComboBox = new JComboBox(Service.getInstance().getProdukttyper().toArray());
			produkttypeComboBox.setSelectedItem(null);
			produkttypeComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					Produkttype aktuel = (Produkttype) getProdukttypeComboBox().getSelectedItem();
					if(aktuel != null && !aktuel.getDelbehandlinger().isEmpty())
					{
						getRegistrerNyMellemvareButton().setEnabled(true);
						getProdukttypeInfoTextArea().setText("Produkttype navn: \t" + aktuel.getNavn() + "\r\n\n"
															 + "Tilknyttet behandling: \t" + aktuel.getBehandling().getNavn());
					}
					else
					{
						getProdukttypeInfoTextArea().setText("");
						getRegistrerNyMellemvareButton().setEnabled(false);
					}
				}
			});
		}
		return produkttypeComboBox;
	}
	
	public void opdaterProdukttypeComboBox() {
		getProdukttypeComboBox().removeAllItems();
		for (Produkttype p: Service.getInstance().getProdukttyper()) {
			getProdukttypeComboBox().addItem(p);
		}
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

	/**
	 * This method initializes registrerNyMellemvareButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrerNyMellemvareButton() {
		if (registrerNyMellemvareButton == null) {
			registrerNyMellemvareButton = new JButton();
			registrerNyMellemvareButton.setText("Registrer");
			registrerNyMellemvareButton.setEnabled(false);
			registrerNyMellemvareButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if(!((Produkttype) getProdukttypeComboBox().getSelectedItem()).getDelbehandlinger().isEmpty())
							{
								Mellemvare aktuelMellemvare = model.Service.getInstance().createMellemvare((Produkttype) getProdukttypeComboBox().getSelectedItem());
								try {
									Service.getInstance().startDelbehandling(aktuelMellemvare);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								try {
									Service.getInstance().startTørring(aktuelMellemvare);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(
										null,
										"Mellemvare er oprettet med batchnummer: " + aktuelMellemvare.getBatchNummer()
										+ "\n" + "Mellemvaren placeres i række " + aktuelMellemvare.getPlacering().getRække()
										+ ", på plads " + aktuelMellemvare.getPlacering().getPladsIRække(),
										"Mellemvare oprettelse",
										JOptionPane.PLAIN_MESSAGE);
								haandterMellemvarePanel.getBatchnummerTextField().setText(aktuelMellemvare.getBatchNummer()+"");
							}
						}
					});
		}
		return registrerNyMellemvareButton;
	}
	
	public void setHaandterMellemvarePanel(
			HaandterMellemvarePanel haandterMellemvarePanel) {
		this.haandterMellemvarePanel = haandterMellemvarePanel;
	}

	/**
	 * This method initializes produkttypeInfoScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getProdukttypeInfoScrollPane() {
		if (produkttypeInfoScrollPane == null) {
			produkttypeInfoScrollPane = new JScrollPane();
			produkttypeInfoScrollPane.setViewportView(getProdukttypeInfoTextArea());
		}
		return produkttypeInfoScrollPane;
	}

}
