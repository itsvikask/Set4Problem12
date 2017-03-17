package com.problemset4;

public class Problem2 {
	public static void main(String[] args) {
		
		//Create an array of players playing for the team1
		Player L_players[] = {new Player(Problem2Constant.KIRAT_BOLI,Problem2Constant.BOLI,false),
	  			  new Player(Problem2Constant.NS_NODHI,Problem2Constant.NODHI,false)};
		
		//Create a team with name, players and firstBat Flag set to true since Lengaburu is batting first by default
		Team Lengaburu = new Team(Problem2Constant.LENGABURU,L_players,true);
		
		//Setup commentary, innings and start first innings
		Commentary firstInningsCom = new Commentary();
		Innings firstInnings = new Innings(Lengaburu, new Overs(1), firstInningsCom);
		firstInnings.runInnings();
		
		
		//Create an array of players playing for the team2
		Player E_players[] = {new Player(Problem2Constant.DB_VELLYERS,Problem2Constant.VELLYERS,false),
				  			  new Player(Problem2Constant.H_MAMLA,Problem2Constant.MAMLA,false)};
		
		//Create a team with name, players and firstBat Flag set to false
		Team Enchai = new Team(Problem2Constant.ENCHAI,E_players,false);
		
		//Set the target Enchai should achieve
		Enchai.setTarget(Lengaburu.getTotalRuns()+1);
		
		//Setup commentary, innings and start first innings
		Commentary secondInningsCom = new Commentary();
		Innings secondInnings = new Innings(Enchai, new Overs(1), secondInningsCom);
		secondInnings.runInnings();
		
		//Display the result of the match
		new Result().matchResult(Lengaburu, Enchai,firstInningsCom,secondInningsCom);
		
	}
}
