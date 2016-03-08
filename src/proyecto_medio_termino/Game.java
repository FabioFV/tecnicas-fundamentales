/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Game {

    private Queue<Point> mPoints = new LinkedList<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    private Player mFirstPlayer, mSecondPlayer, mServerPlayer;
    private Player mWinner = null;

    public Game(Player firstPlayer, Player secondPlayer, Player serverPlayer)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
    }


    public boolean addPoint(Point p)
    {
        mPoints.add(p);
        mPlayersWins.replace(p.getScoringPlayer(), mPlayersWins.get(p.getScoringPlayer()) + 1);
        //// TODO: LOGIC FOR CHECK IF THE GAME IS OVER
        //// RETURN TRUE IF THE GAME IS OVER
        return false;
    }

    public Player getWinner()
    {
        return mWinner;
    }
}
