package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Semaphore;

public class Reader implements Runnable {

    private File mFile;
    static Semaphore semaphore = new Semaphore(4);

    Reader(File file)
    {
        mFile = file;
    }

    @Override
    public void run() {
        try
        {
            semaphore.acquire();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(mFile));
                String linea = null;
                int count = 0;
                while ((linea = br.readLine()) != null)
                {
                    String palabra = linea.toLowerCase();
                    if(palabra.equals(new StringBuilder(palabra).reverse().toString()))
                        count++;
                }
                System.out.println(mFile.getName() + ": " + count + " palindromos.");
                semaphore.release();
                Main.jobDone();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }

    }
}
