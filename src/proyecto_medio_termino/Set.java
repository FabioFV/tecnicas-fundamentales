/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Set {

    private Boolean mTiebreakGame;
    private Player mFirstPlayer, mSecondPlayer, mServerPlayer;

    private Queue<Game> mGames = new LinkedList<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    public Set(Player firstPlayer, Player secondPlayer, Player serverPlayer, Boolean tiebreakGame)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mTiebreakGame = tiebreakGame;

        mGames.add(new Game(mFirstPlayer, mSecondPlayer, mServerPlayer));
        mPlayersWins.put(mFirstPlayer, 0);
        mPlayersWins.put(mSecondPlayer, 0);
    }


    public boolean addPoint(Point p)
    {
        Game g = mGames.peek();
        if(g.addPoint(p))
        {
            Player winner = g.getWinner();
            mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);
            //// TODO: LOGIC FOR CHECK IF THE SET IS OVER
            //// IF IS OVER RETURN TRUE
        }
        return false;
    }

    public Player getWinner()
    {
        return null;
    }

}
