package proyecto_final;

import org.json.simple.JSONObject;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Point {

    private Player mPlayer;
    private Shots mShot;
    private String mScore;

    public Point(Player player, Shots shot)
    {
        mPlayer = player;
        mShot = shot;
    }
    
    public Player getPlayer()
    {
        return mPlayer;
    }

    public Shots getShot()
    {
        return mShot;
    }
    public void setPlayer(Player player)
    {
        mPlayer = player;
    }
    public void setShot(Shots shot)
    {
        mShot = shot;
    }
    public void setScore(String score)
    {
        mScore = score;
    }

    public JSONObject getJSONObject()
    {
        return null;
    }
}
