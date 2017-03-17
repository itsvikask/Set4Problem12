package com.problemset4;

public class Overs {
	private int noOvers;
	public static final int BALLS_PER_OVER=6;
	
	Overs(int noOvers){
		this.noOvers = noOvers;
	}

	public int getNoOvers() {
		return noOvers;
	}
	
	public void startOver(Team team, Commentary commentary, int o){
		//Start an over
		for(int j=1 ; j<= Overs.BALLS_PER_OVER ;j++){

			Player currentBatsman = team.getStriker(); // Get current Batsman

			int run = bowlDelivery(currentBatsman.getProbability());   //Find out the result of each ball bowled

			currentBatsman.facedDelivery();

			if(run == -1){ //If out
				commentary.batsmanOut(o,j,currentBatsman.getName());
				currentBatsman.gotOut();
				team.nextBatsman();
			}else{
				currentBatsman.hitRuns(run);
				commentary.runScored(o,j,currentBatsman.getName(),run);

				//If odd runs, change strike
				if((run % 2) == 1){
					team.rotateStrike();
				}
				team.updateTeamScore(run);
			}

			//Check if match over by any team winning
			if(new Result().isMatchOver(team,commentary)){
				break;
			}

			//Change strike on end of an over
			if(j == Overs.BALLS_PER_OVER){
				team.rotateStrike();
			}

			team.ballsRemaining();
		}
	}
	
	//Returns output of each ball bowled. Can be out(-1) or zero or more runs
	public int bowlDelivery(int prob[]){
		
		//Generate a random number between 0-100
		int randomNo = (int)(Math.random()*100);
		int sum = 0;
		int run = -1;
		
		for (int i = 0; i < prob.length - 1; i++) {
			sum += prob[i];
			if (randomNo <= sum) {
				run = i;
				break;
			}
		}
		
		return run;
		
	}
}
