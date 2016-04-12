package proyecto_final.test;

import org.junit.Before;
import org.junit.Test;
import proyecto_final.Match;
import proyecto_final.Player;
import proyecto_final.Point;
import proyecto_final.Shots;

import static org.junit.Assert.*;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class MatchTest {

    private Match mMatch;
    private Player p1 = new Player("Player", "1", "Right");
    private Player p2 = new Player("Player", "2", "Left");

    @Before
    public void setUp() throws Exception {
        mMatch = Match.getInstance();
        mMatch.init(p1,p2,p1,2,true);
    }

    @Test
    public void addPoint() throws Exception {
        for (int i = 0; i < 47; i++) {
            mMatch.addPoint(new Point(p1, Shots.BACKHAND));
        }
        assertTrue(mMatch.addPoint(new Point(p1, Shots.BACKHAND)));
    }

    @Test
    public void changeServerPlayer() throws Exception {
        Player p1 = Match.getServerPlayer();
        Match.changeServerPlayer();
        Player p2 = Match.getServerPlayer();
        assertNotSame(p1, p2);
    }
}