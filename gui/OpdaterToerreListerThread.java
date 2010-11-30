/**
 * 
 */
package gui;

import javax.swing.JList;
import javax.swing.JSlider;

import model.Service;

/**
 * Thread der står for at opdatere tørrelisterne i interfacet.
 * 
 * @author Jonas Häggqvist
 */
public class OpdaterToerreListerThread extends Thread {
	private JList klarList;
	private JList nærOverskredetList;
	private JSlider antalTimerFraMaxToerringsSlider;
	
	/**
	 * Constructor
	 */
	public OpdaterToerreListerThread() {
		super();
	}
	
	/**
	 * Opdater listerne
	 */
	public void opdaterLister() {
		int timerFraMaks = antalTimerFraMaxToerringsSlider.getValue();
		klarList.setListData(Service.getInstance().getKlar(timerFraMaks).toArray());
		nærOverskredetList.setListData(Service.getInstance().getNærOverskredet(timerFraMaks).toArray());
	}

	/**
	 * Sæt listen der skal indeholde Mellemvarer der er klar men ikke tæt på maksimum
	 * @param klarList
	 */
	public void setKlarList(JList klarList) {
		this.klarList = klarList;
	}

	/**
	 * Sæt listen der skal indeholde Mellemvarer der er tæt på maksimum
	 * @param nærOverskredetList
	 */
	public void setNærOverskredetList(JList nærOverskredetList) {
		this.nærOverskredetList = nærOverskredetList;
	}

	/**
	 * Sæt slideren der bruges til at angive hvad der anses for tæt på maksimum
	 * @param antalTimerFraMaxToerringsSlider
	 */
	public void setAntalTimerFraMaxToerringsSlider(
			JSlider antalTimerFraMaxToerringsSlider) {
		this.antalTimerFraMaxToerringsSlider = antalTimerFraMaxToerringsSlider;
	}

	/**
	 * Threadens arbejds-loop. Opdaterer listerne hvert minut.
	 */
	public void run() {
		while (true) {
			try {
				opdaterLister();
				sleep(60*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
