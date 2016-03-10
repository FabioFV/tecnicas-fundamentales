/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
package proyecto_medio_termino;

import org.json.simple.JSONObject;

public class Point {

    private Player mScoringPlayer;
    private Shots mShot;

    public Point(Player scoringPlayer, Shots shot){
        mScoringPlayer = scoringPlayer;
        mShot = shot;
    }

    public Player getScoringPlayer() {
        return mScoringPlayer;
    }

    public Shots getShot() {
        return mShot;
    }

    public JSONObject getJSONObject()
    {
        JSONObject object = new JSONObject();
        object.put("player", mScoringPlayer.toString());
        object.put("shot", mShot.toString());
        return object;
    }
}
