package com.problemset4;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create an array of players playing for the team
		Player L_players[] = {new Player(Problem1Constant.KIRAT_BOLI,Problem1Constant.BOLI,false),
							  new Player(Problem1Constant.NS_NODHI,Problem1Constant.NODHI,false),
							  new Player(Problem1Constant.R_RUMRAH,Problem1Constant.RUMRAH,true),
							  new Player(Problem1Constant.SHASHI_HENRA,Problem1Constant.HENRA,true)};
		
		//Create a team with name, players and firstBat Flag set to false
		Team Lengaburu = new Team(Problem1Constant.LENGABURU,L_players,false);
		Lengaburu.setTarget(40); // Set the target
		
		Commentary cm = new Commentary(); //Create a commentary class
		
		Innings secondInnings = new Innings(Lengaburu,new Overs(4),cm); //Initialize the innings
		secondInnings.runInnings(); // Start the innings
		
		//Display the match result
		new Result().matchResult(Lengaburu,cm); 		
		
	}

}
