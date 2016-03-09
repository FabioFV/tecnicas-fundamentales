/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import java.util.*;

public class Set {

    private Boolean mTiebreakGame;
    private Player mFirstPlayer, mSecondPlayer, mServerPlayer;

    private Stack<Game> mGames = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    private Player mWinner = null;

    public Set(Player firstPlayer, Player secondPlayer, Player serverPlayer, Boolean tiebreakGame)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mTiebreakGame = tiebreakGame;

        mGames.add(new Game(mFirstPlayer, mSecondPlayer, mServerPlayer, false));
        mPlayersWins.put(mFirstPlayer, 0);
        mPlayersWins.put(mSecondPlayer, 0);
    }


    public boolean addPoint(Point p)
    {
        Game g = mGames.peek();
        if(g.addPoint(p))
        {
            Player winner = g.getWinner();
            Player loser = g.getLoser();

            if(g.isTieBreak()){
                mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);
                mWinner = winner;
                return true;
            }

            mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);

            int gamePointsWinner = mPlayersWins.get(winner);
            int gamePointsLoser = mPlayersWins.get(loser);


            if(gamePointsWinner == 6 && gamePointsLoser == 6 && mTiebreakGame){
                mGames.add(new Game ( mFirstPlayer, mSecondPlayer, mServerPlayer, true));
            }
            else if( gamePointsWinner >= 6 && ( gamePointsWinner - gamePointsLoser ) >= 2 ){
                mWinner = winner;
                return true;
            }
            else {
                mGames.add(new Game(mFirstPlayer, mSecondPlayer, mServerPlayer, false));
            }

        }
        return false;
    }

    public Stack<Game> getGames() {
        return mGames;
    }

    public Player getWinner()
    {
        return mWinner;
    }

}
