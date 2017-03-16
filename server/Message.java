package server;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533282343180718819L;

	private int lethality1;
	private short incubation1;
	private double victims1;
	private String cardName1;

	private int lethality2;
	private short incubation2;
	private double victims2;
	private String cardName2;

	private String choosedStat;

	private int playerID;
	private String playerName1;
	private String playerName2;
	
	private boolean isYourTurn;
	
	public boolean isYourTurn() {
		return isYourTurn;
	}
	public void setYourTurn(boolean isYourTurn) {
		this.isYourTurn = isYourTurn;
	}
	public int getLethality1() {
		return lethality1;
	}
	public void setLethality1(int lethality1) {
		this.lethality1 = lethality1;
	}
	public short getIncubation1() {
		return incubation1;
	}
	public void setIncubation1(short incubation1) {
		this.incubation1 = incubation1;
	}
	public double getVictims1() {
		return victims1;
	}
	public void setVictims1(double victims1) {
		this.victims1 = victims1;
	}
	public String getCardName1() {
		return cardName1;
	}
	public void setCardName1(String cardName1) {
		this.cardName1 = cardName1;
	}
	public int getLethality2() {
		return lethality2;
	}
	public void setLethality2(int lethality2) {
		this.lethality2 = lethality2;
	}
	public short getIncubation2() {
		return incubation2;
	}
	public void setIncubation2(short incubation2) {
		this.incubation2 = incubation2;
	}
	public double getVictims2() {
		return victims2;
	}
	public void setVictims2(double victims2) {
		this.victims2 = victims2;
	}
	public String getCardName2() {
		return cardName2;
	}
	public void setCardName2(String cardName2) {
		this.cardName2 = cardName2;
	}
	public String getChoosedStat() {
		return choosedStat;
	}
	public void setChoosedStat(String choosedStat) {
		this.choosedStat = choosedStat;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName1() {
		return playerName1;
	}
	public void setPlayerName1(String playerName1) {
		this.playerName1 = playerName1;
	}
	public String getPlayerName2() {
		return playerName2;
	}
	public void setPlayerName2(String playerName2) {
		this.playerName2 = playerName2;
	}
	@Override
	public String toString() {
		return "Message [lethality1=" + lethality1 + ", incubation1=" + incubation1 + ", victims1=" + victims1
				+ ", cardName1=" + cardName1 + ", lethality2=" + lethality2 + ", incubation2=" + incubation2
				+ ", victims2=" + victims2 + ", cardName2=" + cardName2 + ", choosedStat=" + choosedStat + ", playerID="
				+ playerID + ", playerName1=" + playerName1 + ", playerName2=" + playerName2 + "]";
	}
	
	
}
