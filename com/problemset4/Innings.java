package com.problemset4;

//Run Innings for a team for specific set of overs

public class Innings {
	private Overs overs;
	private Team team;
	private Commentary commentary;

	Innings(Team team,Overs overs,Commentary commentary){
		this.team = team;
		this.overs = overs;
		this.team.setTotalBalls(overs.getNoOvers()*Overs.BALLS_PER_OVER);
		this.commentary = commentary;
	}

	public void runInnings(){

		//Start the innings
		for(int i=0;i < overs.getNoOvers(); i++){
			
			commentary.overStart(overs.getNoOvers(),i,team);
			
			//Bowl an over
			overs.startOver(team,commentary,i);
			
			commentary.addCommentary("\n");
			
			//If win or all out, no need to bowl further overs
			if(team.isInningsOver()){
				break;
			}

			//Check If full quota of overs bowled and target not reached, chasing team lost
			team.isInningsEnd();

		}
	}

}
