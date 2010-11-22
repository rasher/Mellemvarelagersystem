/**
 * 
 */
package gui;

import javax.swing.JList;
import javax.swing.JSlider;

import model.Service;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
 */
public class OpdaterToerreListerThread extends Thread {
	private JList klarList;
	private JList nærOverskredetList;
	private JSlider antalTimerFraMaxToerringsSlider;
	
	public OpdaterToerreListerThread() {
		super();
	}
	
	public void opdaterLister() {
		int timerFraMaks = antalTimerFraMaxToerringsSlider.getValue();
		klarList.setListData(Service.getInstance().getKlar(timerFraMaks).toArray());
		nærOverskredetList.setListData(Service.getInstance().getNærOverskredet(timerFraMaks).toArray());
	}

	public void setKlarList(JList klarList) {
		this.klarList = klarList;
	}

	public void setNærOverskredetList(JList nærOverskredetList) {
		this.nærOverskredetList = nærOverskredetList;
	}

	public void setAntalTimerFraMaxToerringsSlider(
			JSlider antalTimerFraMaxToerringsSlider) {
		this.antalTimerFraMaxToerringsSlider = antalTimerFraMaxToerringsSlider;
	}

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
