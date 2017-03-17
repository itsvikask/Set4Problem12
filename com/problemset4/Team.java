package com.problemset4;

//a Team class consisting of a set of players and other details
//Total runs and balls are added from ZERO for first innings and negated from target to ZERO during second innings
public class Team {
	private Player players[];  //Array of players for a team
	private int wickets,totalRuns,totalBalls,striker,nStriker,nextBat;
	private boolean win,firstBat;
	private String name;  //Name of the team
	
	Team(String name,Player players[], boolean firstBat){
		this.name = name;
		this.players = players;
		this.wickets = 0;
		this.totalRuns = 0;
		this.totalBalls = 0;
		this.striker = 0;
		this.nStriker = 1;
		this.nextBat = 2;
		this.win = false;
		this.firstBat = firstBat;
	}
	
	public int getWickets() {
		return wickets;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public int getTotalBalls() {
		return totalBalls;
	}

	public boolean isWin() {
		return win;
	}

	public String getName() {
		return name;
	}

	public void setTarget(int runs){
		this.totalRuns = runs;
	}

	public void setTotalBalls(int totalBalls) {
		this.totalBalls = totalBalls;
	}

	public Player getStriker(){
		return this.players[this.striker];
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}

	public Player[] getPlayers() {
		return players;
	}

	public boolean isFirstBat() {
		return firstBat;
	}

	public void nextBatsman(){
		this.striker = this.nextBat;
		this.nextBat++;
		this.wickets++;
		
		if(this.striker < this.players.length ){
			this.getStriker().cameToCrease();
		}
	}

	public void rotateStrike(){
		int temp=this.striker;
		this.striker = this.nStriker;
		this.nStriker = temp;
	}
	
	public boolean isInningsOver(){
		//If win or all out, no need to bowl further overs
		if((!this.firstBat && this.totalRuns <= 0)|| this.wickets == (this.players.length - 1)){
			return true;
		}
		return false;
	}
	
	public void isInningsEnd(){
		if(!this.firstBat && this.totalBalls == 0 && this.totalRuns > 0){
			this.win = false;
		}
	}
	
	public void updateTeamScore(int runs){
		//If Batting first add runs, if second negate runs to reach target
		if(this.firstBat){
			this.totalRuns+=runs;
		}else{
			this.totalRuns-=runs;
		}
	}
	
	public void ballsRemaining(){
		this.totalBalls--;
	}
}
