/**
 * 
 */
package gui;

/**
 * @author Jonas Häggqvist
 */
public interface OpretGemSletObserver {
	/**
	 * Kaldt når brugeren trykker på opret
	 */
	public void opret();
	/**
	 * Kaldt når brugeren trykker på gem
	 */
	public void gem();
	/**
	 * Kaldt når brugeren trykker på slet
	 */
	public void slet();
}
