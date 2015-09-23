import java.util.Random;


public interface Player {

	/**
     * @return the name of this player
     */
    public String getName();

    /**
     * @return a one sentence description describing this player's strategy
     */
    public String getDescription();


    /**
     * Sets the number of rounds of the Peace-war Game that the player will play.
     * Assume that setNumRounds(n) is invoked before the game begins to inform
     * the player that the game will take n rounds.  If this player does not
     * keep track of the rounds, setNumRounds does nothing.
     * @param rounds the total number of rounds the Peace-war Game will have
     */
    public void setNumRounds(int rounds);

    /**
     * @return the Move to be played for the current round.
     */
    public Move takeTurn(int num, Random rand);

    /**
     * Records the opponent's move for this round.  If this player does not
     * make decisions based off of their opponent's actions,
     * recordOpponentMove does nothing.
     * @param num the round number
     * @param move the move
     */
    public void recordOpponentMove(int num, Move move);
}
