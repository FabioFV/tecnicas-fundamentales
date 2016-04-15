package proyecto_final;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class Set {

    private Player mWinner;
    private Stack<Game> mGames = new Stack<>();
    private Map<Player, Integer> mPlayersWins = new HashMap<>();

    public Set(){
        mGames.add(new Game(false));
        mPlayersWins.put(Match.getFirstPlayer(), 0);
        mPlayersWins.put(Match.getSecondPlayer(), 0);
    }

    public boolean addPoint(Point p)
    {
        Game g = mGames.peek();
        if(g.addPoint(p))
        {
            Player winner = g.getWinner();
            Player loser;

            if(Match.getFirstPlayer().equals(g.getWinner()))
                loser = Match.getSecondPlayer();
            else
                loser = Match.getFirstPlayer();

            if(g.isTiebreakGame()){
                mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);
                mWinner = winner;
                return true;
            }

            mPlayersWins.replace(winner, mPlayersWins.get(winner) + 1);

            int gamePointsWinner = mPlayersWins.get(winner);
            int gamePointsLoser = mPlayersWins.get(loser);


            if(gamePointsWinner == 6 && gamePointsLoser == 6 && Match.isTiebreakGame()){
                Match.changeServerPlayer();
                mGames.add(new Game(true));
            }
            else if( gamePointsWinner >= 6 && ( gamePointsWinner - gamePointsLoser ) >= 2 ){
                mWinner = winner;
                return true;
            }
            else {
                Match.changeServerPlayer();
                mGames.add(new Game(false));
            }

        }
        return false;
    }

    public JSONObject getJSONObject()
    {
        JSONObject object = new JSONObject();
        object.put("winner", mWinner.toString());

        JSONArray gamesArray = new JSONArray();
        while(!mGames.isEmpty())
            gamesArray.add(mGames.pop().getJSONObject());

        object.put("game", gamesArray);

        return object;
    }

    public Stack<Game> getGames() {
        return mGames;
    }

    public Player getWinner()
    {
        return mWinner;
    }

}
