package gui;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;

import model.Delbehandling;
import model.Service;

public class OpretDelbehandlingPanel extends JPanel implements OpretGemSletObserver {

	private static final long serialVersionUID = 1L;
	private ButtonPanel buttonPanel1 = null;
	private DelbehandlingDelPanel delbehandlingDelPanel = null;
	private Service service = Service.getInstance();
	private Delbehandling nyDelbehandling;
	/**
	 * This is the default constructor
	 */
	public OpretDelbehandlingPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setBounds(new Rectangle(0, 0, 211, 207));
		this.add(getDelbehandlingDelPanel(), BorderLayout.NORTH);
		this.add(getButtonPanel1(), BorderLayout.SOUTH);
		getButtonPanel1().registerOpretGemSletObserver(this);
		getDelbehandlingDelPanel().opdaterPanel(service.getDelbehandlinger());
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
	 * This method initializes delbehandlingDelPanel	
	 * 	
	 * @return gui.DelbehandlingDelPanel	
	 */
	private DelbehandlingDelPanel getDelbehandlingDelPanel() {
		if (delbehandlingDelPanel == null) {
			delbehandlingDelPanel = new DelbehandlingDelPanel();
		}
		return delbehandlingDelPanel;
	}

	@Override
	public void opret() {
		if(!getDelbehandlingDelPanel().getDelbehandlingsNavn().isEmpty() && 
				!getDelbehandlingDelPanel().getBehandlingSted().isEmpty() && 
				!getDelbehandlingDelPanel().getMaksTørringstid().isEmpty() &&
				!getDelbehandlingDelPanel().getMinTørringstid().isEmpty() &&
				!getDelbehandlingDelPanel().getOptTørringstid().isEmpty())
		{

			nyDelbehandling = service.createDelbehandling();
			nyDelbehandling.setNavn(getDelbehandlingDelPanel().getDelbehandlingsNavn());
			nyDelbehandling.setBehandlingsSted(getDelbehandlingDelPanel().getBehandlingSted());
			nyDelbehandling.setMaksimumTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getMaksTørringstid()));
			nyDelbehandling.setMinimumTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getMinTørringstid()));
			nyDelbehandling.setOptimalTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getOptTørringstid()));
			service.gemIDatabase(nyDelbehandling);
			getDelbehandlingDelPanel().opdaterPanel(service.getDelbehandlinger());
		}

	}

	@Override
	public void gem() {
		if(!getDelbehandlingDelPanel().getDelbehandlingsNavn().isEmpty() && 
				!getDelbehandlingDelPanel().getBehandlingSted().isEmpty() && 
				!getDelbehandlingDelPanel().getMaksTørringstid().isEmpty() &&
				!getDelbehandlingDelPanel().getMinTørringstid().isEmpty() &&
				!getDelbehandlingDelPanel().getOptTørringstid().isEmpty() &&
				getDelbehandlingDelPanel().getAktuelDebehandling() != null)
		{
			getDelbehandlingDelPanel().getAktuelDebehandling().
			setNavn(getDelbehandlingDelPanel().getDelbehandlingsNavn());
			getDelbehandlingDelPanel().getAktuelDebehandling().
			setBehandlingsSted(getDelbehandlingDelPanel().getBehandlingSted());
			getDelbehandlingDelPanel().getAktuelDebehandling().
			setMaksimumTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getMaksTørringstid()));
			getDelbehandlingDelPanel().getAktuelDebehandling().
			setMinimumTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getMinTørringstid()));
			getDelbehandlingDelPanel().getAktuelDebehandling().
			setOptimalTørringsTid(Integer.parseInt(getDelbehandlingDelPanel().
					getOptTørringstid()));
			service.gemIDatabase(getDelbehandlingDelPanel().getAktuelDebehandling());
			getDelbehandlingDelPanel().opdaterPanel(service.getDelbehandlinger());
		}

	}

	@Override
	public void slet() {
		if(getDelbehandlingDelPanel().getAktuelDebehandling() != null)
			service.fjernFraDatabase(getDelbehandlingDelPanel().getAktuelDebehandling());
			getDelbehandlingDelPanel().opdaterPanel(service.getDelbehandlinger());
	}


}  //  @jve:decl-index=0:visual-constraint="36,37"
