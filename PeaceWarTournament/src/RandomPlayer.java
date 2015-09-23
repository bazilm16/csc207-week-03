import java.util.Random;

public class RandomPlayer implements Player{
		String name = "AI";
		int points;
		Move playerMove;
		Move opponentMove;
		int rounds;
		int opponentRounds;
	
		 public String getName(){
			 return this.name;
		 }//getName

	    public String getDescription(){
	    	return getName()+ " chose " + Move.toString(this.playerMove) +".";
	    }//getDescription

	    
	    public void setNumRounds(int rounds){
	    	this.rounds = rounds;
	    }//setNumRounds

	    
	    public Move takeTurn(int num, Random rand){
	    	setNumRounds(num);
	    	if(rand.nextInt(2) + 1 == 1){
	    		this.playerMove = Move.WAR;
	    		return Move.WAR;
	    	}else{
	    		this.playerMove = Move.PEACE;
	    		return Move.PEACE;
	    	}
	    }//takeTurn

	    
		public void recordOpponentMove(int num, Move move) {
			this.opponentMove = move;
			this.opponentRounds = num;
		}//recordOpponentMove
}
