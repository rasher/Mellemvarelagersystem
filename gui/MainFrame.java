package gui;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar CarlettiMenuBar = null;
	private JMenu LagerMenu = null;
	private JMenu AdministrationMenu = null;
	private JMenuItem DagligLagerHåndteringMenuItem = null;
	private JMenuItem OpretNyeProdukterMenuItem = null;
	private JMenuItem StatistikMenuItem = null;
	private LagerPanel lagerPanel = null;  //  @jve:decl-index=0:visual-constraint="342,13"//  @jve:decl-index=0:
	private AdministrationPanel administrationPanel = null;  //  @jve:decl-index=0:visual-constraint="339,226"
	private OpdaterToerreListerThread opdaterTørreListerThread;
	
	/**
	 * This method initializes CarlettiMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getCarlettiMenuBar() {
		if (CarlettiMenuBar == null) {
			CarlettiMenuBar = new JMenuBar();
			CarlettiMenuBar.add(getLagerMenu());
			CarlettiMenuBar.add(getAdministrationMenu());
		}
		return CarlettiMenuBar;
	}

	/**
	 * This method initializes LagerMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getLagerMenu() {
		if (LagerMenu == null) {
			LagerMenu = new JMenu();
			LagerMenu.setText("Lager");
			LagerMenu.add(getDagligLagerHåndteringMenuItem());
		}
		return LagerMenu;
	}

	/**
	 * This method initializes AdministrationMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAdministrationMenu() {
		if (AdministrationMenu == null) {
			AdministrationMenu = new JMenu();
			AdministrationMenu.setText("Administration");
			AdministrationMenu.add(getOpretNyeProdukterMenuItem());
			AdministrationMenu.add(getStatistikMenuItem());
		}
		return AdministrationMenu;
	}

	/**
	 * This method initializes DagligLagerHåndteringMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDagligLagerHåndteringMenuItem() {
		if (DagligLagerHåndteringMenuItem == null) {
			DagligLagerHåndteringMenuItem = new JMenuItem();
			DagligLagerHåndteringMenuItem.setText("Daglig Lager Håndtering");
			DagligLagerHåndteringMenuItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
//							getContentPane().setSize(getLagerPanel().getPreferredSize());
						setContentPane(getLagerPanel());
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return DagligLagerHåndteringMenuItem;
	}

	/**
	 * This method initializes OpretNyeProdukterMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getOpretNyeProdukterMenuItem() {
		if (OpretNyeProdukterMenuItem == null) {
			OpretNyeProdukterMenuItem = new JMenuItem();
			OpretNyeProdukterMenuItem.setText("Opret Nye Produkter");
			OpretNyeProdukterMenuItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							MainFrame.this.setSize(getAdministrationPanel().getSize());
							setContentPane(getAdministrationPanel());
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return OpretNyeProdukterMenuItem;
	}

	/**
	 * This method initializes StatistikMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getStatistikMenuItem() {
		if (StatistikMenuItem == null) {
			StatistikMenuItem = new JMenuItem();
			StatistikMenuItem.setText("Statistik");
		}
		return StatistikMenuItem;
	}

	/**
	 * This method initializes lagerPanel	
	 * 	
	 * @return gui.LagerPanel	
	 */
	private LagerPanel getLagerPanel() {
		if (lagerPanel == null) {
			lagerPanel = new LagerPanel();
		}
		return lagerPanel;
	}

	/**
	 * This method initializes administrationPanel	
	 * 	
	 * @return gui.AdministrationPanel	
	 */
	private AdministrationPanel getAdministrationPanel() {
		if (administrationPanel == null) {
			administrationPanel = new AdministrationPanel();
		}
		return administrationPanel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 500);
		this.setJMenuBar(getCarlettiMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		VisListPanel visListPanel = getLagerPanel().getVisListPanel();
		opdaterTørreListerThread = new OpdaterToerreListerThread(
				visListPanel.getKlarList(),
				visListPanel.getNærOverskredetList(),
				visListPanel.getAntalTimerFraMaxToerringsSlider());
		opdaterTørreListerThread.start();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}
	
	public static Border getBorder(){
		return BorderFactory.createLineBorder(Color.GRAY);
	}

}
