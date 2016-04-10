package lab4;

import java.io.File;
import java.nio.file.Paths;

public class Main {

    private static int threadDones = 0;
    private static int totalFiles = 0;
    private static long startTime;

    public static void main(String args[])
    {
        startTime = System.currentTimeMillis();

        File folder = new File(Paths.get(System.getProperty("user.dir")).toString());
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                ++totalFiles;
               new Thread(new Reader(file)).start();
            }
        }

    }

    public synchronized static void jobDone()
    {
        threadDones++;
        if(threadDones == totalFiles)
        {
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo total: " + totalTime + " milisegundos");
        }
    }

}
