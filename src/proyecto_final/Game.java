package proyecto_final;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Game {

    private Player mWinner;
    private Stack<Point> mPoints = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();
    private boolean mTiebreakGame;

    public Game(boolean tiebreakGame){
        mPlayersWins.put(Match.getFirstPlayer(), 0);
        mPlayersWins.put(Match.getSecondPlayer(), 0);
        mTiebreakGame = tiebreakGame;
    }

    public boolean addPoint(Point p)
    {
        mPoints.add(p);

        if(mTiebreakGame)
        {
            mPlayersWins.replace(p.getPlayer(), mPlayersWins.get(p.getPlayer()) + 1);
            p.setScore(calculateScore());

            int firstPlayer = mPlayersWins.get(Match.getFirstPlayer());
            int secondPlayer = mPlayersWins.get(Match.getSecondPlayer());

            if(firstPlayer >= secondPlayer)
            {
                if(firstPlayer >= 7 && (firstPlayer - secondPlayer) > 2)
                {
                    mWinner = Match.getFirstPlayer();
                    return true;
                }
            }
            else
            {
                if(secondPlayer >= 7 && (secondPlayer - firstPlayer) > 2)
                {
                    mWinner = Match.getSecondPlayer();
                    return true;
                }
            }
            return false;
        }
        else
        {
            if(mPlayersWins.containsValue(4))
            {
                if(mPlayersWins.get(p.getPlayer()) == 4)
                {
                    mWinner = p.getPlayer();
                    p.setScore("GAME");
                    return true;
                }
                else
                {
                    for (Map.Entry<Player, Integer> entry : mPlayersWins.entrySet()) {
                        if(entry.getValue() == 4)
                            mPlayersWins.replace(entry.getKey(), 3);
                    }
                    p.setScore(calculateScore());
                }
            }
            else
            {
                mPlayersWins.replace(p.getPlayer(), mPlayersWins.get(p.getPlayer()) + 1);
                p.setScore(calculateScore());
            }


            int firstPlayer = mPlayersWins.get(Match.getFirstPlayer());
            int secondPlayer = mPlayersWins.get(Match.getSecondPlayer());

            if(firstPlayer >= secondPlayer)
            {
                if(firstPlayer >= 4 && (firstPlayer - secondPlayer) > 2)
                {
                    mWinner = Match.getFirstPlayer();
                    return true;
                }
            }
            else
            {
                if(secondPlayer >= 4 && (secondPlayer - firstPlayer) > 2)
                {
                    mWinner = Match.getSecondPlayer();
                    return true;
                }
            }
            return false;
        }
    }

    public String calculateScore()
    {
        int serverPoint, secondPoint;

        if(Match.getServerPlayer() == Match.getFirstPlayer())
        {
            serverPoint = mPlayersWins.get(Match.getFirstPlayer());
            secondPoint = mPlayersWins.get(Match.getSecondPlayer());
        }
        else
        {
            serverPoint = mPlayersWins.get(Match.getSecondPlayer());
            secondPoint = mPlayersWins.get(Match.getFirstPlayer());
        }

        if(!mTiebreakGame)
        {
            serverPoint = ordinalToTennisPoint(serverPoint);
            secondPoint = ordinalToTennisPoint(secondPoint);

            if(serverPoint == 4 && secondPoint == 40)
                return "ADV - 40";
            else if(serverPoint == 40 && secondPoint == 4)
                return "40 - ADV";
            else if(serverPoint == 4 || secondPoint == 4)
                return "GAME";
            else
                return serverPoint + " - " + secondPoint;
        }
        else
            return serverPoint + " - " + secondPoint;
    }

    public int ordinalToTennisPoint(int n)
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

    public JSONObject getJSONObject()
    {
        JSONObject object = new JSONObject();
        object.put("tiebreak", mTiebreakGame);
        object.put("winner", mWinner.toString());

        JSONArray pointsArray = new JSONArray();
        while(!mPoints.isEmpty())
            pointsArray.add(mPoints.pop().getJSONObject());

        object.put("point", pointsArray);

        return object;
    }

    public Player getWinner() {
        return mWinner;
    }

    public boolean isTiebreakGame() {
        return mTiebreakGame;
    }
}
