package com.problemset4;

//Class to find & print result of a match
public class Result {
	
	//Method to find winner for Problem 1. Find's out whether Lengaburu reached target
	public void matchResult(Team team, Commentary inningsCom){
		Commentary matchSummary = new Commentary();
		if(team.getTotalRuns() == 1){
			matchSummary.addCommentary("Scores Level! Match ended in a Tie!\n");
		}else{
			if(team.isWin()){
				matchSummary.teamWin(team);
			}else{
				matchSummary.teamLose(team);
			}
		}
		matchSummary.printSummary(team);
		matchSummary.runCommentary();
		System.out.println("Sample Commentary:");
		inningsCom.runCommentary();
	}
	
	//Method to find for winner for Problem 2. Result is decided upon the win flag set to the team batting second. Enchai in this case.
	public void matchResult(Team team1, Team team2, Commentary firstInnings, Commentary secondInnings){
		Commentary matchSummary = new Commentary();
		if(team2.getTotalRuns() == 1){
			matchSummary.addCommentary("Scores Level in the Tie Breaker too!\n");
		}else{
			if(team2.isWin()){
				matchSummary.teamWin(team2);
			}else{
				matchSummary.teamWin(team1,team2);
			}
		}
		matchSummary.addCommentary(team1.getName()+"\n");
		matchSummary.printSummary(team1);
		matchSummary.addCommentary(team2.getName()+"\n");
		matchSummary.printSummary(team2);
		matchSummary.runCommentary();
		
		System.out.println("Sample Commentary:");
		firstInnings.runCommentary();
		secondInnings.runCommentary();
	}
	
	//Check the result whether the match is over
	public boolean isMatchOver(Team team,Commentary commentary){
		//If second bat and target reached, match over
		if(!team.isFirstBat() && team.getTotalRuns() <= 0){
			team.setWin(true);
			commentary.addCommentary(team.getName()+" WINS!");
			return true;
		}

		//If all players out, team all out.
		//Win is to set to false by default sin)ce team winning is decided upon the result of second innings batting
		if(team.getWickets() == (team.getPlayers().length - 1)){
			team.setWin(false);
			commentary.addCommentary(team.getName()+" ALL OUT!");
			return true;
		}

		return false;
	}
	
}
