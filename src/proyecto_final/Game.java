package proyecto_final;

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

    Game()
    {

    }

    public boolean addPoint()
    {
        return false;
    }

    public JSONObject getJSONObject()
    {
        return null;
    }

}
