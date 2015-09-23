import java.util.Random;


public class OptimusPrime implements Player{
		String name = "Optimus Prime";
		int points;
		Move playerMove;
		Move opponentMove;
		int rounds;
		int opponentRounds;
		int [] warMoves;
		int [] peaceMoves;
	
	
		public OptimusPrime(){
			this.rounds = 0;
		}
	
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
	    	
	    	//run this on Optimus's first move
	    	if(this.rounds == 0){
	    		if(rand.nextInt(2) + 1 == 1){
		    		this.playerMove = Move.WAR;
		    		return Move.WAR;
		    	}else{
		    		this.playerMove = Move.PEACE;
		    		return Move.PEACE;
		    	}
	    	}
	    	else{ 
	    		//this is run after first move by Optimus
		    	if(this.playerMove == Move.PEACE){
		    		this.playerMove = Move.WAR;
		    		return Move.WAR;
		    	}else{
		    		this.playerMove = Move.PEACE;
		    		return Move.PEACE;
		    	}
	    	}
	    	
	    }//takeTurn
	    

		public void recordOpponentMove(int num, Move move) {
			this.opponentMove = move;
			this.opponentRounds = num;
		}//recordOpponentMove
}
