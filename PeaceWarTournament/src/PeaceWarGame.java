import java.util.Random;

public class PeaceWarGame{
	Player player1;
	Player player2;
	int rounds;
	int player1Points;
	int player2Points;
	
	public PeaceWarGame(Player player1, Player player2, int numRounds){
			this.player1 = player1;
			this.player2 = player2;
			this.rounds = numRounds;
			this.player1Points = 0;
			this.player2Points = 0;
	}//PeaceWarGame
	
	public void play(){
		Random rand = new Random();
		Move m1,m2;
		for(int y=1; y<=this.rounds; y++){
			System.out.println("Year " + y);
			if(rand.nextInt(2) + 1 == 1){
				m1 = this.player1.takeTurn(this.rounds, rand);
				m2 = this.player2.takeTurn(this.rounds, rand);
				System.out.println(player1.getDescription());
				System.out.println(player2.getDescription());
				
			}else{
				m2 = this.player2.takeTurn(this.rounds, rand);
				m1 = this.player1.takeTurn(this.rounds, rand);
				System.out.println(player2.getDescription());
				System.out.println(player1.getDescription());
			}
			
			//increment the points for each user
			if((m1 == Move.WAR)&&(m2 == Move.WAR)){
				this.player1Points++;
				this.player2Points++;
				System.out.println("Everyone to arms!\n");
			}
			
			if((m1 == Move.WAR)&&(m2 == Move.PEACE)){
				this.player1Points += 5;
				System.out.println(player1.getName() + " crushes " + player2.getName() + "!\n");
			}
			
			if((m1 == Move.PEACE)&&(m2 == Move.WAR)){
				this.player2Points += 5;
				System.out.println(player2.getName() + " crushes " + player1.getName() + "!\n");
			}
			
			if((m1 == Move.PEACE)&&(m2 == Move.PEACE)){
				this.player1Points += 3;
				this.player2Points += 3;
				System.out.println("Peace for everyone!\n");
			}
			
		}	
	}//play
	
	public int getPlayer1Score(){
		return this.player1Points;
	}//getPlayer1Score
	
	public int getPlayer2Score(){
		return this.player2Points;
	}//getPlayer2Score
	
	public static void main(String[] args){
		
		if(!args[1].equals("ai")){
			RandomPlayer player1 = new RandomPlayer();
			player1.name = "Player 1";
			HumanPlayer player2 = new HumanPlayer();
			player2.name = "Player 2";	
			
			PeaceWarGame gameTime = new PeaceWarGame(player1,player2,Integer.parseInt(args[0]));
			gameTime.play();
			
			System.out.println("Final");
			System.out.println(player1.getName() + ": " + gameTime.player1Points);
			System.out.println(player2.getName() + ": " + gameTime.player2Points);
			
			if(gameTime.getPlayer1Score() > gameTime.getPlayer2Score())
			{
				System.out.println("\n>>> Sweet victory for " + player1.getName() + "! <<<");
			}
			else if(gameTime.getPlayer1Score() < gameTime.getPlayer2Score())
			{
				System.out.println("\n>>> Sweet victory for " + player2.getName() + "! <<<");
			}
			else
			{
				System.out.println("\n>>> Its a tie :( <<<");
			}
		}
		else if(!args[1].equals("player"))
		{
			RandomPlayer player1 = new RandomPlayer();
			player1.name = "Player 1";
			OptimusPrime player2 = new OptimusPrime();
			//player2.name = "Player 2";		
			PeaceWarGame gameTime = new PeaceWarGame(player1,player2,Integer.parseInt(args[0]));
			
			gameTime.play();
			
			System.out.println("Final");
			System.out.println(player1.getName() + ": " + gameTime.player1Points);
			System.out.println(player2.getName() + ": " + gameTime.player2Points);
			
			if(gameTime.getPlayer1Score() > gameTime.getPlayer2Score())
			{
				System.out.println("\n>>> Sweet victory for " + player1.getName() + "! <<<");
			}
			else if(gameTime.getPlayer1Score() < gameTime.getPlayer2Score())
			{
				System.out.println("\n>>> Sweet victory for " + player2.getName() + "! <<<");
			}else
			{
				System.out.println("\n>>> Its a tie :( <<<");
			}
		}
	}//main
}
