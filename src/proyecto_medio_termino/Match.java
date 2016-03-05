package proyecto_medio_termino;

/**
 * Created by Luis Pujols [1057385], Fabio Ferreras [1057332] , Loammi Alberto [1058366]
 */
public class Match {

    private Boolean mTiebreakGame;
    private Integer mNumSetsToWin;
    private Player mServerPlayer;
    private Player mFirstPlayer, mSecondPlayer;

    public Match(Player firstPlayer, Player secondPlayer, Player serverPlayer, Integer numSetsToWin, Boolean tiebreakGame)
    {
        mFirstPlayer = firstPlayer;
        mSecondPlayer = secondPlayer;
        mServerPlayer = serverPlayer;
        mNumSetsToWin = numSetsToWin;
        mTiebreakGame = tiebreakGame;
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
}
