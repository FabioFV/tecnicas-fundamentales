package proyecto_final;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Match {

    private static Match mInstance = null;
    private static boolean mTiebreakGame;
    private static int mNumSetsToWin;

    private static Player mServerPlayer, mFirstPlayer, mSecondPlayer;
    private static Player mWinner;

    private static Stack<Set> mSets = new Stack<>();
    private static Map<Player, Integer> mPlayersWins = new HashMap<>();

    public static Match getInstance() {
        if(mInstance == null)
            mInstance = new Match();
        return mInstance;
    }

    public void init(Player firstPlayer, Player secondPlayer, Player serverPlayer, Integer numSetsToWin, Boolean tiebreakGame)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mNumSetsToWin = numSetsToWin;
        mTiebreakGame = tiebreakGame;
    }

    public boolean addPoint(Point p)
    {
        return false;
    }

    public static Player getServerPlayer()
    {
        return mServerPlayer;
    }

    public static void changeServerPlayer()
    {
        if(mServerPlayer == mFirstPlayer){
            mServerPlayer = mSecondPlayer;
        }else{
            mServerPlayer = mFirstPlayer;
        }
    }

    public JSONObject getJSONObject()
    {
        return null;
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

    public Player getFirstPlayer() {
        return mFirstPlayer;
    }

    public Player getSecondPlayer() {
        return mSecondPlayer;
    }
}
