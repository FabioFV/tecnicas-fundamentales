/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import java.util.*;

public class Game {

    private Stack<Point> mPoints = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    private Player mFirstPlayer, mSecondPlayer, mServerPlayer;
    private Player mWinner = null, mLoser = null;

    Boolean mTieBreak;

    public Game(Player firstPlayer, Player secondPlayer, Player serverPlayer, Boolean tieBreak)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mTieBreak = tieBreak;

        mPlayersWins.put(mFirstPlayer, 0);
        mPlayersWins.put(mSecondPlayer, 0);
    }


    public boolean addPoint(Point p)
    {
        mPoints.add(p);

        if(mTieBreak)
        {
            mPlayersWins.replace(p.getScoringPlayer(), mPlayersWins.get(p.getScoringPlayer()) + 1);

            int firstPlayer = mPlayersWins.get(mFirstPlayer);
            int secondPlayer = mPlayersWins.get(mSecondPlayer);

            if(firstPlayer >= secondPlayer)
            {
                if(firstPlayer >= 7 && (firstPlayer - secondPlayer) > 2)
                {
                    mWinner = mFirstPlayer;
                    mLoser = mSecondPlayer;
                    return true;
                }
            }
            else
            {
                if(secondPlayer >= 7 && (secondPlayer - firstPlayer) > 2)
                {
                    mWinner = mSecondPlayer;
                    mLoser = mFirstPlayer;
                    return true;
                }
            }
            return false;
        }
        else
        {
            if(mPlayersWins.containsValue(4))
            {
                if(mPlayersWins.get(p.getScoringPlayer()) == 4)
                {
                    mWinner = p.getScoringPlayer();

                    if(mWinner == mFirstPlayer)
                        mLoser = mSecondPlayer;
                    else
                        mLoser = mFirstPlayer;

                    return true;
                }
                else
                {
                    for (Map.Entry<Player, Integer> entry : mPlayersWins.entrySet()) {
                        if(entry.getValue() == 4)
                            mPlayersWins.replace(entry.getKey(), 3);
                    }
                }
            }
            else
                mPlayersWins.replace(p.getScoringPlayer(), mPlayersWins.get(p.getScoringPlayer()) + 1);

            int firstPlayer = mPlayersWins.get(mFirstPlayer);
            int secondPlayer = mPlayersWins.get(mSecondPlayer);

            if(firstPlayer >= secondPlayer)
            {
                if(firstPlayer >= 4 && (firstPlayer - secondPlayer) > 2)
                {
                    mWinner = mFirstPlayer;
                    mLoser = mSecondPlayer;
                    return true;
                }
            }
            else
            {
                if(secondPlayer >= 4 && (secondPlayer - firstPlayer) > 2)
                {
                    mWinner = mSecondPlayer;
                    mLoser = mFirstPlayer;
                    return true;
                }
            }
            return false;
        }
    }

    public Stack<Point> getPoints() {
        return mPoints;
    }

    public Player getWinner()
    {
        return mWinner;
    }

    public Player getLoser(){
        return mLoser;
    }

    public Player getServerPlayer() {
        return mServerPlayer;
    }

    public Boolean isTieBreak()
    {
        return mTieBreak;
    }
}
