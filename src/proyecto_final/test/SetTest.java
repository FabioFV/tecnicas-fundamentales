package proyecto_final.test;

import org.junit.Test;
import proyecto_final.Player;
import proyecto_final.Point;
import proyecto_final.Set;
import proyecto_final.Shots;

import static org.junit.Assert.*;

/**
 * Created by Fabio Ferreras [1057332], Luis Pujols [1057385], Loammi Alberto [1058366], Jorge Contin [1057170]
 */

public class SetTest {

    @Test
    public void addPoint() throws Exception {
        Set set = new Set();
        Player p1 = new Player("Player", "1", "Right");

        for (int i = 0; i < 23; i++) {
            set.addPoint(new Point(p1, Shots.BACKHAND, ""));
        }
        assertTrue(set.addPoint(new Point(p1, Shots.BACKHAND, "")));
    }

}