package proyecto_final;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Match {

    private static Match mInstance;
    private static boolean mTiebreakGame;
    private static int mNumSetsToWin;

    private static Player mServerPlayer, mFirstPlayer, mSecondPlayer;
    private static Player mWinner;

    private static Stack<Set> mSets = new Stack<>();
    private static Map<Player, Integer> mPlayersWins = new HashMap<>();

    Match()
    {

    }

    public static Match getInstance() {
        return mInstance;
    }

    public boolean addPoint()
    {
        return false;
    }

    public void setServerPlayer(Player player)
    {
        mServerPlayer = player;
    }

    public static Player getServerPlayer()
    {
        return mServerPlayer;
    }

    public void changeServerPlayer()
    {

    }

    public JSONObject getJSONObject()
    {
        return null;
    }
}
