package proyecto_final.test;

import org.junit.Test;
import proyecto_final.*;

import static org.junit.Assert.*;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class GameTest {

    @Test
    public void addPoint() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,true);

        Game game = new Game(false);

        for (int i = 0; i < 3; i++) {
            game.addPoint(new Point(p1, Shots.BACKHAND));
        }
        assertEquals(true, game.addPoint(new Point(p1, Shots.BACKHAND)));
    }

    @Test
    public void addPointWithTiebreak() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,true);

        Game game = new Game(true);

        for (int i = 0; i < 6; i++) {
            game.addPoint(new Point(p1, Shots.BACKHAND));
        }
        assertEquals(true, game.addPoint(new Point(p1, Shots.BACKHAND)));
    }

    @Test
    public void calculateScore() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,true);

        Game game = new Game(false);

        game.addPoint(new Point(p1, Shots.BACKHAND));
        assertEquals("15 - 0", game.calculateScore());

        game.addPoint(new Point(p1, Shots.BACKHAND));
        assertEquals("30 - 0", game.calculateScore());

        game.addPoint(new Point(p2, Shots.BACKHAND));
        assertEquals("30 - 15", game.calculateScore());

        game.addPoint(new Point(p2, Shots.BACKHAND));
        assertEquals("30 - 30", game.calculateScore());

        game.addPoint(new Point(p1, Shots.BACKHAND));
        assertEquals("40 - 30", game.calculateScore());

        game.addPoint(new Point(p2, Shots.BACKHAND));
        assertEquals("40 - 40", game.calculateScore());

        game.addPoint(new Point(p1, Shots.BACKHAND));
        assertEquals("ADV - 40", game.calculateScore());
    }

    @Test
    public void ordinalToTennisPoint() throws Exception {
        Game game = new Game(false);
        assertEquals(15, game.ordinalToTennisPoint(1));
        assertEquals(30, game.ordinalToTennisPoint(2));
        assertEquals(40, game.ordinalToTennisPoint(3));
    }


}