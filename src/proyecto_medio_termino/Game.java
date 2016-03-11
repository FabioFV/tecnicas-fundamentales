/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366], Jorge Contin [1057170]
 */
package proyecto_medio_termino;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
            p.setScore(calculateScore(p));

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
                    p.setScore("GAME");

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
                    p.setScore(calculateScore(p));
                }
            }
            else
            {
                mPlayersWins.replace(p.getScoringPlayer(), mPlayersWins.get(p.getScoringPlayer()) + 1);
                p.setScore(calculateScore(p));
            }


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

    private String calculateScore(Point p)
    {
        int serverPoint, secondPoint;

        if(mServerPlayer == mFirstPlayer)
        {
            serverPoint = mPlayersWins.get(mFirstPlayer);
            secondPoint = mPlayersWins.get(mSecondPlayer);
        }
        else
        {
            serverPoint = mPlayersWins.get(mSecondPlayer);
            secondPoint = mPlayersWins.get(mFirstPlayer);
        }

        serverPoint = ordinalToTennisPoint(serverPoint);
        secondPoint = ordinalToTennisPoint(secondPoint);

        if(serverPoint == 4 && secondPoint == 40)
            return "ADV - 40";
        else if(serverPoint == 40 && secondPoint == 4)
            return "40 - ADV";
        else if(serverPoint == 4)
            return "GAME";
        else if(secondPoint == 4)
            return "GAME";
        else
            return serverPoint + " - " + secondPoint;
    }

    private int ordinalToTennisPoint(int n)
    {
        switch (n)
        {
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
            default:
                return n;
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

    public JSONObject getJSONObject()
    {
        JSONObject object = new JSONObject();
        object.put("tiebreak", mTieBreak);
        object.put("winner", mWinner.toString());

        JSONArray pointsArray = new JSONArray();
        while(!mPoints.isEmpty())
            pointsArray.add(mPoints.pop().getJSONObject());

        object.put("point", pointsArray);

        return object;
    }
}
