package proyecto_final;

import org.json.simple.JSONObject;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Point {

    private Player mPlayer;
    private Shots mShot;
    private String mScore;

    Point(Player player, Shots shot, String score)
    {
        mPlayer = player;
        mShot = shot;
        mScore = score;
    }

    public JSONObject getJSONObject()
    {
        return null;
    }

}
