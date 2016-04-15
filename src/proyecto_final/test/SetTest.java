package proyecto_final.test;

import org.junit.Test;
import proyecto_final.*;

import static org.junit.Assert.*;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class SetTest {

    @Test
    public void addPointSingle() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,false);
        Set set = new Set();

        for (int i = 0; i < 23; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        assertTrue(set.addPoint(new Point(p1, Shots.BACKHAND)));
    }

    @Test
    public void addPointWithoutTiebreak() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,false);
        Set set = new Set();

        for (int i = 0; i < 20; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        for (int i = 0; i < 20; i++) {
            set.addPoint(new Point(p2, Shots.BACKHAND));
        }
        // 5 - 5
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p2, Shots.BACKHAND));
        }

        // 6 - 6
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p2, Shots.BACKHAND));
        }

        //7 - 7
        for (int i = 0; i < 7; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }

        assertTrue(set.addPoint(new Point(p1, Shots.BACKHAND)));
    }

    @Test
    public void addPointWithTiebreak() throws Exception {
        Match match = Match.getInstance();
        Player p1 = new Player("Player", "1", "Right");
        Player p2 = new Player("Player", "2", "Left");
        match.init(p1,p2,p1,2,true);
        Set set = new Set();

        for (int i = 0; i < 20; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        for (int i = 0; i < 20; i++) {
            set.addPoint(new Point(p2, Shots.BACKHAND));
        }
        // 5 - 5
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }
        for (int i = 0; i < 4; i++) {
            set.addPoint(new Point(p2, Shots.BACKHAND));
        }

        // 6 - 6
        for (int i = 0; i < 6; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND));
        }

        assertTrue(set.addPoint(new Point(p1, Shots.BACKHAND)));
    }

}