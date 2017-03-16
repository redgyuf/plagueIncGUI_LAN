import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533282343180718819L;
	
	private int lethality;
	private short incubation;
	private double victims;
	private int playerID;
	private String playerName;
	private String cardName;
	
	public int getLethality() {
		return lethality;
	}
	public void setLethality(int lethality) {
		this.lethality = lethality;
	}
	public short getIncubation() {
		return incubation;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setIncubation(short incubation) {
		this.incubation = incubation;
	}
	public double getVictims() {
		return victims;
	}
	public void setVictims(double victims) {
		this.victims = victims;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public String toString() {
		return "Message [lethality=" + lethality + ", incubation=" + incubation + ", victims=" + victims + ", cardName="
				+ cardName + "]";
	}
	
	
	
}
