package proyecto_medio_termino;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
public class Match {

    private Boolean mTiebreakGame;
    private Integer mNumSetsToWin;
    private Player mServerPlayer;
    private Player mFirstPlayer, mSecondPlayer;
    private Player mWinner = null;

    private Stack<Set> mSets = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    public Match(Player firstPlayer, Player secondPlayer, Player serverPlayer, Integer numSetsToWin, Boolean tiebreakGame)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mNumSetsToWin = numSetsToWin;
        mTiebreakGame = tiebreakGame;

        mSets.add(new Set(mFirstPlayer, mSecondPlayer, mServerPlayer, mTiebreakGame));
        mPlayersWins.put(mFirstPlayer, 0);
        mPlayersWins.put(mSecondPlayer, 0);
    }

    public Boolean addPoint(Point p)
    {
        Set s = mSets.peek();

        if(s.addPoint(p))
        {
            Player winner = s.getWinner();
            System.out.println(winner);
            mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);

            if(mPlayersWins.get(winner).equals(mNumSetsToWin))
            {
                mWinner = winner;
                return true;
            }
            else
                mSets.add(new Set(mFirstPlayer, mSecondPlayer, mServerPlayer, mTiebreakGame));
        }
        return false;
    }

    public Stack<Set> getSets() {
        return mSets;
    }

    public Player getWinner() {
        return mWinner;
    }

    public Boolean getTiebreakGame() {
        return mTiebreakGame;
    }

    public Integer getNumSetsToWin() {
        return mNumSetsToWin;
    }

    public Player getServerPlayer() {
        return mServerPlayer;
    }

    public Player getFirstPlayer() {
        return mFirstPlayer;
    }

    public Player getSecondPlayer() {
        return mSecondPlayer;
    }

    public JSONObject getJSONObject()
    {
        JSONObject object = new JSONObject();
        object.put("winner", mWinner.toString());

        JSONArray setArray = new JSONArray();
        while(!mSets.isEmpty())
            setArray.add(mSets.pop().getJSONObject());

        object.put("set", setArray);

        return object;
    }
}
