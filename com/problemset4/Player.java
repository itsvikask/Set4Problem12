package com.problemset4;

// Player class with each player details
public class Player {
	private String name;  //Name of the player
	private int runs,balls;  //No of runs and balls he faced
	private boolean out,Y2B; //Whether out or Yet to Bat flag
	private int probability[]; //His runs probability
	
	Player(String name,int probability[], boolean Y2B){
		this.name = name;
		this.probability = probability;
		this.runs=0;
		this.balls=0;
		this.out=false;
		this.Y2B=Y2B;
	}

	public int getRuns() {
		return runs;
	}

	public String getName() {
		return name;
	}

	public int[] getProbability() {
		return probability;
	}

	public int getBalls() {
		return balls;
	}

	public boolean isOut() {
		return out;
	}

	public boolean isY2B() {
		return Y2B;
	}

	public void cameToCrease() {
		this.Y2B = false;
	}
	
	public void hitRuns(int run){
		this.runs+=run;
	}
	
	public void facedDelivery(){
		this.balls++;
	}
	
	public void gotOut(){
		this.out = true;
	}
}
