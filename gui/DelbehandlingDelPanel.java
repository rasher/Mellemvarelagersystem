package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Delbehandling;

public class DelbehandlingDelPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel vælgDelbehandlingLabel = null;
	private JComboBox vælgDelbehandlingComboBox = null;
	private JLabel tørretiderLabel = null;
	private JLabel delbehandlingsStedLabel = null;
	private JTextField delbehandlingsStedTextField = null;
	private ToerretidsPanel tørretidsPanel = null;
	private JTextField delbehandlingNavn = null;
	private JLabel delbehandlingsNavnlbl = null;
	private Delbehandling aktuelDelbehandling;
	/**
	 * This is the default constructor
	 */
	public DelbehandlingDelPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.gridx = 0;
		gridBagConstraints21.anchor = GridBagConstraints.WEST;
		gridBagConstraints21.insets = new Insets(0, 5, 1, 0);
		gridBagConstraints21.gridy = 2;
		delbehandlingsNavnlbl = new JLabel();
		delbehandlingsNavnlbl.setText("Delbehandlingsnavn:");
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.gridy = 3;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints5.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints5.gridy = 5;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		gridBagConstraints4.gridy = 7;
		gridBagConstraints4.weightx = 1.0;
		gridBagConstraints4.insets = new Insets(0, 5, 5, 5);
		gridBagConstraints4.gridx = 0;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints3.anchor = GridBagConstraints.WEST;
		gridBagConstraints3.gridy = 6;
		delbehandlingsStedLabel = new JLabel();
		delbehandlingsStedLabel.setText("Sted : ");
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(0, 5, 1, 0);
		gridBagConstraints2.gridwidth = 1;
		gridBagConstraints2.gridy = 4;
		tørretiderLabel = new JLabel();
		tørretiderLabel.setText("Tørretider : ");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.gridwidth = 1;
		gridBagConstraints1.insets = new Insets(0, 5, 5, 5);
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.insets = new Insets(5, 5, 1, 0);
		gridBagConstraints.gridy = 0;
		vælgDelbehandlingLabel = new JLabel();
		vælgDelbehandlingLabel.setText("Delbehandling : ");
		this.setSize(224, 224);
		this.setLayout(new GridBagLayout());
		this.add(vælgDelbehandlingLabel, gridBagConstraints);
		this.add(getVælgDelbehandlingComboBox(), gridBagConstraints1);
		this.add(tørretiderLabel, gridBagConstraints2);
		this.add(delbehandlingsStedLabel, gridBagConstraints3);
		this.add(getDelbehandlingsStedTextField(), gridBagConstraints4);
		this.add(getTørretidsPanel(), gridBagConstraints5);
		this.add(getDelbehandlingNavn(), gridBagConstraints11);
		this.add(delbehandlingsNavnlbl, gridBagConstraints21);

	}

	/**
	 * This method initializes vælgDelbehandlingComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getVælgDelbehandlingComboBox() {
		if (vælgDelbehandlingComboBox == null) {
			vælgDelbehandlingComboBox = new JComboBox();
			vælgDelbehandlingComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					aktuelDelbehandling = (Delbehandling) vælgDelbehandlingComboBox.getSelectedItem();
					if(aktuelDelbehandling != null)
					{
						getDelbehandlingNavn().setText(aktuelDelbehandling.getNavn());
						setMaksTørringstid(aktuelDelbehandling.getMaksimumTørringsTid() + "");
						setMinTørringstid(aktuelDelbehandling.getMinimumTørringsTid()+ "");
						setOptTørringstid(aktuelDelbehandling.getOptimalTørringsTid() + "");
						getDelbehandlingsStedTextField().setText(aktuelDelbehandling.getBehandlingsSted());
					}
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return vælgDelbehandlingComboBox;
	}

	/**
	 * This method initializes delbehandlingsStedTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDelbehandlingsStedTextField() {
		if (delbehandlingsStedTextField == null) {
			delbehandlingsStedTextField = new JTextField();
		}
		return delbehandlingsStedTextField;
	}

	/**
	 * This method initializes tørretidsPanel	
	 * 	
	 * @return gui.TørretidsPanel	
	 */
	private ToerretidsPanel getTørretidsPanel() {
		if (tørretidsPanel == null) {
			tørretidsPanel = new ToerretidsPanel();
		}
		return tørretidsPanel;
	}

	/**
	 * This method initializes delbehandlingNavn	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDelbehandlingNavn() {
		if (delbehandlingNavn == null) {
			delbehandlingNavn = new JTextField();
		}
		return delbehandlingNavn;
	}
	
	public String getBehandlingSted()
	{
		return getDelbehandlingsStedTextField().getText();
	}
	
	public void setBehandlingSted(String sted)
	{
		getDelbehandlingsStedTextField().setText(sted);
	}
	
	public String getDelbehandlingsNavn()
	{
		return getDelbehandlingNavn().getText();
	}
	
	public void setDelbehandlingsNavn(String navn)
	{
		getDelbehandlingNavn().setText(navn);
	}
	
	public Delbehandling getAktuelDebehandling()
	{
		return aktuelDelbehandling;
	}
	
	public String getMinTørringstid()
	{
		return getTørretidsPanel().getMinTørretid();
	}
	public String getOptTørringstid()
	{
		return getTørretidsPanel().getOptTørretid();
	}
	public String getMaksTørringstid()
	{
		return getTørretidsPanel().getMaksTørretid();
	}
	public void setMinTørringstid(String min)
	{
		getTørretidsPanel().setMinTørretid(min);
	}
	public void setMaksTørringstid(String maks)
	{
		getTørretidsPanel().setMaksTørretid(maks);
	}
	public void setOptTørringstid(String opt)
	{
		getTørretidsPanel().setOptTørretid(opt);
	}
	
	public void opdaterPanel(List<Delbehandling> delbehandlinger)
	{
		getVælgDelbehandlingComboBox().removeAllItems();
		for(Delbehandling d : delbehandlinger)
		{
			getVælgDelbehandlingComboBox().addItem(d);
		}
		setDelbehandlingsNavn("");
		setBehandlingSted("");
		setMaksTørringstid("");
		setMinTørringstid("");
		setOptTørringstid("");
	}

}  //  @jve:decl-index=0:visual-constraint="20,21"
