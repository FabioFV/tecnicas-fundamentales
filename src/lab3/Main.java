package lab3;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by Fabio Ferreras on 4/2/2016.
 */
public class Main {

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        File folder = new File(Paths.get(System.getProperty("user.dir")).toString());
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Reader r = new Reader(file.getAbsoluteFile());
            }
        }
        long endTime   = System.currentTimeMillis();

        long totalTime = endTime - startTime;
        System.out.println("Tiempo total: " + totalTime + " milisegundos");
    }

}
