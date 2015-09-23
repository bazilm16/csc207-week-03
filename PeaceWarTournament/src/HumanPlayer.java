import java.util.Random;
import java.util.Scanner;


public class HumanPlayer implements Player{	
		String name = "Human Player";
		int points;
		String strategy;
		Move playerMove;
		Move oponentMove;
		int rounds;
	
		public String getName(){
			return this.name;
		}//getName
	    
		
		public String getDescription(){
	    	return getName() + " chose " + Move.toString(this.playerMove) +".";
	    }//getDescription

		
	    public void setNumRounds(int rounds){
	    	this.rounds = rounds;
	    }//setNumRounds

	    
		public void recordOpponentMove(int num, Move move) {
			this.oponentMove = move;
			this.rounds = num;
		}//recordOpponentMove

		
		public Move takeTurn(int num, Random rand) {
			Scanner in = new Scanner(System.in);
			Move move = null;
			int x = 1;
			while(x!=0){
				System.out.print("Strategy? ");
				String strategy = in.nextLine();
				strategy = strategy.toLowerCase();
				if(strategy.equals("war")){
					move = Move.WAR;
					break;
				}else if(strategy.equals("peace")){
					move = Move.PEACE;
					break;
				}
			}
			//in.close();
			this.playerMove = move;
			return move;
		}//takeTurn
		
}
