package proyecto_final;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Set {

    private Player mWinner;
    private  Stack<Game> mGames = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    public Set(){}

    public boolean addPoint(Point p)
    {
        return false;
    }

    public JSONObject getJSONObject()
    {
        return null;
    }

    public Stack<Game> getGames() {
        return mGames;
    }

    public Player getWinner()
    {
        return mWinner;
    }

}
