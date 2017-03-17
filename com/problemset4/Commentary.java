package com.problemset4;

public class Commentary {
	//A String Builder to store commentary of each innings 
	private StringBuilder sb = new StringBuilder();
	
	public void addCommentary(String msg){
		sb.append(msg);
	}
	
	public void runCommentary(){
		System.out.println(sb.toString());
	}
	
	//Below are the commentary sections for different outcomes as well as different situations
	
	public void batsmanOut(int over,int ball,String name){
		this.addCommentary(over+"."+ball+" "+name+" is out\n");
	}
	
	public void runScored(int over,int ball,String name,int run){
		if(run == 1){
			this.addCommentary(over+"."+ball+" "+name+" scored "+run+" run\n");
		}else{
			this.addCommentary(over+"."+ball+" "+name+" scored "+run+" runs\n");
		}
	}
	
	public void overStart(int num, int i, Team team){
		if(num > 1){
			this.addCommentary("\n"+(num - i)+" overs left. "+team.getTotalRuns()+" to win\n\n");
		}else{
			this.addCommentary(team.getName()+" innings:\n");
		}
	}
	
	public void teamWin(Team team){
		String w = "wickets";
		String ball = "balls";
		if((team.getTotalBalls()-1) == 1){
			ball = "ball";
		}
		if((team.getPlayers().length-team.getWickets()-1) == 1){
			w = "wicket";
		}
		this.addCommentary(team.getName()+" won by "+(team.getPlayers().length-team.getWickets()-1)+" "+w+" with "+(team.getTotalBalls()-1)+" "+ball+" left.\n\n");
	}
	
	public void teamWin(Team team1, Team team2){
		String runs = "runs";
		if((team1.getTotalRuns()-1) == 1){
			runs = "run";
		}
		this.addCommentary(team1.getName()+" won by "+(team2.getTotalRuns()-1)+" "+runs+"\n\n");
	
	}
	
	public void teamLose(Team team){
		String runs = "runs";
		if((team.getTotalRuns()-1) == 1){
			runs = "run";
		}
		this.addCommentary(team.getName()+" lost by "+(team.getTotalRuns()-1)+" "+runs+"\n\n");
	}
	
	
	//Print each player scorecard
	public void printSummary(Team team){
		for(Player player : team.getPlayers()){
			if(player.isOut() == true){
				this.addCommentary(player.getName()+" : "+player.getRuns()+" ("+player.getBalls()+" Balls)\n");
			}else if(player.isY2B() == true){
				this.addCommentary(player.getName()+" : DNB\n");
			}else{
				this.addCommentary(player.getName()+" : "+player.getRuns()+"* ("+player.getBalls()+" Balls)\n");
			}
			
		}
		this.addCommentary("\n");
	}
}
